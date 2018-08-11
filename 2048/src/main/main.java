package main;

public class main {
	public static int rows = 4, columns = 4;
	public static int[][] board = new int[rows][columns];
	
	public static void main(String[] args) {
		printArray(board);
	}
	public static int getNum() {
		int newNumber;
		if(Math.random() > 0.5) newNumber = 2;
		else newNumber = 4;
		return newNumber;
	}
	
	public static void addNum(int[][] array, int num) {
		num = getNum();
		int options = 0;
		
		for(int i = 0; i < rows; i++) {
			for( int j = 0; j < columns; j++) {
				if(array[i][j] == 0) options++;
			}
		}
		
	}
	public static void printArray(int[][] array) {
		for(int i = 0; i < rows; i++) {
			for( int j = 0; j < columns; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	
	
}
