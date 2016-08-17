/*********************************************************
 *      file: HighScore.java
 *      author: Michael Muinos
 *      class: CS 245 - Programming Graphical User Interfaces
 * 
 *      assignment: Quarter Project, Checkpoint # 1
 *      date last modified: 8/14/16
 * 
 *      purpose: The purpose of this class is to contain the basic
 *               data for high score frame.
 *********************************************************/
package cs245project;

import java.io.Serializable;

public class HighScore implements Serializable {
    
    private String name;
    private int score;
    
    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Score: " + this.score;
    }
    
}
