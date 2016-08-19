/*********************************************************
 *      file: HighScoreFrame.java
 *      author: Erick Rivera / Michael Muinos
 *      class: CS 245 - Programming Graphical User Interfaces
 * 
 *      assignment: Quarter Project, Checkpoint # 1
 *      date last modified: 8/9/16
 * 
 *      purpose: This class is the HighScore frame in which the top 5 high
 *      scores of the users are shown. The panel used the GUI drag and drop 
 *      option in order to generate the placeholder text.
 *********************************************************/
package cs245project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Erick Rivera / Michael Muinos
 */
public class HighScoreFrame extends javax.swing.JFrame {
    private final int NUMBER_OF_HIGHSCORES = 5;
    
    private JLabel[] names;
    private JLabel[] scores;

    //method:HighScoreFrame
    //purpose:Constructor class that calls the generated code
    public HighScoreFrame() {
        initComponents();
        names = new JLabel[NUMBER_OF_HIGHSCORES];
        scores = new JLabel[NUMBER_OF_HIGHSCORES];
        
        setHighScores();
    }
    
    //method:setHighScoreAttributes
    //purpose: sets the location of frame to middle of screen and sets
    //the frame visibility on when opened.
    public void setHighScoreAttributes() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        EscapeAction escape = new EscapeAction();
        escape.register(getRootPane());
    }
    
    // method: setHighScores
    // purpose: this method will set the highscores in their appropriate labels. It will deserialize
    // the file, then place them.
    private void setHighScores() {
        names[0] = name1; names[1] = name2; names[2] = name3; names[3] = name4; names[4] = name5;
        scores[0] = score1; scores[1] = score2; scores[2] = score3; scores[3] = score4; scores[4] = score5;
        
        if(new File(HighScoreDeserializer.FILE_NAME).exists()) {
            ArrayList<HighScore> list = HighScoreDeserializer.deserializeHighScoreList();
            for(int i = 0; i < list.size(); i++) {
                names[i].setText(list.get(i).getName());
                scores[i].setText(String.valueOf(list.get(i).getScore()));
            }
        }
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
        highScore = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();
        score3 = new javax.swing.JLabel();
        score4 = new javax.swing.JLabel();
        score5 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        highScore.setFont(new java.awt.Font("Raanana", 0, 48)); // NOI18N
        highScore.setText("High Score");

        name1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        name1.setText("ABC");

        name2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        name2.setText("ABC");

        name3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        name3.setText("ABC");

        name4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        name4.setText("ABC");

        name5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        name5.setText("ABC");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText(".......");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText(".......");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText(".......");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText(".......");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText(".......");

        score1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        score1.setText("00000");

        score2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        score2.setText("00000");

        score3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        score3.setText("00000");

        score4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        score4.setText("00000");

        score5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        score5.setText("00000");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(highScore)
                .addGap(200, 200, 200))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name2)
                            .addComponent(name1)
                            .addComponent(name3)
                            .addComponent(name4)
                            .addComponent(name5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(score1)
                            .addComponent(score2)
                            .addComponent(score3)
                            .addComponent(score4)
                            .addComponent(score5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(highScore)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name1)
                    .addComponent(jLabel7)
                    .addComponent(score1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name2)
                    .addComponent(jLabel8)
                    .addComponent(score2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name3)
                    .addComponent(jLabel9)
                    .addComponent(score3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name4)
                    .addComponent(jLabel10)
                    .addComponent(score4))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name5)
                    .addComponent(jLabel12)
                    .addComponent(score5))
                .addGap(75, 75, 75)
                .addComponent(backButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //method:backButtonActionPerformed
    //purpose: returns to main menu when back button clicked
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenuFrame mainMenu = new MainMenuFrame();
        mainMenu.setMainMenuAttributes();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_backButtonKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel highScore;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    private javax.swing.JLabel score3;
    private javax.swing.JLabel score4;
    private javax.swing.JLabel score5;
    // End of variables declaration//GEN-END:variables

}
