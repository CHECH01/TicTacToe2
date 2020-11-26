package tictactoe2;

import java.util.Scanner;

public class Computer {
	private String machineSymbol;
	private String playerSymbol;
	Scanner input = new Scanner(System.in);
	
	public Computer(String machineSymbol, String playerSymbol) {
		this.machineSymbol 	= machineSymbol;
		this.playerSymbol 	= playerSymbol;
	}

	public void move(Board board, GuiBoard guiBoard) {
		System.out.print("Press enter to see computer move... ");
		input.nextLine();
		int turn = board.getPositions().size();
		String[][] stringBoard = board.getBoard();
		if (!check(machineSymbol, playerSymbol, board, guiBoard))
			if (!check(playerSymbol, machineSymbol, board, guiBoard))
				if (turn == 9) {
					mark("1", board, guiBoard);
				} else if (turn == 8) {
					if (stringBoard[1][1].contentEquals(playerSymbol)) {
						mark("7", board, guiBoard);
					} else
						mark("5", board, guiBoard);
				} else if (turn == 7) {

					if (stringBoard[0][1].contentEquals(playerSymbol) || stringBoard[0][2].contentEquals(playerSymbol))
						mark("7", board, guiBoard);

					else if (stringBoard[1][1].contentEquals(playerSymbol))
						mark("9", board, guiBoard);

					else
						mark("3", board, guiBoard);

				} else if(turn == 6){
					//esquina - esquina
					if (stringBoard[0][0].contentEquals(playerSymbol) && stringBoard[2][2].contentEquals(playerSymbol) 
							|| stringBoard[0][2].contentEquals(playerSymbol) && stringBoard[2][0].contentEquals(playerSymbol)) {
						mark("2", board, guiBoard);
						
						//equina - arista
					}else if(stringBoard[0][0].contentEquals(playerSymbol) &&  (stringBoard[1][2].contentEquals(playerSymbol) || stringBoard[2][1].contentEquals(playerSymbol))){
						mark("9", board, guiBoard);
					}else if(stringBoard[0][2].contentEquals(playerSymbol) &&  (stringBoard[1][0].contentEquals(playerSymbol) || stringBoard[2][1].contentEquals(playerSymbol))){
						mark("7", board, guiBoard);
					}else if(stringBoard[2][0].contentEquals(playerSymbol) &&  (stringBoard[1][2].contentEquals(playerSymbol) || stringBoard[0][1].contentEquals(playerSymbol))){
						mark("3", board, guiBoard);
					}else if(stringBoard[2][2].contentEquals(playerSymbol) &&  (stringBoard[1][0].contentEquals(playerSymbol) || stringBoard[0][1].contentEquals(playerSymbol))){
						mark("1", board, guiBoard);
					}
					//medio - equina superior derecha 
					else if(stringBoard[1][1].contentEquals(playerSymbol) &&  stringBoard[0][2].contentEquals(playerSymbol) ){
						mark("9", board, guiBoard);
						
					//arista arista 
					}else if(stringBoard[2][1].contentEquals(playerSymbol) &&  stringBoard[1][2].contentEquals(playerSymbol) ){
						mark("9", board, guiBoard);
					}else
						mark("1", board, guiBoard);
					
				} else if (turn == 5) {
					if (stringBoard[0][2].contentEquals(machineSymbol)) {

						if (stringBoard[1][0].contentEquals(playerSymbol) || stringBoard[1][2].contentEquals(playerSymbol)
								|| stringBoard[2][1].contentEquals(playerSymbol))
							mark("5", board, guiBoard);

						else if (stringBoard[2][0].contentEquals(playerSymbol))
							mark("9", board, guiBoard);

						else if (stringBoard[2][2].contentEquals(playerSymbol))
							mark("7", board, guiBoard);

					} else if (stringBoard[2][0].contentEquals(machineSymbol))
						mark("9", board, guiBoard);
				}else
					mark(randomMark(board),board,guiBoard);
	}

	public boolean check(String maquina, String player, Board board, GuiBoard guiBoard) {
		String[][] stringBoard = board.getBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i][j + 2].contentEquals(maquina))
						if (!stringBoard[i][j + 1].contentEquals(player))
							return mark(stringBoard[i][j + 1], board, guiBoard);

					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i][j + 1].contentEquals(maquina))
						if (!stringBoard[i][j + 2].contentEquals(player))
							return mark(stringBoard[i][j + 2], board, guiBoard);
				}

				if (j == 1)
					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i][j + 1].contentEquals(maquina))
						if (!stringBoard[i][j - 1].contentEquals(player))
							return mark(stringBoard[i][j - 1], board, guiBoard);

				if (i == 0) {
					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i + 2][j].contentEquals(maquina))
						if (!stringBoard[i + 1][j].contentEquals(player))
							return mark(stringBoard[i + 1][j], board, guiBoard);

					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i + 1][j].contentEquals(maquina))
						if (!stringBoard[i + 2][j].contentEquals(player))
							return mark(stringBoard[i + 2][j], board, guiBoard);
				}

				if (i == 1)
					if (stringBoard[i][j].contentEquals(maquina) && stringBoard[i + 1][j].contentEquals(maquina))
						if (!stringBoard[i - 1][j].contentEquals(player))
							return mark(stringBoard[i - 1][j], board, guiBoard);
			}
		}
		if (stringBoard[0][0].contentEquals(maquina) && stringBoard[2][2].contentEquals(maquina)
				|| stringBoard[0][2].contentEquals(maquina) && stringBoard[2][0].contentEquals(maquina))
			if (!stringBoard[1][1].contentEquals(player))
				return mark(stringBoard[1][1], board, guiBoard);

		if (stringBoard[0][0].contentEquals(maquina) && stringBoard[1][1].contentEquals(maquina))
			if (!stringBoard[2][2].contentEquals(player))
				return mark(stringBoard[2][2], board, guiBoard);

		if (stringBoard[2][0].contentEquals(maquina) && stringBoard[1][1].contentEquals(maquina))
			if (!stringBoard[0][2].contentEquals(player))
				return mark(stringBoard[0][2], board, guiBoard);

		if (stringBoard[0][2].contentEquals(maquina) && stringBoard[1][1].contentEquals(maquina))
			if (!stringBoard[2][0].contentEquals(player))
				return mark(stringBoard[2][0], board, guiBoard);

		if (stringBoard[2][2].contentEquals(maquina) && stringBoard[1][1].contentEquals(maquina))
			if (!stringBoard[0][0].contentEquals(player))
				return mark(stringBoard[0][0], board, guiBoard);

		return false;
	}

	public boolean mark(String pos, Board board, GuiBoard guiBoard) {
		board.mark(pos, machineSymbol);
		guiBoard.mark(pos, machineSymbol);
		board.removeArrayPosition(pos);
		return true;
	}
	public String randomMark(Board board) {
		String[][] stringBoard = board.getBoard();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!stringBoard[i][j].contentEquals("O") && !stringBoard[i][j].contentEquals("X"))
					return stringBoard[i][j];
			}
		}
		return null;
	}
}