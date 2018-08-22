package main;
import java.util.*;
/*
 * Every Gameboard has
 * - dimensions
 * - cells
 * - functionality for:
 * 		-sliding
 * 		-combining
 * 
 */

/**Primary class for the Game Board
 * 
 * The Gameboard has a set number of rows and columns
 * each item on the board is represented by a cell
 * @author Randy
 *
 */
public class GameBoard {
	private final Integer ROWS;
	private final Integer COLUMNS;
	private Cell[][] board;
	
	
	public GameBoard(int rows, int columns) {
		ROWS = rows;
		COLUMNS = columns;
		
		board = new Cell[ROWS][COLUMNS];
		resetBoard();
	}
	
	/**Clears the board
	 * 
	 */
	public void resetBoard() {
		for(Cell[] row: board) {
			for(Cell c: row) {
				c = new Cell();
			}
		}
		addCell();
	}
	
	/**Adds a cell to a random location on the board
	 * 
	 */
	private void addCell() {
		
		//Generates a number that is either 2 or 4 (code taken from getNum() method in V1)
		int newNumber;
		if(Math.random() > 0.5) newNumber = 2;
		else newNumber = 4;
		
		/*
		 * The rest of the method adds that random number to a random empty spot on the board
		 * (Code taken from addNum() method in V2)
		 * 
		 */
		
		boolean successs = false;
		
		int randomX, randomY;
		int max = 3;
		int min = 0;
		int range = max - min +1;
		
		do {
			randomX = (int)(Math.random() * range ) + min;
			randomY = (int)(Math.random() * range ) + min;
			
			if(board[randomY][randomX].getValue() ==0) {
				board[randomY][randomX].changeValue(newNumber);
				successs = true;
			}
		}while(!successs);
		
		
	}
	
	
	
	public String toString() {
		String output = "";
		
		for(Cell[] row: board) {
			for(Cell c: row) {
				output += c + " ";
			}
		}
		
		return output;
	}
	

}
