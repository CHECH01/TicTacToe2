package tictactoe2;

public class Board extends AbstractBoard{
	
	private static final int BOARD_SIZE = 3;
	private String[][] board 	= new String[BOARD_SIZE][BOARD_SIZE];
	
	public void generateEmptyBoard() {
		int k = 0;
		for(int i = 0; i < BOARD_SIZE; i++) 
			for(int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = positions.get(k);
				k++;
			}
	}
	public void mark(String pos, String mark) {
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				if (board[i][j].contentEquals(pos))
					board[i][j] = mark;
	}
	public String[][] getBoard() {
		return board;
	}
}