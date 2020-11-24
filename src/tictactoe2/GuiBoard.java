package tictactoe2;

public class GuiBoard extends AbstractBoard{
	
	private int rows;
	private int columns;
	private int boardSize;
	private String[][] 	posBoard;
	private String[][] 	guiBoard;
	public GuiBoard(int boardSize) {
		super(boardSize);
		this.boardSize = boardSize;
		rows 		= boardSize*3;
		columns 	= boardSize*6;
		posBoard 	= new String[rows+1][columns+1];
		guiBoard 	= new String[rows+1][columns+1];
	}
	public void mark(String pos, String mark) {
		for (int i = 0; i <= rows; i++)
			for (int j = 0; j <= columns; j++)
				if (posBoard[i][j].contentEquals(pos)) {
					posBoard[i][j] 	= mark;
					guiBoard[i][j] = mark;
				}
					
	}
	public void generateEmptyBoard() {
		for (int i = 0; i <= rows; i++)
			for (int j = 0; j <= columns; j++) {
				if (i!=0 && j % 6 == 0 ) {
					posBoard[i][j] = "|";
					guiBoard[i][j] = "|";
				}
					
				else if (i % 3 == 0) {
					posBoard[i][j] = "_";
					guiBoard[i][j] = "_";
				}
					
				else {
					posBoard[i][j] = " ";
					guiBoard[i][j] = " ";
				}
			}
		fillBoard();
	}
	public void fillBoard() {
		int j = 2, k = 3;
		for(int i = 0 ; i < positions.size(); i++) {
			if(i != 0 && i % boardSize == 0) {
				k  = 3;
				j += 3;
			}
			guiBoard[j][k] = "-";
			posBoard[j][k] = positions.get(i);
				
			k += 6;
		}
	}
	public void printBoard() {
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= columns; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}
	public String[][] getGuiBoard() {
		return posBoard;
	}
}
