
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
			System.out.println("Type '2'to stop ");
			
			if(scan.nextLine().equals("1")) {
				addNum();
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
