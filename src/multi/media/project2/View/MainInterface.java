/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package multi.media.project2.View;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import multi.media.project2.VideoEditor;
import org.opencv.videoio.VideoCapture;

public class MainInterface extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    VideoEditor videoEditor;
    String videoPath = null;

    public MainInterface() {
        initComponents();
        setPanelEnabled(controlPanel, false);
        chooseButton.setEnabled(true);
        mainLabel.setEnabled(true);
    }
    public void reset(){
            frameSlider.setMinimum(videoEditor.getStartEditingFrame());
            frameSlider.setMaximum(videoEditor.getEndEditingFrame());
            startFrameBox.setText(String.valueOf(videoEditor.getStartEditingFrame()));
            endFramBox.setText(String.valueOf(videoEditor.getEndEditingFrame()));
            currentFrameBox.setText(String.valueOf(videoEditor.getCurrentFrameIndex()));
    
    }
    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chooseButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        puaseButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        stepBox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        previousFrame = new javax.swing.JButton();
        nextFrame = new javax.swing.JButton();
        frameSlider = new javax.swing.JSlider();
        jPanel5 = new javax.swing.JPanel();
        startFrameBox = new javax.swing.JTextField();
        currentFrameBox = new javax.swing.JTextField();
        endFramBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        controlPanel.setBackground(new java.awt.Color(255, 255, 255));
        controlPanel.setFont(new java.awt.Font("Adobe Devanagari", 3, 12)); // NOI18N
        controlPanel.setMaximumSize(new java.awt.Dimension(310, 680));
        controlPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 500, 15));

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Control panel");
        controlPanel.add(jLabel1);

        chooseButton.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        chooseButton.setText("Choose Video");
        chooseButton.setFocusPainted(false);
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(chooseButton);
        chooseButton.getAccessibleContext().setAccessibleParent(jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        playButton.setText("Play");
        playButton.setFocusPainted(false);
        playButton.setPreferredSize(new java.awt.Dimension(70, 28));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        jPanel3.add(playButton);

        puaseButton.setText("Pause");
        puaseButton.setFocusPainted(false);
        puaseButton.setPreferredSize(new java.awt.Dimension(70, 28));
        puaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puaseButtonActionPerformed(evt);
            }
        });
        jPanel3.add(puaseButton);

        controlPanel.add(jPanel3);

        jButton5.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jButton5.setText("Delete a clip");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        controlPanel.add(jButton5);

        jButton7.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jButton7.setText("Move a clip");
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        controlPanel.add(jButton7);

        jButton6.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jButton6.setText("Split Video");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        controlPanel.add(jButton6);

        jButton8.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jButton8.setText("Add Watermark");
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        controlPanel.add(jButton8);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        jLabel2.setText("step:");
        jPanel4.add(jLabel2);

        stepBox.setColumns(5);
        stepBox.setText("step");
        stepBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepBoxActionPerformed(evt);
            }
        });
        jPanel4.add(stepBox);

        controlPanel.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        previousFrame.setText("<");
        previousFrame.setFocusPainted(false);
        previousFrame.setPreferredSize(new java.awt.Dimension(70, 28));
        previousFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousFrameActionPerformed(evt);
            }
        });
        jPanel6.add(previousFrame);

        nextFrame.setText(">");
        nextFrame.setAlignmentY(0.3F);
        nextFrame.setFocusPainted(false);
        nextFrame.setMargin(new java.awt.Insets(2, 6, 2, 6));
        nextFrame.setPreferredSize(new java.awt.Dimension(70, 28));
        nextFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextFrameActionPerformed(evt);
            }
        });
        jPanel6.add(nextFrame);

        controlPanel.add(jPanel6);

        frameSlider.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                frameSliderAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                frameSliderAncestorRemoved(evt);
            }
        });
        frameSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frameSliderStateChanged(evt);
            }
        });
        frameSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameSliderMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                frameSliderMouseReleased(evt);
            }
        });
        controlPanel.add(frameSlider);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        startFrameBox.setColumns(5);
        startFrameBox.setText("from");
        startFrameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startFrameBoxActionPerformed(evt);
            }
        });
        jPanel5.add(startFrameBox);

        currentFrameBox.setColumns(5);
        currentFrameBox.setText("current");
        currentFrameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentFrameBoxActionPerformed(evt);
            }
        });
        jPanel5.add(currentFrameBox);

        endFramBox.setColumns(5);
        endFramBox.setText("to");
        endFramBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endFramBoxActionPerformed(evt);
            }
        });
        jPanel5.add(endFramBox);

        controlPanel.add(jPanel5);

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        controlPanel.add(jButton1);

        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new DeleteFrame(videoEditor,this).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
              new MoveAClpiFrame(videoEditor,this).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (videoPath != null) {
            videoEditor.play();
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void puaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puaseButtonActionPerformed
        if (videoPath != null) {
            videoEditor.pause();
        }
    }//GEN-LAST:event_puaseButtonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            new addWatermarkFrame(videoEditor).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        // create an object of JFileChooser class
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = fileChooser.showDialog(null, null);

        if (r == JFileChooser.APPROVE_OPTION) {
            videoPath = (fileChooser.getSelectedFile().getAbsolutePath());
            videoEditor = new VideoEditor(mainLabel, videoPath);
            videoEditor.start();
            frameSlider.setMinimum(videoEditor.getStartEditingFrame());
            frameSlider.setMaximum(videoEditor.getEndEditingFrame());
            startFrameBox.setText(String.valueOf(videoEditor.getStartEditingFrame()));
            endFramBox.setText(String.valueOf(videoEditor.getEndEditingFrame()));
            currentFrameBox.setText(String.valueOf(videoEditor.getCurrentFrameIndex()));
            setPanelEnabled(controlPanel, true);
            stepBox.setText(String.valueOf(videoEditor.getFrameStep()));

        }
    }//GEN-LAST:event_chooseButtonActionPerformed

    private void previousFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousFrameActionPerformed
        videoEditor.viewPreviosFrame();
        frameSlider.setValue(videoEditor.getCurrentFrameIndex());
    }//GEN-LAST:event_previousFrameActionPerformed

    private void nextFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextFrameActionPerformed
        videoEditor.viewNextFrame();
        frameSlider.setValue(videoEditor.getCurrentFrameIndex());
    }//GEN-LAST:event_nextFrameActionPerformed

    private void currentFrameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentFrameBoxActionPerformed
        int value = Integer.parseInt(currentFrameBox.getText());
        if (value >= videoEditor.getStartEditingFrame() && value <= videoEditor.getEndEditingFrame()) {
            videoEditor.setCurrentFrameIndex(value);
            frameSlider.setValue(value);
        }
    }//GEN-LAST:event_currentFrameBoxActionPerformed

    private void frameSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameSliderMousePressed

    }//GEN-LAST:event_frameSliderMousePressed

    private void frameSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameSliderMouseReleased
