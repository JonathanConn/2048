
package main;

import java.util.*;
/**Simulates the famous "2048" game
 * 
 * @author Jonathan Conn
 * @author Randy Perkins
 * "2048 is a single-player sliding block puzzle game designed by Gabriele Cirulli.
 *  The game's objective is to slide numbered tiles on a grid to combine them to create a tile with the number 2048"(from 2048 wikipedia)
 * 
 */

enum direction{ UP, DOWN, LEFT, RIGHT}
public class main {
	//declaring the board 4x4 
	public static final int ROWS = 4, COLUMNS = 4;
	public static int[][] board = new int[ROWS][COLUMNS];
	public static Integer score = 0;
	
	
	public static void main(String[] args) {
		addNum();
		printArray(board);
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Type '1'to move up ");
			System.out.println("Type '2'to move down");
			System.out.println("Type '3'to move left");
			System.out.println("Type '4'to move right");
			System.out.println("Type '5'to stop");
			
			
			String input = scan.nextLine();
		
			if(input.equals("1")) {
				moveEverything(direction.UP);
				printArray(board);
			}else if(input.equals("2")) {
				moveEverything(direction.DOWN);
				printArray(board);
			}else if(input.equals("3")) {
				moveEverything(direction.LEFT);
				printArray(board);
			}else if(input.equals("4")) {
				moveEverything(direction.RIGHT);
				printArray(board);
			}else {
				break;
			}
			
		}while(true);
		scan.close();
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
		boolean successs = false;
		
		int randomX, randomY;
		int max = 3;
		int min = 0;
		int range = max - min +1;
		
