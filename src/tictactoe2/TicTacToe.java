package tictactoe2;

import java.util.Scanner;

public class TicTacToe {
	
	private Board 		board;
	private GuiBoard 	guiBoard;
	private Maquina		machine;
	private Player 		player;
	private Player 		player2;
	
	private String 		playerSymbol;
	private String 		machineSymbol;
	private String 		turn;
	private String		winner;
	private int 		boardSize;
	private boolean 	vsMachineMode;
	
	Scanner input 	= new Scanner(System.in);
	public boolean isWinner(String [][] board) {
		boolean isWinner = false;
		first:
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				
				if ( j == 0 && isWinner == false)// horizontal
					isWinner = isWinner(i,j,board,0,1);
				
				if (i == 0 && isWinner == false) // vertical
					isWinner = isWinner(i,j,board,1,0);
				
				if (i == 0 && j == 0 && isWinner == false) // diagonal 1
					isWinner = isWinner(i,j,board,1,1);
				
				if (i == 0 && j == board.length-1 && isWinner == false) // diagonal 2
					isWinner = isWinner(i,j,board,1,-1);
				
				if(isWinner)
					break first;
			}
		}
		return isWinner;
	}
	public boolean isWinner(int i, int j, String board[][],int aux1,int aux2) {
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
		
		if(cont == board.length) {
			winner = board[i][j];
			return true;
		}else 
			return false;
	}
	
	public void play() {
		int contMoves;
		boolean isWinner = false;
		board = new Board(boardSize);
		guiBoard = new GuiBoard(boardSize);
		player = new Player(playerSymbol);
		
		if(vsMachineMode)
			machine = new Maquina(machineSymbol,playerSymbol);
		else
			player2 = new Player(machineSymbol);
		
		board.initializeArrayPositions();
		guiBoard.initializeArrayPositions();
		
		board.generateEmptyBoard();
		guiBoard.generateEmptyBoard();
		guiBoard.generateEmptyBoard();
		
		guiBoard.printBoard();
		
		contMoves = board.getPositions().size();
		do {
			if(turn.contentEquals(machineSymbol)) {
				if(vsMachineMode)
					machine.move(board,guiBoard);
				else {
					System.out.print("Player "+turn+" move: ");
					player2.move(board, guiBoard);
				}
					
				turn = playerSymbol;
			}else {
				System.out.print("Player "+turn+" move: ");
				player.move(board, guiBoard);
				turn = machineSymbol;
			}
			guiBoard.printBoard();
			isWinner = isWinner(board.getBoard());
			contMoves = board.getPositions().size();
		}while(!isWinner && contMoves != 0);
		
		if(contMoves == 0 && !isWinner)
			System.out.print("DRAW!");
		else
			System.out.print(winner+" WINNER!!!");	
	}
	public void menuFirstPlay() {
		System.out.println("First play? ");
		System.out.println("1. Player");
		System.out.println("2. Machine");
		String op;
		do {
			System.out.print("-> ");
			op = input.nextLine();
		}while(!op.contentEquals("1") && !op.contentEquals("2"));
		if(op.contentEquals("1"))
			turn = playerSymbol;
		else 
			turn = machineSymbol;
	}
	public void menuSymbols() {
		System.out.println("Choose your symbol: ");
		System.out.println("1. X");
		System.out.println("2. O");
		String op ;
		do {
			System.out.print("-> ");
			op = input.nextLine();
		}while(!op.contentEquals("1") && !op.contentEquals("2"));
		if(op.contentEquals("1")) {
			playerSymbol 	= "X";
			machineSymbol 	= "O";
		}else {
			playerSymbol 	= "O";
			machineSymbol 	= "X";
		}
	}
	public void menuGameMode() {
		System.out.println("Game mode: ");
		System.out.println("1. Player vs Computer");
		System.out.println("2. Player vs Player");
		String op ;
		do {
			System.out.print("-> ");
			op = input.nextLine();
		}while(!op.contentEquals("1") && !op.contentEquals("2"));
		
		if(op.contentEquals("1")) {
			boardSize = 3;
			vsMachineMode = true;
			menuSymbols();
			menuFirstPlay();
		}else {
			
			do {
				System.out.print("Board size: ");
				boardSize = input.nextInt();
			}while(boardSize < 2);
			
			vsMachineMode 	= false;;
			playerSymbol 	= "X";
			machineSymbol 	= "O";
			turn = "X";
		}
	}
}