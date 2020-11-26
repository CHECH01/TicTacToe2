package tictactoe2;

import java.util.Scanner;

public class TicTacToe {
	
	private Board 		board;
	private GuiBoard 	guiBoard;
	
	private Computer	machine;
	private Player 		player;
	private Player 		player2;
	
	private Menu 		menuGameMode;
	private Menu 		menuSymbols;
	private Menu 		menuFirstPlay;
	
	private String 		playerSymbol;
	private String 		machineSymbol;
	private String 		firstPlay;
	private String 		currentPlayer;
	private String		winner;
	private String 		gameMode;
	private int 		boardSize;
	
	Scanner input 	= new Scanner(System.in);
	public void play() {
		int 	contMoves = 0;
		boolean isWinner  = false;
		
		currentPlayer	= firstPlay;
		board 			= new Board(boardSize);
		guiBoard 		= new GuiBoard(boardSize);
		player 			= new Player(playerSymbol);

		if(gameMode.contentEquals("1"))
			machine = new Computer(machineSymbol,playerSymbol);
		else
			player2 = new Player(machineSymbol);

		board.initializeArrayPositions();
		guiBoard.initializeArrayPositions();

		board.generateEmptyBoard();
		guiBoard.generateEmptyBoard();
		guiBoard.printBoard();

		contMoves = board.getPositions().size();

		do {
			if(currentPlayer.contentEquals(machineSymbol)) {
				if(gameMode.contentEquals("1"))
					machine.move(board,guiBoard);
				else {
					System.out.print("Player "+currentPlayer+" move: ");
					player2.move(board, guiBoard);
				}	
				currentPlayer = playerSymbol;
			}else {
				System.out.print("Player "+currentPlayer+" move: ");
				player.move(board, guiBoard);
				currentPlayer = machineSymbol;
			}
			guiBoard.printBoard();
			isWinner = isWinner(board.getBoard());
			contMoves = board.getPositions().size();
		}while(!isWinner && contMoves != 0);

		if(contMoves == 0 && !isWinner)
			System.out.println("DRAW!");
		else
			System.out.println(winner+" WINNER!!!");
	}
	
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
	
	public void menus() {
		String opMenuSymbols, opMenuFirstPlay;
		menuGameMode   = new Menu("Game mode:","1. Player vs Computer","2. Player vs Player");
		menuGameMode.printMenu();
		gameMode = menuGameMode.readOption();
		
		if(gameMode.contentEquals("1")) {
			boardSize = 3;
			
			menuSymbols    = new Menu("Choose your symbol: ","1. X","2. O");
			menuFirstPlay  = new Menu("First play?","1. Player","2. Computer");
			
			menuSymbols.printMenu();
			opMenuSymbols = menuSymbols.readOption();
			menuFirstPlay.printMenu();
			opMenuFirstPlay = menuFirstPlay.readOption();
			
			if(opMenuSymbols.contentEquals("1")) 
				setSymbols("X","O");
			else
				setSymbols("O","X");
			
			if(opMenuFirstPlay.contentEquals("1"))
				firstPlay = playerSymbol;
			else 
				firstPlay = machineSymbol;
		}else {
			do {
				System.out.print("Board size: ");
				try {
					boardSize = input.nextInt();
				}catch (Exception e) {
					System.out.println("Sorry, input must be an integer");
					input.next();
				}
			}while(boardSize < 2);
			setSymbols("X","O");
			firstPlay = playerSymbol;
		}
	}
	
	public void setSymbols(String playerSymbol, String machineSymbol) {
		this.playerSymbol  = playerSymbol;
		this.machineSymbol = machineSymbol; 
	}
}