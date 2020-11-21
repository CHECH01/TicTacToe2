package tictactoe2;

public class TicTacToe {
	
	private Board 		myBoard 	= new Board();
	private GuiBoard	myGUIBoard 	= new GuiBoard();
	private Maquina 	maquina 	= new Maquina();
	private Player 		player 		= new Player();
	
	private String		winner		= "";
	
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
		
		myBoard.initializeArrayPositions();
		myGUIBoard.initializeArrayPositions();
		myBoard.generateEmptyBoard();
		myGUIBoard.generateEmptyBoard();
		myGUIBoard.printBoard();
		
		contMoves = myBoard.getPositions().size();
		do {
			if(contMoves % 2 != 0)
				maquina.move(myBoard,myGUIBoard);
			else
				player.move(myBoard, myGUIBoard);
			
			myGUIBoard.printBoard();
			isWinner = isWinner(myBoard.getBoard());
			contMoves = myBoard.getPositions().size();
		}while(!isWinner && contMoves != 0);
		
		if(contMoves == 0 && !isWinner)
			System.out.print("DRAW!");
		else
			System.out.print(winner+" WINNER!!!");	
	}
}