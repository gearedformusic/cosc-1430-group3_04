/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package sudoku_ga3;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.lang.Math;
/**
 *
 * @author erpne
 * 
 * This class checks that the value entered into the Sudoku puzzle is currently valid.
 * It has three functions: checkColumn, checkRow, and checkBox(for the 3x3 squares). 
 * If the value is invalid, each function will return the coordinate of the error(s). 
 * If the value is valid, it will return (-1,-1)
 * 
 * The class receives file with the numbers. It reads in those values to local predefined arrays.
 * i.e. currentPuzzle[0][1] would return either -1 (because it's blank) or a number value
 * 
 * 
 */
public class CheckVal {
    
    public ReadingInput inputPuzzle = new ReadingInput("samplesudoku1.txt");
    public ReadingInput solutionPuzzle = new ReadingInput("soln1.txt");
    
    public CheckVal(){
        
    }
    private int[][] blankPuzzle = new int[9][9];    //the original
    private final int[][] currentPuzzle = new int[9][9];  //the current
    private final int[][] answerPuzzle = new int[9][9];   //the answer
    //private int[] conflictCoordinates;
    
    public void readArray(int[][] copyArray, ReadingInput copyPuzzle){
        copyArray = copyPuzzle.getArray();
    }
   
    public boolean checkSoln(int x, int y){ //this function checks the value at the coordinate against the value at the same coordinate in the solution.
        readArray(answerPuzzle, solutionPuzzle);
        readArray(blankPuzzle, inputPuzzle);
        
        if (currentPuzzle[x][y] == answerPuzzle[x][y]){
               return true;                   
        }
        else
            return false;
    }
    
/*
    public void populateTest(int[][] randomPuzz){
        for(int j = 0; j < 9; j++)
            for(int i = 0; i < 9; i++)
            {
                randomPuzz[i][j] = (int)(Math.random() * 10);                                
            }
    }
       
    public String checkColumn(int x, int y){
        int count = 0;
        for (int i = 0; i<9; i++){
            if (currentPuzzle[x][y] == currentPuzzle[x][i]){
               if (count > 0)
                   //add values to string of coordinates
               else
                   count++;             
        }
        }
    return "-1 -1";
    }
    
    public String checkRow(int x, int y){
        int count = 0;
        for (int i = 0; i<9; i++){
            if (currentPuzzle[x][y] == currentPuzzle[i][y]){
               if (count > 0)
                   //add values to string of coordinates
               else
                   count++;       
        }
        }
    return "-1 -1";
    }
    
    public String checkBox(int x, int y){
        //i figure i'll assign each 3x3 grid a number X, and then depending on the loaction of the given coordinates, it will check the values in box X
        
        int count = 0;
        for (int i = 0; i<9; i++){
            if (currentPuzzle[x][y] == currentPuzzle[i][y]){
               if (count > 0)
                   //add values to string of coordinates
               else
                   count++;
                   
        }
        }
    return "-1 -1";
    }
    */

}

