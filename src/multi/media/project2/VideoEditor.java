package multi.media.project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;
import org.opencv.imgproc.Imgproc;

class Frame {

    public int index;
    public ArrayList<Action> actions;

    public Frame(int index) {
        this.index = index;
        this.actions = new ArrayList<>();

    }

    public Frame deepCopy() {
        Frame newFrame = new Frame(this.index);
        ArrayList<Action> newActionList = new ArrayList<>();

        for (int i = 0; i < this.actions.size(); i++) {
            Action newAction = this.actions.get(i).deepCopy();
            newActionList.add(newAction);
        }
        newFrame.actions = newActionList;
        return newFrame;
    }
}

public class VideoEditor implements Runnable {

    private Thread thread;
    JLabel ImageLabel;
    String videoPath;

    Stack<ArrayList<Frame>> lastEdits = new Stack<>();
    ArrayList<Frame> frameList = new ArrayList<>();
    String output = "test.mp4";
    String path = System.getProperty("user.dir") + "\\temp\\";
    VideoCapture cap;
    VideoWriter videoWriter;
    int currentFrameIndex;
    int startEditingFrame;
    int endEditingFrame;
    int frameStep;
    int numOfFrames;
    int vedioLenght;
    int numOfFramesPerSecond;
    Size frameSize;
    Boolean isPlay;

    float heightResult;
    float widthResult;

    private void resizeLabel() {
        float height_Img = (float) cap.get(Videoio.CAP_PROP_FRAME_HEIGHT);

        float width_Img = (float) cap.get(Videoio.CAP_PROP_FRAME_WIDTH);

        float height_Label = ImageLabel.getHeight();
        float width_Label = ImageLabel.getWidth();

        if (height_Img > width_Img) {

            float t = height_Img / height_Label;
            ImageLabel.setSize((int) (width_Img / t), (int) height_Label);
            ImageLabel.setPreferredSize(new Dimension((int) (width_Img / t), (int) height_Label));
            widthResult = (int) (ImageLabel.getWidth());
            heightResult = (int) (ImageLabel.getHeight());

        } else if (height_Img < width_Img) {

            float t = width_Img / width_Label;
            ImageLabel.setSize((int) (width_Label), (int) (height_Img / t));
            ImageLabel.setPreferredSize(new Dimension((int) (width_Label), (int) (height_Img / t)));
            widthResult = (int) (ImageLabel.getWidth());
            heightResult = (int) (ImageLabel.getHeight());

        } else {
            if (width_Label > height_Label) {

                ImageLabel.setSize((int) (height_Label), (int) height_Label);
                ImageLabel.setPreferredSize(new Dimension((int) (height_Label), (int) height_Label));
                widthResult = (int) (ImageLabel.getHeight());
                heightResult = (int) (ImageLabel.getHeight());

            } else {
                widthResult = (int) (ImageLabel.getWidth());
                heightResult = (int) (ImageLabel.getWidth());
            }
        }
    }

    public VideoEditor(JLabel label, String videoPath) {
        String currentPath = System.getProperty("user.dir") + "\\temp";
        File folder = new File(currentPath);
        if (Files.exists(Paths.get(currentPath))) {
            try {
                FileUtils.deleteDirectory(folder);
            } catch (Exception ex) {
            }
        }
        new File(currentPath).mkdir();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.ImageLabel = label;
        this.videoPath = videoPath;
        this.frameStep = 1;
        this.startEditingFrame = 0;
        this.cap = new VideoCapture();
        this.cap.open(videoPath);
        resizeLabel();
        this.numOfFramesPerSecond = (int) cap.get(Videoio.CAP_PROP_FPS);
        this.frameSize = new Size((int) cap.get(Videoio.CAP_PROP_FRAME_WIDTH), (int) cap.get(Videoio.CAP_PROP_FRAME_HEIGHT));
        this.cap.release();
        this.frameList = new ArrayList<>();
        this.numOfFrames = read_frames();
        this.currentFrameIndex = startEditingFrame;
        this.endEditingFrame = this.numOfFrames;
        this.isPlay = false;

        System.out.println(frameList.size());
    }

