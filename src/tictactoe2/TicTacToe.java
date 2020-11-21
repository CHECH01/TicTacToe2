package tictactoe2;

import java.util.Scanner;

public class TicTacToe {
	
	private Scanner input = new Scanner(System.in);
	private Board myBoard = new Board();
	
	public boolean isWinner(String [][] board) {
		boolean isWinner = false;
		first:
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				
				if ( j == 0 && isWinner == false)// horizontal
					isWinner = checkWin(i,j,board,0,1);
				
				if (i == 0 && isWinner == false) // vertical
					isWinner = checkWin(i,j,board,1,0);
				
				if (i == 0 && j == 0 && isWinner == false) // diagonal 1
					isWinner = checkWin(i,j,board,1,1);
				
				if (i == 0 && j == board.length-1 && isWinner == false) // diagonal 2
					isWinner = checkWin(i,j,board,1,-1);
				
				if(isWinner)
					break first;
			}
		}
		return isWinner;
	}
	public boolean checkWin(int i, int j, String board[][],int aux1,int aux2) {
		int aux3 = aux1;
		int aux4 = aux2;
		int cont = 1;
		do {
			if(board[i][j].contentEquals(board[i+aux3][j+aux4])) {
				cont++;
				aux3+=aux1;
				aux4+=aux2;
			}else
				break;
		}while (cont < board.length);
		
		if(cont == board.length)
			return true;
		else 
			return false;
	}
	
	public void play() {
		String mark = "";
		int maxMoves = (int)Math.pow(myBoard.getBoard().length, 2);
		int contMoves = 0;
		boolean isWinner = false;
		
		myBoard.initializeArrayPositions();
		myBoard.generateEmptyBoard();
		myBoard.generateEmptyGUIBoard();
		myBoard.printBoard();
		
		do {
			if(contMoves % 2 == 0) {
				mark = "X";
				System.out.print("Player (computer)X move: ");
				input.nextLine();
				myBoard.turnoMaquina();
				
			}else {
				mark = "O";
				System.out.print("Player O move: ");
				myBoard.mark(getPosition(),mark);
			}
			myBoard.printBoard();
			isWinner = isWinner(myBoard.getBoard());
			contMoves++;
		}while(!isWinner && contMoves < maxMoves);
		
		if(contMoves == maxMoves && !isWinner)
			System.out.print("DRAW!");
		else
			System.out.print(mark+" WINNER!!!");	
	}
	
	public String getPosition() {
		String position = "";
		boolean wrongMove = true;
		
		position = input.nextLine();
		do {
			for(int i = 0 ; i < myBoard.getPositions().size(); i++)
				if(position.contentEquals(myBoard.getPositions().get(i))) {
					wrongMove = false;
					myBoard.removeArrayPosition(position);
					break;
				}
			if(wrongMove) {
				System.out.print("Wrong move, try again: ");
				position = input.nextLine();
			}
				
		}while(wrongMove);
		
		return position;
	}
}
