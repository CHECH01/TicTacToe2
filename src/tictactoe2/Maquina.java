package tictactoe2;

import java.util.Scanner;

public class Maquina {
	private String machineMark;
	private String playerMark;
	Scanner input = new Scanner(System.in);
	
	public Maquina(String machineMark, String playerMark) {
		this.machineMark = machineMark;
		this.playerMark = playerMark;
	}

	public void move(Board board, GuiBoard guiBoard) {
		System.out.print("Press enter to see computer move... ");
		input.nextLine();
		int turn = board.getPositions().size();
		String[][] myBoard = board.getBoard();
		if (!check(machineMark, playerMark, board, guiBoard))
			if (!check(playerMark, machineMark, board, guiBoard))
				if (turn == 9) {
					mark("1", board, guiBoard);
				} else if (turn == 8) {
					if (myBoard[1][1].contentEquals(playerMark)) {
						mark("7", board, guiBoard);
					} else
						mark("5", board, guiBoard);
				} else if (turn == 7) {

					if (myBoard[0][1].contentEquals(playerMark) || myBoard[0][2].contentEquals(playerMark))
						mark("7", board, guiBoard);

					else if (myBoard[1][1].contentEquals(playerMark))
						mark("9", board, guiBoard);

					else
						mark("3", board, guiBoard);

				} else if(turn == 6){
					//esquina - esquina
					if (myBoard[0][0].contentEquals(playerMark) && myBoard[2][2].contentEquals(playerMark) 
							|| myBoard[0][2].contentEquals(playerMark) && myBoard[2][0].contentEquals(playerMark)) {
						mark("2", board, guiBoard);
						
						//equina - arista
					}else if(myBoard[0][0].contentEquals(playerMark) &&  (myBoard[1][2].contentEquals(playerMark) || myBoard[2][1].contentEquals(playerMark))){
						mark("9", board, guiBoard);
					}else if(myBoard[0][2].contentEquals(playerMark) &&  (myBoard[1][0].contentEquals(playerMark) || myBoard[2][1].contentEquals(playerMark))){
						mark("7", board, guiBoard);
					}else if(myBoard[2][0].contentEquals(playerMark) &&  (myBoard[1][2].contentEquals(playerMark) || myBoard[0][1].contentEquals(playerMark))){
						mark("3", board, guiBoard);
					}else if(myBoard[2][2].contentEquals(playerMark) &&  (myBoard[1][0].contentEquals(playerMark) || myBoard[0][1].contentEquals(playerMark))){
						mark("1", board, guiBoard);
					}
					//medio - equina superior derecha 
					else if(myBoard[1][1].contentEquals(playerMark) &&  myBoard[0][2].contentEquals(playerMark) ){
						mark("9", board, guiBoard);
						
					//arista arista 
					}else if(myBoard[2][1].contentEquals(playerMark) &&  myBoard[1][2].contentEquals(playerMark) ){
						mark("9", board, guiBoard);
					}else
						mark("1", board, guiBoard);
					
				} else if (turn == 5) {
					if (myBoard[0][2].contentEquals(machineMark)) {

						if (myBoard[1][0].contentEquals(playerMark) || myBoard[1][2].contentEquals(playerMark)
								|| myBoard[2][1].contentEquals(playerMark))
							mark("5", board, guiBoard);

						else if (myBoard[2][0].contentEquals(playerMark))
							mark("9", board, guiBoard);

						else if (myBoard[2][2].contentEquals(playerMark))
							mark("7", board, guiBoard);

					} else if (myBoard[2][0].contentEquals(machineMark))
						mark("9", board, guiBoard);
				}else
					mark(randomMark(board),board,guiBoard);
	}

	public boolean check(String maquina, String player, Board board, GuiBoard guiBoard) {
		String[][] myBoard = board.getBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					if (myBoard[i][j].contentEquals(maquina) && myBoard[i][j + 2].contentEquals(maquina))
						if (!myBoard[i][j + 1].contentEquals(player))
							return mark(myBoard[i][j + 1], board, guiBoard);

					if (myBoard[i][j].contentEquals(maquina) && myBoard[i][j + 1].contentEquals(maquina))
						if (!myBoard[i][j + 2].contentEquals(player))
							return mark(myBoard[i][j + 2], board, guiBoard);
				}

				if (j == 1)
					if (myBoard[i][j].contentEquals(maquina) && myBoard[i][j + 1].contentEquals(maquina))
						if (!myBoard[i][j - 1].contentEquals(player))
							return mark(myBoard[i][j - 1], board, guiBoard);

				if (i == 0) {
					if (myBoard[i][j].contentEquals(maquina) && myBoard[i + 2][j].contentEquals(maquina))
						if (!myBoard[i + 1][j].contentEquals(player))
							return mark(myBoard[i + 1][j], board, guiBoard);

					if (myBoard[i][j].contentEquals(maquina) && myBoard[i + 1][j].contentEquals(maquina))
						if (!myBoard[i + 2][j].contentEquals(player))
							return mark(myBoard[i + 2][j], board, guiBoard);
				}

				if (i == 1)
					if (myBoard[i][j].contentEquals(maquina) && myBoard[i + 1][j].contentEquals(maquina))
						if (!myBoard[i - 1][j].contentEquals(player))
							return mark(myBoard[i - 1][j], board, guiBoard);
			}
		}
		if (myBoard[0][0].contentEquals(maquina) && myBoard[2][2].contentEquals(maquina)
				|| myBoard[0][2].contentEquals(maquina) && myBoard[2][0].contentEquals(maquina))
			if (!myBoard[1][1].contentEquals(player))
				return mark(myBoard[1][1], board, guiBoard);

		if (myBoard[0][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if (!myBoard[2][2].contentEquals(player))
				return mark(myBoard[2][2], board, guiBoard);

		if (myBoard[2][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if (!myBoard[0][2].contentEquals(player))
				return mark(myBoard[0][2], board, guiBoard);

		if (myBoard[0][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if (!myBoard[2][0].contentEquals(player))
				return mark(myBoard[2][0], board, guiBoard);

		if (myBoard[2][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if (!myBoard[0][0].contentEquals(player))
				return mark(myBoard[0][0], board, guiBoard);

		return false;
	}

	public boolean mark(String pos, Board board, GuiBoard guiBoard) {
		board.mark(pos, machineMark);
		guiBoard.mark(pos, machineMark);
		board.removeArrayPosition(pos);
		return true;
	}
	public String randomMark(Board board) {
		String[][] myBoard = board.getBoard();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!myBoard[i][j].contentEquals("O") && !myBoard[i][j].contentEquals("X"))
					return myBoard[i][j];
			}
		}
		return "10";
	}
}