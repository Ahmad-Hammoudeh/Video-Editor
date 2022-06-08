/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multi.media.project2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hussain
 */
public class TextWaterMark implements Action {

    private String text;
    private int x;
    private int y;
    private Color color;
    private float alpha;
    private int fontSize;

    public TextWaterMark(String text, int x, int y, Color color, float alpha, int fontSize) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
        this.alpha = alpha;
        this.fontSize = fontSize;
    }

    @Override
    public BufferedImage apply(BufferedImage frame) {
        return addTextWatermark(frame, text, alpha, color, fontSize, x, y);
    }

    private BufferedImage addTextWatermark(BufferedImage frame, String text, float alpha, Color color, int fontSize, int x, int y) {
        Graphics2D g2d = (Graphics2D) frame.getGraphics();
        // initializes necessary graphic properties
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(alphaChannel);
        g2d.setColor(color);
        g2d.setFont(new Font("Arial", Font.BOLD, fontSize));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

        int centerX = (frame.getWidth() * x / 100)-(int) rect.getWidth()/2;
        int centerY = (frame.getHeight() * y / 100) + (int) rect.getHeight()/2;
        System.err.println(centerX);
        System.err.println(frame.getWidth());
        // paints the textual watermark
        g2d.drawString(text, centerX, centerY);
        g2d.dispose();
        return frame;

    }

}
