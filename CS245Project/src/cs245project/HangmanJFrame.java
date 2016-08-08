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
public class HangmanJFrame {
    private JFrame frame;
    
    public HangmanJFrame(String name) {
        frame = new JFrame(name);
    }
    
    public void start() {
        frame.add(new HangmanJPanel());
        frame.pack();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