//        videoEditor.setCurrentFrameIndex(frameSlider.getValue());
    }//GEN-LAST:event_frameSliderMouseReleased
    private void startFrameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startFrameBoxActionPerformed
        videoEditor.setStartEditingFrame(Integer.parseInt(startFrameBox.getText()));
        frameSlider.setMinimum(videoEditor.getStartEditingFrame());
        frameSlider.setMaximum(videoEditor.getEndEditingFrame());
    }//GEN-LAST:event_startFrameBoxActionPerformed

    private void endFramBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endFramBoxActionPerformed
        videoEditor.setEndEditingFrame(Integer.parseInt(endFramBox.getText()));
    }//GEN-LAST:event_endFramBoxActionPerformed

    private void frameSliderAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_frameSliderAncestorMoved

    }//GEN-LAST:event_frameSliderAncestorMoved

    private void frameSliderAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_frameSliderAncestorRemoved

    }//GEN-LAST:event_frameSliderAncestorRemoved

    private void frameSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frameSliderStateChanged
        int value = frameSlider.getValue();
        videoEditor.setCurrentFrameIndex(value);
        currentFrameBox.setText( String.valueOf(value));
    }//GEN-LAST:event_frameSliderStateChanged

    private void stepBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepBoxActionPerformed
        videoEditor.setFrameStep(Integer.parseInt(stepBox.getText()));
    }//GEN-LAST:event_stepBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       videoEditor.save(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextField currentFrameBox;
    private javax.swing.JTextField endFramBox;
    private javax.swing.JSlider frameSlider;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton nextFrame;
    private javax.swing.JButton playButton;
    private javax.swing.JButton previousFrame;
    private javax.swing.JButton puaseButton;
    private javax.swing.JTextField startFrameBox;
    private javax.swing.JTextField stepBox;
    // End of variables declaration//GEN-END:variables
}
