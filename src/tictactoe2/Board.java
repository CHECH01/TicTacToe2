package tictactoe2;

public class Board extends AbstractBoard{
	private String[][] board ;
	private int boardSize;
	public Board(int boardSize) {
		super(boardSize);
		this.boardSize = boardSize;
		board 	= new String[boardSize][boardSize];
	}
	public void generateEmptyBoard() {
		int k = 0;
		for(int i = 0; i < boardSize; i++) 
			for(int j = 0; j < boardSize; j++) {
				board[i][j] = positions.get(k);
				k++;
			}
	}
	public void mark(String pos, String mark) {
		for (int i = 0; i < boardSize; i++)
			for (int j = 0; j < boardSize; j++)
				if (board[i][j].contentEquals(pos))
					board[i][j] = mark;
	}
	public String[][] getBoard() {
		return board;
	}
}