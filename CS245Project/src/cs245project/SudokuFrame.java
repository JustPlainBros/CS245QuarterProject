/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author michael
 */
public class SudokuFrame extends JFrame {
    
    private JFrame frame;
    private int totalScore;
    
    public SudokuFrame(String title, int totalScore) {
        frame = new JFrame(title);
        this.totalScore = totalScore;
    }
    
    public void start() {
        frame.add(new SudokuPanel(totalScore));
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.validate();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        EscapeAction escape = new EscapeAction();
        escape.register(frame.getRootPane());
        
        F1Action dialog = new F1Action();
        dialog.register(frame.getRootPane());
    }
}
