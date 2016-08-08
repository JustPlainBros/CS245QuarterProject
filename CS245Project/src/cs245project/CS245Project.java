/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import javax.swing.SwingUtilities;

/**
 *
 * @author Kevsbud
 */
public class CS245Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IntroScreen introScreen = new IntroScreen();
                introScreen.setLocationRelativeTo(null);
                introScreen.setVisible(true);
            }
        });
    }
    
}
