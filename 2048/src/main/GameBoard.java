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
	private Integer score;
	
	
	public GameBoard(int rows, int columns) {
		ROWS = rows;
		COLUMNS = columns;
		score = 0;
		
		board = new Cell[ROWS][COLUMNS];
		resetBoard();
	}
	
	/**Clears the board
	 * 
	 */
	public void resetBoard() {

		
		for(int i = 0; i <board.length;i++) {
			for(int j = 0; j<board[i].length;j++) {
				board[i][j] = new Cell();

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
		int max = ROWS-1;
		int min = 0;
		int range = max - min +1;
		
		do {
			randomX = (int)(Math.random() * range ) + min;
			randomY = (int)(Math.random() * range ) + min;

			
			if(board[randomY][randomX].getValue() ==0) {
				board[randomY][randomX].setValue(newNumber);
				successs = true;
			}
		}while(!successs);
		
		
	}
	
	
	/**Moves all the cells in a specified direction and combines the necessary cells(The ones that are the same) together
	 * 
	 */
	public  void moveEverything(direction where) {
		
		boolean isApplicableDirection = false;

		/*If the direction is down
		*Starts at the end of the 2d array(the last element) and goes backwards through all elements
		*moves every cell down or right, depending on desired direction
		*/
		if(where.equals(direction.DOWN)) {
			for(int currentColumn= COLUMNS-1; currentColumn>=0; currentColumn--) {
				
				do {
				for(int currentRow = ROWS-1; currentRow>=0; currentRow--){
					
					if(board[currentRow][currentColumn].getValue() != 0) {
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
						
						if(board[currentRow][currentColumn].getValue() != 0) {
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
					
					if(board[currentRow][currentColumn].getValue() != 0) {
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
					
					if(board[currentRow][currentColumn].getValue() != 0) {
						isApplicableDirection = moveCell(currentRow,currentColumn,where,isApplicableDirection);
					}
				}
				}while(!checkRoworColumn(currentRow,where));
			}
		}
		
		if(isApplicableDirection) {
			addCell();
		}
	}
	
	/**Private recursive method that moves the current cell in a specified direction
	 * 
	 * Moves it if the cell below it is 0.
	 * Moves it and doubles the value if the cell below it equals the current cell.
	 * Does nothing if the cell below, above, or next to it(depending on direction) does not exist(base case) or is a different value than the current cell.
	 * 
	 * @param row the row of the current cell
	 * @param column the column of the current cell
	 */
	private  boolean moveCell(int row, int column, direction where, boolean isValid) {
		if(where.equals(direction.DOWN)) {
			/*Base case
			 * 
			 * If the next cell down does not exist, then stop recursion
			 */
			if(row+1 == ROWS) {
				return isValid;
			}
			
			//preliminary variables	
			int currentValue = board[row][column].getValue();
			int nextCellDown = board[row+1][column].getValue();
				
				/*If the next cell down is 0, it replaces that cell
				 * 
				 */
				if(nextCellDown == 0) {
					isValid = true;
					board[row+1][column].setValue(currentValue);
					board[row][column].setValue(0);
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
					board[row+1][column].setValue(nextCellDown*2);
					board[row][column].setValue(0);
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
			int currentValue=board[row][column].getValue();
			int nextCellUp=board[row-1][column].getValue();
			
			/*If the next cell up is 0, it replaces that cell
			 * 
			 */
			
			if(nextCellUp ==0) {
				isValid = true;
				board[row-1][column].setValue(currentValue);
				board[row][column].setValue(0);
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
				board[row-1][column].setValue(currentValue*2);
				board[row][column].setValue(0);
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
				int currentValue=board[row][column].getValue();
				int nextCellLeft=board[row][column-1].getValue();
				
				/*If the next cell left is 0, it replaces that cell
				 * 
				 */
				
				if(nextCellLeft ==0) {
					isValid = true;
					board[row][column-1].setValue(currentValue);
					board[row][column].setValue(0);
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
					board[row][column-1].setValue(currentValue*2);
					board[row][column].setValue(0);
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
				int currentValue=board[row][column].getValue();
				int nextCellRight=board[row][column+1].getValue();
				
				/*If the next cell right is 0, it replaces that cell
				 * 
				 */
				
				if(nextCellRight ==0) {
					isValid = true;
					board[row][column+1].setValue(currentValue);
					board[row][column].setValue(0);
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
					board[row][column+1].setValue(currentValue*2);
					board[row][column].setValue(0);
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
	private  boolean checkRoworColumn(int rowOrColumn, direction d) {
		if(d.equals(direction.RIGHT)) {
		for(int i = 0; i<board[rowOrColumn].length-1;i++) {
			
				if(board[rowOrColumn][i].getValue()>0 && board[rowOrColumn][i+1].getValue() == 0) {
					return false;
				}
			}
		}
			
			if(d.equals(direction.LEFT)) {
				for(int i=COLUMNS-1; i>=1; i--) {
					
					if(board[rowOrColumn][i].getValue()>0 && board[rowOrColumn][i-1].getValue() == 0) {
						return false;
					}
				}
		}
		
			if(d.equals(direction.UP)) {
				for(int i =COLUMNS-1; i>=1; i--) {
					if(board[i][rowOrColumn].getValue()>0 && board[i-1][rowOrColumn].getValue() == 0) {
						return false;
					}
				}
			}
			
			if(d.equals(direction.DOWN)) {
				for(int i = 0; i<board[rowOrColumn].length-1;i++) {
					
						if(board[i][rowOrColumn].getValue()>0 && board[i+1][rowOrColumn].getValue() == 0) {
							return false;
						}
					}
				}
		
		return true;
	}
	
	
	public String toString() {
		String output = "";
		
		for(Cell[] row: board) {
			for(Cell c: row) {
				output += c + " ";
			}
			output += "\n";
		}
		
		return output;
	}
	

}
