/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package multi.media.project2.View;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import multi.media.project2.VideoEditor;

/**
 *
 * @author User
 */
public class addWatermarkFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeleteFrame
     */
    String imagePath = null;
    Color color = Color.BLACK;
    VideoEditor videoEditor;

    public addWatermarkFrame(VideoEditor videoEditor) {
        this.videoEditor = videoEditor;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        fromBox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        toBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        xBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        yBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textBox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fontBox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        alphaBox = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Add Watermark");
        jPanel1.add(jLabel2);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("        form:");
        jPanel4.add(jLabel5);

        fromBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(fromBox);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("                      to:");
        jPanel4.add(jLabel9);

        toBox.setPreferredSize(new java.awt.Dimension(100, 28));
        toBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toBoxActionPerformed(evt);
            }
        });
        jPanel4.add(toBox);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("              PosX :");
        jPanel4.add(jLabel4);

        xBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(xBox);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("              PosX :");
        jPanel4.add(jLabel6);

        yBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(yBox);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("                 Text :");
        jPanel4.add(jLabel7);

        textBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(textBox);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("        Font Size :");
        jPanel4.add(jLabel10);

        fontBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(fontBox);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("              Alpha :");
        jPanel4.add(jLabel8);

        alphaBox.setPreferredSize(new java.awt.Dimension(100, 28));
        jPanel4.add(alphaBox);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("                                                   ");
        jPanel4.add(jLabel13);

        jButton1.setText("Choose Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton2.setText("Choose Color");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setText("Confirm");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel1.add(jPanel4);

        jLabel3.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Add Watermark");
        jPanel1.add(jLabel3);

        jLabel11.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Add Watermark");
        jPanel1.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Add Watermark");
        jPanel1.add(jLabel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = fileChooser.showDialog(null, null);

        if (r == JFileChooser.APPROVE_OPTION) {
            this.imagePath = (fileChooser.getSelectedFile().getAbsolutePath());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Color initialcolor = Color.BLACK;
        Color scolor = JColorChooser.showDialog(this, "Select a color", initialcolor);
        color = scolor;

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int from = Integer.parseInt(fromBox.getText());
        int to = Integer.parseInt(toBox.getText());
        int x = Integer.parseInt(xBox.getText());
        int y = Integer.parseInt(yBox.getText());
        float alpha = Float.parseFloat(alphaBox.getText());

        if (imagePath != null) {
            System.out.println(imagePath);
            try {
                BufferedImage watermarkImage = ImageIO.read(new File(imagePath));
                videoEditor.addImageWaterMark(from, to, watermarkImage, alpha, x, y);
            } catch (Exception ex) {
            }

        } else {
            Color selected_Color = color;
            String text = textBox.getText();
            int fontSize = Integer.parseInt(fontBox.getText());
            videoEditor.addTextWatermark(from, to, text, alpha, color, fontSize, x, y);
        }

        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void toBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addWatermarkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addWatermarkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addWatermarkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addWatermarkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new addWatermarkFrame(videoEditor).setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alphaBox;
    private javax.swing.JTextField fontBox;
    private javax.swing.JTextField fromBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField textBox;
    private javax.swing.JTextField toBox;
    private javax.swing.JTextField xBox;
    private javax.swing.JTextField yBox;
    // End of variables declaration//GEN-END:variables
}
