package main;
//test

import java.util.*;

public class main {
	//declaring the board 4x4 
	public static int rows = 4, columns = 4;
	public static int[][] board = new int[rows][columns];
	
	
	public static void main(String[] args) {
		printArray(board);
		addNum();
	}
	/*
	 * generating a random 2 or 4 
	 */
	public static int getNum() {
		int newNumber;
		if(Math.random() > 0.5) newNumber = 2;
		else newNumber = 4;
		return newNumber;
	}
	/*
	 * finding a random spot to add the new 2 or 4
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
	
	/*
	 * printing the board formatted for bug fixing
	 */
	public static void printArray(int[][] array) {
		for(int i = 0; i < rows; i++) {
			for( int j = 0; j < columns; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	
	
}
