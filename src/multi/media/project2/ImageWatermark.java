/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multi.media.project2;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 *
 * @author Hussain
 */
public class ImageWatermark implements Action {

    private int x;
    private int y;
    private float alpha;
    private BufferedImage waterMark;
    
    public ImageWatermark(int x, int y, float alpha, BufferedImage waterMark) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
        this.waterMark = waterMark;
    }

    @Override 
    public Action deepCopy()
    {
        ColorModel cm = this.waterMark.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = this.waterMark.copyData(this.waterMark.getRaster().createCompatibleWritableRaster());
        BufferedImage newWaterMark =  new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        
        
        return new ImageWatermark(
                this.x , this.y , this.alpha , newWaterMark);
    }
    @Override
    public BufferedImage apply(BufferedImage frame) {
        return addImageWatermark(frame,waterMark,alpha,x,y);
    }
    
    private BufferedImage addImageWatermark(BufferedImage frame, BufferedImage watermarkImage, float alpha, int x, int y) {

        Graphics2D g2d = (Graphics2D) frame.getGraphics();
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alphaChannel);
        int topLeftX = (frame.getWidth() * x / 100) - (int) watermarkImage.getWidth()/2;
        int topLeftY = (frame.getHeight() * y / 100) - (int) watermarkImage.getHeight()/2;
        g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);
        g2d.dispose();
        return frame;

    }
}