		do {
			randomX = (int)(Math.random() * range ) + min;
			randomY = (int)(Math.random() * range ) + min;
			
			if(board[randomY][randomX] == 0) {
				board[randomY][randomX] = getNum();
				successs = true;
			}
		}while(!successs);
	}
	
	/**Moves all the cells in a specified direction and combines the necessary cells(The ones that are the same) together
	 * 
	 */
	public static void moveEverything(direction where) {
		
		boolean isApplicableDirection = false;

		/*If the direction is down
		*Starts at the end of the 2d array(the last element) and goes backwards through all elements
		*moves every cell down or right, depending on desired direction
		*/
		if(where.equals(direction.DOWN)) {
			for(int currentColumn= COLUMNS-1; currentColumn>=0; currentColumn--) {
				
				do {
				for(int currentRow = ROWS-1; currentRow>=0; currentRow--){
					
					if(board[currentRow][currentColumn] != 0) {
						isApplicableDirection = moveCell(currentRow,currentColumn,where,isApplicableDirection);
					}
					
				}
				}while(!checkRoworColumn(currentColumn,where));
				
				
				
			}
		}
		
		/*If the direction is  left
		*Starts at the end of the 2d array(the last element) and goes backwards through all elements
		*moves every cell down or right, depending on desired direction
		*/
		else if(where.equals(direction.LEFT)) {
			for(int currentRow = ROWS-1; currentRow>=0; currentRow--) {
				do {
					for(int currentColumn= COLUMNS-1; currentColumn>=0; currentColumn--) {
						
						if(board[currentRow][currentColumn] != 0) {
							isApplicableDirection = moveCell(currentRow,currentColumn,where,isApplicableDirection);
						}
						
					}
				}while(!checkRoworColumn(currentRow,where)); 
				
				
				
			}
		}
		
		
		
		
		/*If the direction is up
		*Starts at the beginning of the 2d array (the first element) and goes forward through all elements
		*moves every cell up or left, depending on desired direction
		*/
		else if(where.equals(direction.UP)) {
			 for(int currentColumn= 0; currentColumn<COLUMNS; currentColumn++){
				
				do {
				 for(int currentRow = 0; currentRow<ROWS; currentRow++) {
					
					if(board[currentRow][currentColumn] != 0) {
						isApplicableDirection = moveCell(currentRow,currentColumn,where,isApplicableDirection);
					}
				}
				
			}while(!checkRoworColumn(currentColumn,where)); 
		}
		}
		
		/*If the direction is  right
		*Starts at the beginning of the 2d array (the first element) and goes forward through all elements
		*moves every cell up or left, depending on desired direction
		*/
		else if(where.equals(direction.RIGHT)) {
			for(int currentRow = 0; currentRow<ROWS; currentRow++) {
				do {
				for(int currentColumn= 0; currentColumn<COLUMNS; currentColumn++) {
					
					if(board[currentRow][currentColumn] != 0) {
						isApplicableDirection = moveCell(currentRow,currentColumn,where,isApplicableDirection);
					}
				}
				}while(!checkRoworColumn(currentRow,where)); 
			}
		}
		
		if(isApplicableDirection) {
			addNum();
		}
		
		
		
		
	}
	
	/**Recursive method that moves the current cell in a specified direction
	 * 
	 * Moves it if the cell below it is 0.
	 * Moves it and doubles the value if the cell below it equals the current cell.
	 * Does nothing if the cell below, above, or next to it(depending on direction) does not exist(base case) or is a different value than the current cell.
	 * 
	 * @param row the row of the current cell
	 * @param column the column of the current cell
	 */
	public static boolean moveCell(int row, int column, direction where, boolean isValid) {
		if(where.equals(direction.DOWN)) {
			/*Base case
			 * 
			 * If the next cell down does not exist, then stop recursion
			 */
			if(row+1 == ROWS) {
				return isValid;
			}
			
			//preliminary variables	
			int currentValue = board[row][column];
			int nextCellDown = board[row+1][column];
				
				/*If the next cell down is 0, it replaces that cell
				 * 
				 */
				if(nextCellDown == 0) {
					isValid = true;
					board[row+1][column] = currentValue;
					board[row][column] = 0;
					return moveCell(row+1,column,where, isValid);
					
				}
				
				/*If the next cell down is a different number, it stops recursion
				 * 
				 */
				if(nextCellDown != currentValue) {
					return isValid;
					
				}
				
				/*If the next cell down is equal to the current cell, it doubles the value and replaces the cell 
				 * 
				 */
				if(nextCellDown == currentValue) {
					isValid = true;
					board[row][column] = 0;
					board[row+1][column] *= 2;
					score+= currentValue*2;
					return moveCell(row+1,column,where,isValid);
				}
		}
		else if(where.equals(direction.UP)) {
		   /*Base case
		    * 
			* If the next cell up does not exist, then stop recursion
			*/
			if(row-1 == -1) {
				return isValid;
			}
			
			//preliminary variables	
			int currentValue=board[row][column];
			int nextCellUp=board[row-1][column];
			
			/*If the next cell up is 0, it replaces that cell
			 * 
			 */
			
			if(nextCellUp ==0) {
				isValid = true;
				board[row-1][column] = currentValue;
				board[row][column] = 0;
				return moveCell(row-1,column,where,isValid);
			}
			
			/*If the next cell up is a different number, it stops recursion
			 * 
			 */
			if(nextCellUp != currentValue) {
				return isValid;
			}
			
			
			/*If the next cell up is equal to the current cell, it doubles the value and replaces the cell 
			 * 
			 */
			if(nextCellUp == currentValue) {
				isValid = true;
				board[row-1][column] *= 2;
				board[row][column] = 0;
				score+= currentValue*2;
				return moveCell(row-1,column,where,isValid);
			}
			
			
			
		}else if(where.equals(direction.LEFT)) {
			/*Base case
			    * 
				* If the next cell left does not exist, then stop recursion
				*/
				if(column-1 == -1) {
					return isValid;
				}
				
				//preliminary variables	
				int currentValue=board[row][column];
				int nextCellLeft=board[row][column-1];
				
				/*If the next cell left is 0, it replaces that cell
				 * 
				 */
				
				if(nextCellLeft ==0) {
					isValid = true;
					board[row][column-1] = currentValue;
					board[row][column] = 0;
					return moveCell(row,column-1,where,isValid);
				}
				
				/*If the next cell left is a different number, it stops recursion
				 * 
				 */
				if(nextCellLeft != currentValue) {
					return isValid;
				}
				
				
				/*If the next cell left is equal to the current cell, it doubles the value and replaces the cell 
				 * 
				 */
				if(nextCellLeft == currentValue) {
					isValid = true;
					board[row][column-1] *= 2;
					board[row][column] = 0;
					score+= currentValue*2;
					return moveCell(row,column-1,where,isValid);
				}
			
			
			
		}else if(where.equals(direction.RIGHT)) {
			/*Base case
			    * 
				* If the next cell right does not exist, then stop recursion
				*/
				if(column+1 == COLUMNS) {
					return isValid;
				}
				
				//preliminary variables	
				int currentValue=board[row][column];
				int nextCellRight=board[row][column+1];
				
				/*If the next cell right is 0, it replaces that cell
				 * 
				 */
				
				if(nextCellRight ==0) {
					isValid = true;
					board[row][column+1] = currentValue;
					board[row][column] = 0;
					return moveCell(row,column+1,where,isValid);
				}
				
				/*If the next cell right is a different number, it stops recursion
				 * 
				 */
				if(nextCellRight != currentValue) {
					return isValid;
				}
				
				
				/*If the next cell right is equal to the current cell, it doubles the value and replaces the cell 
				 * 
				 */
				if(nextCellRight == currentValue) {
					isValid = true;
					board[row][column+1] *= 2;
					board[row][column] = 0;
					score+= currentValue*2;
					return moveCell(row,column+1,where,isValid);
				}
			
			
			
		}
		return false;
		
		
	}
	
	/**Checks if a specified row or column has been properly moved
	 * 
	 * @param row the specified row
	 * @param d the direction the user is moving
	 * @return true if the row has been properly moved
	 */
	public static boolean checkRoworColumn(int rowOrColumn, direction d) {
		if(d.equals(direction.RIGHT)) {
		for(int i = 0; i<board[rowOrColumn].length-1;i++) {
			
				if(board[rowOrColumn][i]>0 && board[rowOrColumn][i+1] == 0) {
					return false;
				}
			}
		}
			
			if(d.equals(direction.LEFT)) {
				for(int i=COLUMNS-1; i>=1; i--) {
					
					if(board[rowOrColumn][i]>0 && board[rowOrColumn][i-1] == 0) {
						return false;
					}
				}
		}
		
			if(d.equals(direction.UP)) {
				for(int i =COLUMNS-1; i>=1; i--) {
					if(board[i][rowOrColumn]>0 && board[i-1][rowOrColumn] == 0) {
						return false;
					}
				}
			}
			
			if(d.equals(direction.DOWN)) {
				for(int i = 0; i<board[rowOrColumn].length-1;i++) {
					
						if(board[i][rowOrColumn]>0 && board[i+1][rowOrColumn] == 0) {
							return false;
						}
					}
				}
		
		return true;
	}
	

	
	
	
	/**Prints the current board
	 * 
	 * @param array The board in array form
	 */
	public static void printArray(int[][] array) {
		for(int i = 0; i < ROWS; i++) {
			for( int j = 0; j < COLUMNS; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		System.out.println("Your current score is: " + score );
		System.out.println();
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	
	
}
