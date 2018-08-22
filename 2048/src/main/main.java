
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

public class main {
	//declaring the board 4x4 

	
	
	public static void main(String[] args) {

	
		GameBoard board = new GameBoard(4,4);
		System.out.println(board);

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Try to get a score of 2048!");
			System.out.println("Type '1'to move up ");
			System.out.println("Type '2'to move down");
			System.out.println("Type '3'to move left");
			System.out.println("Type '4'to move right");
			System.out.println("Type '5'to stop");
			
			
			String input = scan.nextLine();
		
			if(input.equals("1")) {
				board.moveEverything(direction.UP);
				System.out.println(board);
			}else if(input.equals("2")) {
				board.moveEverything(direction.DOWN);
				System.out.println(board);
			}else if(input.equals("3")) {
				board.moveEverything(direction.LEFT);
				System.out.println(board);
			}else if(input.equals("4")) {
				board.moveEverything(direction.RIGHT);
				System.out.println(board);
			}else {
				break;
			}
			
		}while(true);
		scan.close();
	}
  
	
	
	
}
