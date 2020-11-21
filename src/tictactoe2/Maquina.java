package tictactoe2;

import java.util.ArrayList;
import java.util.Scanner;

public class Maquina {
	String machineMark 	= "X";
	String playerMark 	= "O";
	Scanner input = new Scanner(System.in);
	
	public void move(Board board, GuiBoard guiBoard) {
		System.out.print("Player (computer)X move... ");
		input.next();
		ArrayList<String> positions = new ArrayList<String>(board.getPositions());
		String [][]myBoard = board.getBoard();
		if(!puedeGanar(machineMark,playerMark,board,guiBoard)) {
			if(positions.size()==9) {
				board.mark("1",machineMark);
				guiBoard.mark("1", machineMark);
				board.removeArrayPosition("1");
			}else if(positions.size()==7) {
				if(myBoard[0][1].contentEquals(playerMark) ||  myBoard[0][2].contentEquals(playerMark)) {
					board.mark("7",machineMark);
					guiBoard.mark("7", machineMark);
					board.removeArrayPosition("7");
				}else if(myBoard[1][1].contentEquals(playerMark)) {
					board.mark("9",machineMark);
					guiBoard.mark("9", machineMark);
					board.removeArrayPosition("9");
				}else {
					board.mark("3",machineMark);
					guiBoard.mark("3", machineMark);
					board.removeArrayPosition("3");
				}
					
			}else if(positions.size() == 5) {
				if(myBoard[0][2].contentEquals(machineMark) ) {
					if(myBoard[1][0].contentEquals(playerMark)||myBoard[1][2].contentEquals(playerMark) ||myBoard[2][1].contentEquals(playerMark)) {
						board.mark("5",machineMark);
						guiBoard.mark("5", machineMark);
						board.removeArrayPosition("5");
					}else if(myBoard[2][0].contentEquals(playerMark)) {
						board.mark("9",machineMark);
						guiBoard.mark("9", machineMark);
						board.removeArrayPosition("9");
					}else if(myBoard[2][2].contentEquals(playerMark)) {
						board.mark("7",machineMark);
						guiBoard.mark("7", machineMark);
						board.removeArrayPosition("7");
					}
				}else if(myBoard[2][0].contentEquals(machineMark)) {
					board.mark("9",machineMark);
					guiBoard.mark("9", machineMark);
					board.removeArrayPosition("9");
				}else if(myBoard[2][2].contentEquals(machineMark)) {
					puedeGanar(playerMark,machineMark,board,guiBoard);
				}
			}else if(positions.size() == 3 || positions.size() == 1 )
				puedeGanar(playerMark,machineMark,board,guiBoard);
		}
	}
	public boolean puedeGanar(String maquina, String player,Board board,GuiBoard guiBoard) {
		String [][]myBoard = board.getBoard();
		String aux;
		for(int i = 0;i <3; i++) {
			for(int j = 0;j <3; j++) {
				if(j == 0) {
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+2].contentEquals(maquina)) {
						if(!myBoard[i][j+1].contentEquals(player)) {
							aux = myBoard[i][j+1];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+1].contentEquals(maquina)) {
						if(!myBoard[i][j+2].contentEquals(player)) {
							aux = myBoard[i][j+2];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
					
				}
				if(j==1) {
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+1].contentEquals(maquina)) {
						if(!myBoard[i][j-1].contentEquals(player)) {
							aux = myBoard[i][j-1];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
				}
				if( i== 0) {
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+2][j].contentEquals(maquina)) {
						if(!myBoard[i+1][j].contentEquals(player)) {
							aux = myBoard[i+1][j];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+1][j].contentEquals(maquina)) {
						if(!myBoard[i+2][j].contentEquals(player)) {
							aux = myBoard[i+2][j];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
				}
				if(i == 1) {
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+1][j].contentEquals(maquina)) {
						if(!myBoard[i-1][j].contentEquals(player)) {
							aux = myBoard[i-1][j];
							board.mark(aux,machineMark);
							guiBoard.mark(aux,machineMark);
							board.removeArrayPosition(aux);
							return true;
						}
					}
				}
			}
		}
		if(myBoard[0][0].contentEquals(maquina) && myBoard[2][2].contentEquals(maquina) || myBoard[0][2].contentEquals(maquina) && myBoard[2][0].contentEquals(maquina)) {
			if(!myBoard[1][1].contentEquals(player)) {
				aux = myBoard[1][1];
				board.mark(aux,machineMark);
				guiBoard.mark(aux,machineMark);
				board.removeArrayPosition(aux);
				return true;
			}
		}
		if(myBoard[0][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina)) {
			if(!myBoard[2][2].contentEquals(player)) {
				aux = myBoard[2][2];
				board.mark(aux,machineMark);
				guiBoard.mark(aux,machineMark);
				board.removeArrayPosition(aux);
				return true;
			}
		}
		if(myBoard[2][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina)) {
			if(!myBoard[0][2].contentEquals(player)) {
				aux = myBoard[0][2];
				board.mark(aux,machineMark);
				guiBoard.mark(aux,machineMark);
				board.removeArrayPosition(aux);
				return true;
			}
		}
		if(myBoard[0][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina)) {
			if(!myBoard[2][0].contentEquals(player)) {
				aux = myBoard[2][0];
				board.mark(aux,machineMark);
				guiBoard.mark(aux,machineMark);
				board.removeArrayPosition(aux);
				return true;
			}
		}
		if(myBoard[2][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina)) {
			if(!myBoard[0][0].contentEquals(player)) {
				aux = myBoard[0][0];
				board.mark(aux,machineMark);
				guiBoard.mark(aux,machineMark);
				board.removeArrayPosition(aux);
				return true;
			}
		}
		return false;
	}
}