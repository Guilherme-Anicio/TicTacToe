package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Boolean running = true;
		char[][] marks = new char [3][3];
		char playerMark = 'O';
		
		while(running) {
			printGame(marks);
			
			int choosenPosition;
			
			do {
				choosenPosition = choosePosition(marks);
				
				if(choosenPosition == 0) {
					System.out.println("Invalid position. Try again.");
				}
			
			} while(choosenPosition == 0);
			
			
			insertMark(marks, playerMark, choosenPosition);
			
			char winner = checkWin(marks);
			
			if(winner == 'X') {
				printGame(marks);
				System.out.println("X won!");
				running = false;
			} else if(winner == 'O') {
				printGame(marks);
				System.out.println("O won!");
				running = false;
			} else if(checkDraw(marks)){
				System.out.println("Draw!");
				running = false;
			} else {
				if(playerMark == 'O') {
					playerMark = 'X';
				} else {
					playerMark = 'O';
				}
			}
			
			
		}
		
	}

	public static void printGame(char[][] marks) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(marks[i][j] == 'X' || marks[i][j] == 'O') {
					System.out.print(marks[i][j]);
				} else {
					System.out.print(" ");
				}
				
				if(j != 2) {
					System.out.print("|");
				}
				
				if(j == 2) {
					System.out.print("\n");
				}
			}
			

			
		}
		
		
	}

	public static int choosePosition(char[][] marks){
		
		Scanner input = new Scanner(System.in);
		
		List<Integer> options = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(marks[i][j] != 'O' && marks[i][j] != 'X') {
					options.add((j+1)+(i*3));
					System.out.println((j+1)+(i*3) + ": Row " + (i+1) + ", Column " + (j+1));
				}
			}
		}
		
		int choosenOption = input.nextInt();
		
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i) == choosenOption) {
				return choosenOption;
			}
		}
		
		return 0;

	}
	
	public static void insertMark(char[][] marks, char playersMark, int choosenPosition) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((j+1)+(i*3) == choosenPosition) {
					marks[i][j] = playersMark;
				}
			}
		}
	}
	
	public static char checkWin(char[][] marks) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if((i == 2 && j == 2) ||( i == 2 && j == 3) || (i == 3 && j == 2)){
					//Avoiding repeating winning checks
					continue;
				}
				
				if(i == 0 && j == 0) {
					if(marks[i][j] == marks[i+1][j+1] && marks[i+1][j+1] == marks[i+2][j+2]) {
						return marks[i][j];
					}
				}
				
				if(i == 0){
					if(marks[i][j] == marks[i+1][j] && marks[i+1][j] == marks[i+2][j]){
						return marks[i][j];
					}
				}
				
				if(j == 0){
					if(marks[i][j] == marks[i][j+1] && marks[i][j+1] == marks[i][j+2]){
						return marks[i][j];
					}
				}
			}
		}
		
		return ' ';
	}
	
	public static Boolean checkDraw(char[][] marks) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(marks[i][j] != 'X' && marks[i][j] != 'O') {
					return false;
				}
			}
		}
		return true;
	}
	
}