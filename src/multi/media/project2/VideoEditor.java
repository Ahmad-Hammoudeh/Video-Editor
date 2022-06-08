package multi.media.project2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;
import org.opencv.imgcodecs.Imgcodecs;

class Frame {

    public int index;
    public ArrayList<Action> actions;

    public Frame(int index) {
        this.index = index;
        this.actions = new ArrayList<>();

    }
}

public class VideoEditor implements Runnable {

    private Thread thread;
    JLabel ImageLabel;
    String videoPath;
    ArrayList<Frame> frameList = new ArrayList<Frame>();
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

    private void resizeLabel(){
        float height_Img =  (float) cap.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            
        float width_Img = (float) cap.get(Videoio.CAP_PROP_FRAME_WIDTH);

        float height_Label =  ImageLabel.getHeight();
        float width_Label = ImageLabel.getWidth();

        

        if(height_Img > width_Img){

            float t = height_Img / height_Label ;
            ImageLabel.setSize((int) (width_Img / t) , (int) height_Label);
            ImageLabel.setPreferredSize(new Dimension((int) (width_Img / t), (int) height_Label));
            widthResult = (int) (ImageLabel.getWidth() );
            heightResult = (int) (ImageLabel.getHeight());


        }else if( height_Img < width_Img ){

            float t = width_Img / width_Label;
            ImageLabel.setSize((int) (width_Label) , (int) (height_Img / t));
            ImageLabel.setPreferredSize(new Dimension((int) (width_Label), (int) (height_Img / t) ));
            widthResult = (int) (ImageLabel.getWidth() );
            heightResult = (int) (ImageLabel.getHeight());

        }else{
            if(width_Label > height_Label){

                ImageLabel.setSize((int) (height_Label) , (int) height_Label);
                ImageLabel.setPreferredSize(new Dimension((int) (height_Label), (int) height_Label));
                widthResult = (int) (ImageLabel.getHeight() );
                heightResult = (int) (ImageLabel.getHeight());

            }else{
                widthResult = (int) (ImageLabel.getWidth() );
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

    private BufferedImage convertMatToBI(Mat mat) {
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".png", mat, mob);
        byte ba[];
        ba = mob.toArray();
        try {
            return ImageIO.read(new ByteArrayInputStream(ba));
        } catch (IOException ex) {
            return null;
        }
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
        BufferedImage frame = pngFrameAt(currentFrame.index);
        
        frame = applyActions(currentFrame);
        
        Image dimg = frame.getScaledInstance((int)widthResult,(int) heightResult,
                                
        Image.SCALE_AREA_AVERAGING);
        
        ImageLabel.setIcon(new ImageIcon(dimg));
    }

    private BufferedImage applyActions(Frame frame) {
        BufferedImage tempFrame = pngFrameAt(frame.index);
        for (int i = 0; i < frame.actions.size(); i++) {
            tempFrame = frame.actions.get(i).apply(tempFrame);
        }
        return tempFrame;
    }

    public void moveFrames(int startFrame, int endFrame, int to) {
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

    public void deleteFrames(int from, int to) {
        if (!(from < frameList.size() && to < frameList.size() - 1)) {
            return;
        }
        for (int i = to; i >= from; i--) {
            frameList.remove(i);
        }
        startEditingFrame = 0;
        currentFrameIndex = 0;
        endEditingFrame = frameList.size() - 1;
    }
    

    public void addImageWaterMark(int from, int to, BufferedImage watermarkImage, float alpha, int x, int y) {
        ImageWatermark imageWatermark = new ImageWatermark(x, y, alpha, watermarkImage);
        for (int i = from; i <= to; i++) {
            frameList.get(i).actions.add(imageWatermark);
        }
        viewFrame(currentFrameIndex);

    }

    public void addTextWatermark(int from, int to, String text, float alpha, Color color, int fontSize, int x, int y) {
        TextWaterMark textWaterMark = new TextWaterMark(text, x, y, color, alpha, fontSize);
        for (int i = from; i <= to; i++) {
            frameList.get(i).actions.add(textWaterMark);
        }
        viewFrame(currentFrameIndex);

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
