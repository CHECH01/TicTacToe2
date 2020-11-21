package tictactoe2;

import java.util.ArrayList;

public class Board {
	
	private static final int BOARD_SIZE = 3;
	private static final int ROWS 		= BOARD_SIZE*3;
	private static final int COLUMNS 	= BOARD_SIZE*6;
	
	private String[][] guiBoard = new String[ROWS+1][COLUMNS+1];
	private String[][] board 	= new String[BOARD_SIZE][BOARD_SIZE];
	ArrayList<String> positions = new ArrayList<String>();
	
	public void generateEmptyBoard() {
		int k = 0;
		for(int i = 0; i < BOARD_SIZE; i++) 
			for(int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = positions.get(k);
				k++;
			}
	}
	public void mark(String pos, String mark) {
		for (int i = 0; i <= ROWS; i++)
			for (int j = 0; j <= COLUMNS; j++)
				if (guiBoard[i][j].contentEquals(pos))
					guiBoard[i][j] = mark;
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				if (board[i][j].contentEquals(pos))
					board[i][j] = mark;
	}
	public void removeArrayPosition(String pos) {
		positions.remove(positions.indexOf(pos));
	}
	public void generateEmptyGUIBoard() {
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
			if(i != 0 && i % BOARD_SIZE == 0) {
				k  = 3;
				j += 3;
			}
			guiBoard[j][k] = positions.get(i);
			k += 6;
		}
	}
	public void initializeArrayPositions() {
		for (int i = 0;i < BOARD_SIZE*BOARD_SIZE; i++)
			positions.add(String.valueOf(i+1));
	}
	public void printBoard() {
		for (int i = 0; i <= ROWS; i++) {
			for (int j = 0; j <= COLUMNS; j++)
				System.out.print(guiBoard[i][j]);
			System.out.println("");
		}
	}
	
	public void turnoMaquina() {
		if(!puedeGanar("X","O")) {
			if(positions.size()==9) {
				mark("1","X");
				removeArrayPosition("1");
			}else if(positions.size()==7) {
				if(board[0][1].contentEquals("O") ||  board[0][2].contentEquals("O")) {
					mark("7","X");
					removeArrayPosition("7");
				}else if(board[1][1].contentEquals("O")) {
					mark("9","X");
					removeArrayPosition("9");
				}else {
					mark("3","X");
					removeArrayPosition("3");
				}
					
			}else if(positions.size() == 5) {
				if(board[0][2].contentEquals("X") ) {
					if(board[1][0].contentEquals("O")||board[1][2].contentEquals("O") ||board[2][1].contentEquals("O")) {
						mark("5","X");
						removeArrayPosition("5");
					}else if(board[2][0].contentEquals("O")) {
						mark("9","X");
						removeArrayPosition("9");
					}else if(board[2][2].contentEquals("O")) {
						mark("7","X");
						removeArrayPosition("7");
					}
				}else if(board[2][0].contentEquals("X")) {
					mark("9","X");
					removeArrayPosition("9");
				}else if(board[2][2].contentEquals("X")) {
					puedeGanar("O","X");
				}
			}else if(positions.size() == 3 || positions.size() == 1 )
				puedeGanar("O","X");
		}
	}
	public boolean puedeGanar(String maquina, String player) {
		String aux;
		for(int i = 0;i <3; i++) {
			for(int j = 0;j <3; j++) {
				if(j == 0) {
					if(board[i][j].contentEquals(maquina)&&board[i][j+2].contentEquals(maquina)) {
						if(!board[i][j+1].contentEquals(player)) {
							aux = board[i][j+1];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
					if(board[i][j].contentEquals(maquina)&&board[i][j+1].contentEquals(maquina)) {
						if(!board[i][j+2].contentEquals(player)) {
							aux = board[i][j+2];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
					
				}
				if(j==1) {
					if(board[i][j].contentEquals(maquina)&&board[i][j+1].contentEquals(maquina)) {
						if(!board[i][j-1].contentEquals(player)) {
							aux = board[i][j-1];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
				}
				if( i== 0) {
					if(board[i][j].contentEquals(maquina) && board[i+2][j].contentEquals(maquina)) {
						if(!board[i+1][j].contentEquals(player)) {
							aux = board[i+1][j];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
					if(board[i][j].contentEquals(maquina) && board[i+1][j].contentEquals(maquina)) {
						if(!board[i+2][j].contentEquals(player)) {
							aux = board[i+2][j];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
				}
				if(i == 1) {
					if(board[i][j].contentEquals(maquina) && board[i+1][j].contentEquals(maquina)) {
						if(!board[i-1][j].contentEquals(player)) {
							aux = board[i-1][j];
							mark(aux,"X");
							removeArrayPosition(aux);
							return true;
						}
					}
				}
			}
		}
		if(board[0][0].contentEquals(maquina) && board[2][2].contentEquals(maquina) || board[0][2].contentEquals(maquina) && board[2][0].contentEquals(maquina)) {
			if(!board[1][1].contentEquals(player)) {
				aux = board[1][1];
				mark(aux,"X");
				removeArrayPosition(aux);
				return true;
			}
		}
		if(board[0][0].contentEquals(maquina) && board[1][1].contentEquals(maquina)) {
			if(!board[2][2].contentEquals(player)) {
				aux = board[2][2];
				mark(aux,"X");
				removeArrayPosition(aux);
				return true;
			}
		}
		if(board[2][0].contentEquals(maquina) && board[1][1].contentEquals(maquina)) {
			if(!board[0][2].contentEquals(player)) {
				aux = board[0][2];
				mark(aux,"X");
				removeArrayPosition(aux);
				return true;
			}
		}
		if(board[0][2].contentEquals(maquina) && board[1][1].contentEquals(maquina)) {
			if(!board[2][0].contentEquals(player)) {
				aux = board[2][0];
				mark(aux,"X");
				removeArrayPosition(aux);
				return true;
			}
		}
		if(board[2][2].contentEquals(maquina) && board[1][1].contentEquals(maquina)) {
			if(!board[0][0].contentEquals(player)) {
				aux = board[0][0];
				mark(aux,"X");
				removeArrayPosition(aux);
				return true;
			}
		}
		return false;
	}
	public String[][] getBoard() {
		return board;
	}

	public String[][] getGuiBoard() {
		return guiBoard;
	}
	
	public ArrayList<String> getPositions() {
		return positions;
	}
}