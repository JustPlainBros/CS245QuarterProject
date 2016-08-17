/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author michael
 */
public class SudokuPanel extends javax.swing.JPanel {
    private final int COLUMN_ROW_BOXES = 9;
    
    private JTextField[][] textFields;
    private int[][] userFields;
    private int[][] answers;
    private int totalScore;
    
    public SudokuPanel(int totalScore) {
        initComponents();
        this.totalScore = totalScore;
        textFields = new JTextField[COLUMN_ROW_BOXES][COLUMN_ROW_BOXES];
        userFields = new int[COLUMN_ROW_BOXES][COLUMN_ROW_BOXES];
        answers = new int[COLUMN_ROW_BOXES][COLUMN_ROW_BOXES];
        
        fillCorrectAnswerFields();
        
        dateLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        //This next line exists to populate the date upon launch of game. If not here,
        //date populates as "jLabel2" for one runtime second then does date properly.
        //colorButtons();
        dateLabel.setText(new SimpleDateFormat("MMMM d, yyyy HH:mm:ss").format(new Date()));
        setDate();
       
    }
    
    private void fillCorrectAnswerFields() {
        answers[0][0] = 8; answers[0][1] = 3; answers[0][2] = 5; answers[0][3] = 4; answers[0][4] = 1; answers[0][5] = 6;
        answers[0][6] = 9; answers[0][7] = 2; answers[0][8] = 7; answers[1][0] = 2; answers[1][1] = 9; answers[1][2] = 6;
        answers[1][3] = 8; answers[1][4] = 5; answers[1][5] = 7; answers[1][6] = 4; answers[1][7] = 3; answers[1][8] = 1;
        answers[2][0] = 4; answers[2][1] = 1; answers[2][2] = 7; answers[2][3] = 2; answers[2][4] = 9; answers[2][5] = 3;
        answers[2][6] = 6; answers[2][7] = 5; answers[2][8] = 8; answers[3][0] = 5; answers[3][1] = 6; answers[3][2] = 9;
        answers[3][3] = 1; answers[3][4] = 3; answers[3][5] = 4; answers[3][6] = 7; answers[3][7] = 8; answers[3][8] = 2;
        answers[4][0] = 1; answers[4][1] = 2; answers[4][2] = 3; answers[4][3] = 6; answers[4][4] = 7; answers[4][5] = 8; 
        answers[4][6] = 5; answers[4][7] = 4; answers[4][8] = 9; answers[5][0] = 7; answers[5][1] = 4; answers[5][2] = 8;   
        answers[5][3] = 5; answers[5][4] = 2; answers[5][5] = 9; answers[5][6] = 1; answers[5][7] = 6; answers[5][8] = 3;
        answers[6][0] = 6; answers[6][1] = 5; answers[6][2] = 2; answers[6][3] = 7; answers[6][4] = 8; answers[6][5] = 1; 
        answers[6][6] = 3; answers[6][7] = 9; answers[6][8] = 4; answers[7][0] = 9; answers[7][1] = 8; answers[7][2] = 1; 
        answers[7][3] = 3; answers[7][4] = 4; answers[7][5] = 5; answers[7][6] = 2; answers[7][7] = 7; answers[7][8] = 6; 
        answers[8][0] = 3; answers[8][1] = 7; answers[8][2] = 4; answers[8][3] = 9; answers[8][4] = 6; answers[8][5] = 2; 
        answers[8][6] = 8; answers[8][7] = 1; answers[8][8] = 5;
    }
    
    // method: setDate
    // purpose: The purpose of this method is to start answers timer event to display
    // the correct date updated each second at the top right corner of the screen.
    private void setDate() {  
        ActionListener date = (java.awt.event.ActionEvent e) -> {
            dateLabel.setText(new SimpleDateFormat("MMMM d, yyyy HH:mm:ss").format(new Date()));
        };
        new javax.swing.Timer(1000, date).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // creates the grid
        int x = 160;
        int y = 50;
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
                g2.drawRect(x, y, 30, 30);
                
                JTextField field = new JTextField("A");
                this.add(field);
                field.setBounds(x, y, 30, 30);
                textFields[i][j] = field;
                
                x += 30;
            }
            x = 160;
            y += 30;
        }
        
        //draws the darker lines
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(250, 51, 250, 319);
        g2.drawLine(340, 51, 340, 319);
        g2.drawLine(161, 140, 429, 140);
        g2.drawLine(161, 230, 429, 230);
        
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(160, 50, 270, 270);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();

        dateLabel.setText("jLabel1");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        endButton.setText("End");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(endButton)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(endButton))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton endButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
