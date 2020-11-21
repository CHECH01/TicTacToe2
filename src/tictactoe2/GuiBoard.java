package tictactoe2;

public class GuiBoard extends AbstractBoard{
	private static final int 	ROWS 		= 3*3;
	private static final int 	COLUMNS 	= 3*6;
	private String[][] 			guiBoard 	= new String[ROWS+1][COLUMNS+1];
	
	public void mark(String pos, String mark) {
		for (int i = 0; i <= ROWS; i++)
			for (int j = 0; j <= COLUMNS; j++)
				if (guiBoard[i][j].contentEquals(pos))
					guiBoard[i][j] = mark;
	}
	public void generateEmptyBoard() {
		for (int i = 0; i <= ROWS; i++)
			for (int j = 0; j <= COLUMNS; j++) {
				if (i!=0 && j % 6 == 0 )
					guiBoard[i][j] = "|";
				else if (i % 3 == 0)
					guiBoard[i][j] = "_";
				else
					guiBoard[i][j] = " ";
			}
		fillBoard();
	}
	public void fillBoard() {
		int j = 2, k = 3;
		for(int i = 0 ; i < positions.size(); i++) {
			if(i != 0 && i % 3 == 0) {
				k  = 3;
				j += 3;
			}
			guiBoard[j][k] = positions.get(i);
			k += 6;
		}
	}
	public void printBoard() {
		for (int i = 0; i <= ROWS; i++) {
			for (int j = 0; j <= COLUMNS; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}
	public String[][] getGuiBoard() {
		return guiBoard;
	}
}
