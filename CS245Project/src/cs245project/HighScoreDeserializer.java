/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 */
public class HighScoreDeserializer {
    public static final String FILE_NAME = "highScores.ser";
    
    public static ArrayList<HighScore> deserializeHighScoreList() {
        ArrayList<HighScore> highScoreList = null;
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            highScoreList = (ArrayList<HighScore>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScoreDeserializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(HighScoreDeserializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return highScoreList;
    }
    
}
