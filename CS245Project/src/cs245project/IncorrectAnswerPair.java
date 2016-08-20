package cs245project;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class IncorrectAnswerPair {
    
    private int rowIndex;
    private int colIndex;
    
    public IncorrectAnswerPair(int row, int col) {
        this.rowIndex = row;
        this.colIndex = col;
    }
    
    public int getRowIndex() {
        return rowIndex;
    }
    
    public int getColIndex() {
        return colIndex;
    }
    
}
