package main;
//test

import java.util.*;

public class main {
	//declaring the board 4x4 
	public static int rows = 4, columns = 4;
	public static int[][] board = new int[rows][columns];
	
	
	public static void main(String[] args) {
		printArray(board);
		addNum(board,getNum());
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
	public static void addNum(int[][] array, int num) {
		num = getNum();
		
		int xDecision, yDecision;
		
		ArrayList<Integer> xCord = new ArrayList();
		ArrayList<Integer> yCord = new ArrayList();
		
		for(int i = 0; i < rows; i++) {
			for( int j = 0; j < columns; j++) {
				if(array[i][j] == 0) {
					xCord.add(j);
					yCord.add(i);
				}
			}
		}	
		

//		for(int i = 0; i <  xCord.size();i++) {
//			System.out.print("\n"+xCord.get(i)+"\t"+yCord.get(i));
//		}
		
		xDecision = (int)Math.random() * ((xCord.size() - 0) + 1);
		yDecision = (int)Math.random() * ((yCord.size() - 0) + 1);
		
		System.out.println(xDecision +"\n"+yDecision);
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
