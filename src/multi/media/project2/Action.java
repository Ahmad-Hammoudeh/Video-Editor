/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package multi.media.project2;

import java.awt.image.BufferedImage;

/**
 *
 * @author Hussain
 */
public interface Action {
    public BufferedImage apply(BufferedImage frame);
    
    public Action deepCopy();
    
}
