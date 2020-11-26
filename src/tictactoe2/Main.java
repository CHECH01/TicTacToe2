package tictactoe2;

import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);;

	public static void main(String[] args) {
		TicTacToe myTicTacToe = new TicTacToe();
		String 	replay;
		myTicTacToe.menus();
		do{
			myTicTacToe.play();	
			System.out.println("Game over. Play again? (y/n)?");
			System.out.print("-> ");
			replay = input.next();
		}while(replay.contentEquals("y"));
		System.out.print("Thanks for playing :)");
	}

}