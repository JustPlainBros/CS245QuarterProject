/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michael
 */
public class HighScoreSerializer {
    
    private final String FILE_NAME = "highscores.ser";
    private HighScore highScore;
    
    private ArrayList<HighScore> highScoreList;
    
    public HighScoreSerializer(HighScore highScore) {
        this.highScore = highScore;
        highScoreList = new ArrayList<>();
    }
    
    public void serializeHighScore() {
        File file = new File(FILE_NAME);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreSerializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // deserialize object
            highScoreList = HighScoreDeserializer.deserializeHighScoreList();
        }
        
        highScoreList.add(highScore);
        
        // Sort list by score
        Collections.sort(highScoreList, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore highScore1, HighScore highScore2) {
                return highScore1.getScore() - highScore2.getScore();
            }
        });
        
        // Reverse it so it is greatest to smallest
        Collections.reverse(highScoreList);
        
        // If list has more than 5 entries, delete the elements
        // above 5.
        if(highScoreList.size() > 5) {
            for(int i = 5; i < highScoreList.size(); i++) {
                highScoreList.remove(i);
            }
        }
        
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(highScoreList);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(HighScoreSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
