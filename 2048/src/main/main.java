
package main;
//test

import java.util.*;
/**Simulates the famous "2048" game
 * 
 * @author Jonathan Conn
 * @author Randy Perkins
 * "2048 is a single-player sliding block puzzle game designed by Gabriele Cirulli.
 *  The game's objective is to slide numbered tiles on a grid to combine them to create a tile with the number 2048"(from 2048 wikipedia)
 * 
 */
public class main {
	//declaring the board 4x4 
	public static final int ROWS = 4, COLUMS = 4;
	public static int[][] board = new int[ROWS][COLUMS];
	
	
	public static void main(String[] args) {
		addNum();
		printArray(board);
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Type '1' to add another cell");
			System.out.println("Type '2'to move down ");
			System.out.println("Type '3'to stop");
			
			String input = scan.nextLine();
			if(input.equals("1")) {
				addNum();
				printArray(board);
			}else if(input.equals("2")) {
				moveEverythingDownward();
				printArray(board);
			}else {
				break;
			}
			
		}while(true);
	}
	/** Randomly generates and integer that is 2 or 4
	 * 
	 * @return Random integer either 2 or 4
	 */
	public static int getNum() {
		int newNumber;
		if(Math.random() > 0.5) newNumber = 2;
		else newNumber = 4;
		return newNumber;
	}
	
	/**Generates a new default cell 
	 * A cell is a integer on the game board.
	 *  A default cell is a random integer either 2 or 4
	 */
	public static void addNum() {
		boolean succuss = false;
		
		int randomX, randomY;
		int max = 3;
		int min = 0;
		int range = max - min +1;
		
		do {
			randomX = (int)(Math.random() * range ) + min;
			randomY = (int)(Math.random() * range ) + min;
			
			if(board[randomY][randomX] == 0) {
				board[randomY][randomX] = getNum();
				succuss = true;
			}
		}while(!succuss);
	}
	
	/**Moves all the cells downward and combines the necessary cells(The ones that are the same) together
	 * 
	 */
	public static void moveEverythingDownward() {


		//Starts at the end of the 2d array(the last element) and goes backwards through all elements
		for(int currentRow = ROWS-1; currentRow>=0; currentRow--) {
			for(int currentColumn= COLUMS-1; currentColumn>=0; currentColumn--) {
				
				if(board[currentRow][currentColumn] != 0) {
					moveCellDownward(currentRow,currentColumn);
				}
			}
		}
		
		
	}
	
	/**Recursive method that moves the current cell down
	 * 
	 * Moves it down if the cell below it is 0.
	 * Moves it down and doubles the value if the cell below it equals the current cell.
	 * Does nothing if the cell below it does not exist(base case) or is a different value than the current cell.
	 * 
	 * @param row the row of the current cell
	 * @param column the column of the current cell
	 */
	public static void moveCellDownward(int row, int column) {
		/*Base case
		 * If the next cell down does not exist, then stop recursion
		 */
		if(row+1 == ROWS) {
			return;
		}
		
		//preliminary variables	
		int currentValue = board[row][column];
		int nextCellDown = board[row+1][column];
			
			/*If the next cell down is 0, it replaces that cell
			 * 
			 */
			if(nextCellDown == 0) {
				board[row+1][column] = currentValue;
				board[row][column] = 0;
				moveCellDownward(row+1,column);
			}
			
			/*If the next cell down is a different number, it stops recursion
			 * 
			 */
			if(nextCellDown != currentValue) {
				return;
				
			}
			
			/*If the next cell down is equal to the current cell, it doubles the value and replaces the cell 
			 * 
			 */
			if(nextCellDown == currentValue) {
				board[row][column] = 0;
				board[row+1][column] *= 2;
				moveCellDownward(row+1,column);
			}
		
		
	}
	

	
	
	
	/**Prints the current board
	 * 
	 * @param array The board in array form
	 */
	public static void printArray(int[][] array) {
		for(int i = 0; i < ROWS; i++) {
			for( int j = 0; j < COLUMS; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	
	
}
