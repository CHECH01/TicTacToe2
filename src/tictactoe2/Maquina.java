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
			if(positions.size()==9) 
				func("1",board,guiBoard);
			else if(positions.size()==7) {
				if(myBoard[0][1].contentEquals(playerMark) ||  myBoard[0][2].contentEquals(playerMark)) 
					func("7",board,guiBoard);
				else if(myBoard[1][1].contentEquals(playerMark)) 
					func("9",board,guiBoard);
				else 
					func("3",board,guiBoard);
			}else if(positions.size() == 5) {
				if(myBoard[0][2].contentEquals(machineMark) ) {
					if(myBoard[1][0].contentEquals(playerMark)||myBoard[1][2].contentEquals(playerMark) ||myBoard[2][1].contentEquals(playerMark)) 
						func("5",board,guiBoard);
					else if(myBoard[2][0].contentEquals(playerMark)) 
						func("9",board,guiBoard);
					else if(myBoard[2][2].contentEquals(playerMark)) 
						func("7",board,guiBoard);
				}else if(myBoard[2][0].contentEquals(machineMark))
					func("9",board,guiBoard);
				else if(myBoard[2][2].contentEquals(machineMark))
					puedeGanar(playerMark,machineMark,board,guiBoard);
			}else if(positions.size() == 3 || positions.size() == 1 )
				puedeGanar(playerMark,machineMark,board,guiBoard);
		}
	}
	public boolean puedeGanar(String maquina, String player,Board board,GuiBoard guiBoard) {
		String [][]myBoard = board.getBoard();
		for(int i = 0;i <3; i++) {
			for(int j = 0;j <3; j++) {
				if(j == 0) {
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+2].contentEquals(maquina)) 
						if(!myBoard[i][j+1].contentEquals(player)) 
							return func(i,j+1,machineMark,board,guiBoard);
					
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+1].contentEquals(maquina)) 
						if(!myBoard[i][j+2].contentEquals(player))
							return func(i,j+2,machineMark,board,guiBoard);
				}
				
				if(j==1)
					if(myBoard[i][j].contentEquals(maquina)&&myBoard[i][j+1].contentEquals(maquina)) 
						if(!myBoard[i][j-1].contentEquals(player))
							return func(i,j-1,machineMark,board,guiBoard);
					
				if( i== 0) {
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+2][j].contentEquals(maquina)) 
						if(!myBoard[i+1][j].contentEquals(player))
							return func(i+1,j,machineMark,board,guiBoard);
					
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+1][j].contentEquals(maquina)) 
						if(!myBoard[i+2][j].contentEquals(player))
							return func(i+2,j,machineMark,board,guiBoard);
				}
				
				if(i == 1)
					if(myBoard[i][j].contentEquals(maquina) && myBoard[i+1][j].contentEquals(maquina))
						if(!myBoard[i-1][j].contentEquals(player))
							return func(i-1,j,machineMark,board,guiBoard);
			}
		}
		if(myBoard[0][0].contentEquals(maquina) && myBoard[2][2].contentEquals(maquina) || myBoard[0][2].contentEquals(maquina) && myBoard[2][0].contentEquals(maquina))
			if(!myBoard[1][1].contentEquals(player))
				return func(1,1,machineMark,board,guiBoard);
		
		if(myBoard[0][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if(!myBoard[2][2].contentEquals(player))
				return func(2,2,machineMark,board,guiBoard);
		
		if(myBoard[2][0].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if(!myBoard[0][2].contentEquals(player))
				return func(0,2,machineMark,board,guiBoard);
		
		if(myBoard[0][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if(!myBoard[2][0].contentEquals(player))
				return func(2,0,machineMark,board,guiBoard);
		
		if(myBoard[2][2].contentEquals(maquina) && myBoard[1][1].contentEquals(maquina))
			if(!myBoard[0][0].contentEquals(player))
				return func(0,0,machineMark,board,guiBoard);
		
		return false;
	}
	public boolean func(int i, int j, String machineMark, Board board, GuiBoard guiBoard) {
		String [][]myBoard = board.getBoard();
		String aux;
		aux = myBoard[i][j];
		board.mark(aux,machineMark);
		guiBoard.mark(aux,machineMark);
		board.removeArrayPosition(aux);
		return true;
	}
	public void func(String pos,Board board, GuiBoard guiBoard) {
		board.mark(pos,machineMark);
		guiBoard.mark(pos, machineMark);
		board.removeArrayPosition(pos);
	}
}