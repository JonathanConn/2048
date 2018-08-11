package main;

public class main {
	int[][] board = new int[3][3];
	
	public static void main(String[] args) {
		getNum();
	}
	public static int getNum() {
		int newNumber;
		if(Math.random() > 0.5) newNumber = 2;
		else newNumber = 4;
		return newNumber;
	}
	
	
}
