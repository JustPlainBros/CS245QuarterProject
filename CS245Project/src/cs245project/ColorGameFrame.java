/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import javax.swing.JFrame;

/**
 *
 * @author michael
 */
public class ColorGameFrame extends JFrame {
    
    private JFrame frame;
    private int totalScore;
    
    public ColorGameFrame(String title, int totalScore) {
        this.totalScore = totalScore;
        frame = new JFrame(title);
    }
    
    public void start() {
        frame.add(new ColorGamePanel(totalScore));
        frame.pack();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