    public int getCurrentFrameIndex() {
        return currentFrameIndex;
    }

    public void setCurrentFrameIndex(int currentFrameIndex) {
        this.currentFrameIndex = currentFrameIndex;
        viewFrame(currentFrameIndex);
    }

    public int getStartEditingFrame() {
        return startEditingFrame;
    }

    public void setStartEditingFrame(int startEditingFrame) {
        this.startEditingFrame = startEditingFrame;
    }

    public int getEndEditingFrame() {
        return endEditingFrame;
    }

    public void setEndEditingFrame(int endEditingFrame) {
        this.endEditingFrame = endEditingFrame;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setFrameStep(int step) {
        this.frameStep = step;
    }

    public int getFrameStep() {
        return this.frameStep;
    }

    private BufferedImage pngFrameAt(int index) {
        BufferedImage img;
        try {
            img = ImageIO.read(new File(path
                    + String.valueOf(index)
                    + ".png"));
            return img;
        } catch (IOException e) {
            return null;
        }
    }

    private BufferedImage convertMatToBI(Mat matrix) {
        int cols = matrix.cols();
        int rows = matrix.rows();
        int elemSize = (int) matrix.elemSize();
        byte[] data = new byte[cols * rows * elemSize];
        int type;

        matrix.get(0, 0, data);

        switch (matrix.channels()) {
            case 1:
                type = BufferedImage.TYPE_BYTE_GRAY;
                break;

            case 3:
                type = BufferedImage.TYPE_3BYTE_BGR;

                // bgr to rgb
                byte b;
                for (int i = 0; i < data.length; i = i + 3) {
                    b = data[i];
                    data[i] = data[i + 2];
                    data[i + 2] = b;
                }
                break;

            default:
                return null;
        }

        BufferedImage image = new BufferedImage(cols, rows, type);
        image.getRaster().setDataElements(0, 0, cols, rows, data);

        return image;
    }

    public int read_frames() {
        cap.open(videoPath);
        int counter = 0;
        int frameNumber = -1;
        int maxNumber = (int) cap.get(Videoio.CAP_PROP_FRAME_COUNT);
        if (cap.isOpened()) {
            while (counter < maxNumber) {
                Mat tempFrame = new Mat();
                cap.read(tempFrame);
                if (tempFrame.size().empty()) {
                    System.err.println("empty");
                    counter++;
                    continue;
                }
                BufferedImage result = convertMatToBI(tempFrame);
                try {
                    frameNumber++;
                    File outputfile = new File(path
                            + String.valueOf(frameNumber)
                            + ".png");
                    ImageIO.write(result, "png", outputfile);
                    frameList.add(new Frame(frameNumber));
//                    viewFrame(frameNumber);
                } catch (IOException ex) {
                }
                counter++;
                tempFrame.release();

            }
        }
        cap.release();
        return frameNumber;
    }

    private void viewFrame(int index) {
        Frame currentFrame = frameList.get(index);
        BufferedImage frame = applyActions(currentFrame);

        Image dimg = frame.getScaledInstance((int) widthResult, (int) heightResult,
                Image.SCALE_AREA_AVERAGING);

        ImageLabel.setIcon(new ImageIcon(dimg));
    }

    private BufferedImage resizeBI(BufferedImage img, int height, int width) 
    {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    public Mat resizeMat(Mat matImg , int height , int width) 
    {
        Mat resizeimage = new Mat();
        Size sz = new Size(height, width);
        
        Imgproc.resize(matImg, resizeimage, sz);
        
        return resizeimage;
    }
        
    

    /* ========= EDITING ========= */
    private BufferedImage applyActions(Frame frame) {
        BufferedImage tempFrame = pngFrameAt(frame.index);
        for (int i = 0; i < frame.actions.size(); i++) {
            tempFrame = frame.actions.get(i).apply(tempFrame);
        }
        return tempFrame;
    }

    public boolean isEdited() {
        return !lastEdits.isEmpty();
    }

    public void undoStep() {
        frameList = lastEdits.pop();
        currentFrameIndex = 0;
        endEditingFrame = frameList.size() - 1;
        numOfFrames = frameList.size();

        viewFrame(0);
    }

    private void saveStep() {
        ArrayList<Frame> newFrameList = new ArrayList<>();

        for (int i = 0; i < frameList.size(); i++) {
            newFrameList.add(frameList.get(i).deepCopy());
        }
        lastEdits.push(newFrameList);
    }

    public void moveFrames(int startFrame, int endFrame, int to) {
        saveStep();

        if (!(startFrame < frameList.size() && endFrame < frameList.size() - 1 && to < frameList.size())) {
            return;
        }
        ArrayList<Frame> tempList = new ArrayList<>();
        for (int i = startFrame; i <= endFrame; i++) {
            tempList.add(frameList.get(i));
        }
        deleteFrames(startFrame, endFrame);
        frameList.addAll(to, tempList);
        startEditingFrame = 0;
        currentFrameIndex = 0;
        endEditingFrame = frameList.size() - 1;

    }

    public void deleteFrames(int from, int to) {
        saveStep();

        if (!(from < frameList.size() && to < frameList.size() - 1)) {
            return;
        }
        for (int i = to; i >= from; i--) {
            frameList.remove(i);
        }
        startEditingFrame = 0;
        currentFrameIndex = 0;
        endEditingFrame = frameList.size() - 1;
        numOfFrames = frameList.size();
    }

    public void addImageWaterMark(int from, int to, BufferedImage watermarkImage, float alpha, int x, int y) {
        saveStep();
        ImageWatermark imageWatermark = new ImageWatermark(x, y, alpha, watermarkImage);
        for (int i = from; i <= to; i++) {
            frameList.get(i).actions.add(imageWatermark);
        }
        viewFrame(currentFrameIndex);

    }

    public void addTextWatermark(int from, int to, String text, float alpha, Color color, int fontSize, int x, int y) {
        saveStep();

        TextWaterMark textWaterMark = new TextWaterMark(text, x, y, color, alpha, fontSize);
        for (int i = from; i <= to; i++) {
            frameList.get(i).actions.add(textWaterMark);
        }
        viewFrame(currentFrameIndex);

    }
    
    public void addVideoWaterMark(int from , int to , float alpha , int x , int y , String videoPath)
    {
        saveStep();
        
        VideoCapture cap = new VideoCapture();
        cap.open(videoPath);
        int counter = 0;
        int maxNumber = (int) cap.get(Videoio.CAP_PROP_FRAME_COUNT);
        if (cap.isOpened()) 
        {
            while (counter < maxNumber && counter + from <= to) 
            {
                Mat tempFrame = new Mat();
                cap.read(tempFrame);
                if (tempFrame.size().empty()) 
                {
                    System.err.println("empty");
                    counter++;
                    continue;
                }
                BufferedImage result = convertMatToBI(tempFrame);
                
                ImageWatermark imageWatermark = new ImageWatermark(x, y, alpha, result);
                frameList.get(counter + from).actions.add(imageWatermark);
                
                counter++;
                tempFrame.release();
            }
        }
        cap.release();
    }
    /* ================== */
    public void viewNextFrame() {
        if (currentFrameIndex + frameStep <= endEditingFrame) {
            currentFrameIndex += frameStep;
        }
        viewFrame(currentFrameIndex);
    }

    public void viewPreviosFrame() {
        if (currentFrameIndex - frameStep >= startEditingFrame) {
            currentFrameIndex -= frameStep;
        }
        viewFrame(currentFrameIndex);
    }

    public void save() {

    }

    @Override
    public void run() {

//        read_frames();
    }

    public void start() {
        if (thread != null) {
            thread.stop();
        }
        thread = new Thread(this);
        thread.start();

    }

    public void play() {
        isPlay = true;
    }

    public void pause() {
        isPlay = false;
    }

}
