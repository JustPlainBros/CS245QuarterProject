/*********************************************************
 *      file: ColorGameFrame.java
 *      author: Michael Muinos
 *      class: CS 245 - Programming Graphical User Interfaces
 * 
 *      assignment: Quarter Project, Checkpoint # 1
 *      date last modified: 8/16/16
 * 
 *      purpose: The purpose of this class is to create a window
 *      for the Color Game. It will will contain a JPanel class of
 *      ColorGamePanel.java
 *********************************************************/
package cs245project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author michael
 */
public class ColorGameFrame extends JFrame {
    
    private JFrame frame;
    private int totalScore;
    
    // constructor
    // purpose: initialize a title and create a new frame
    public ColorGameFrame(String title, int totalScore) {
        this.totalScore = totalScore;
        frame = new JFrame(title);
    }
    
    // method: start
    // purpose: force window to show in center, set frame size, set visible
    public void start() {
        frame.add(new ColorGamePanel(totalScore));
        frame.pack();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
}
