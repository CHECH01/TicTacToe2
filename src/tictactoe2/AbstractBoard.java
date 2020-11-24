package tictactoe2;

import java.util.ArrayList;

public abstract class AbstractBoard {
	private int size;
	public AbstractBoard(int boardSize) {
		size = boardSize*boardSize;
	}
	ArrayList<String> positions = new ArrayList<String>();
	
	public abstract void mark(String pos, String mark);
	public abstract void generateEmptyBoard();
	
	public void removeArrayPosition(String pos) {
		positions.remove(positions.indexOf(pos));
	}
	public void initializeArrayPositions() {
		for (int i = 1; i <= size; i++)
			positions.add(String.valueOf(i));
	}
	public ArrayList<String> getPositions() {
		return positions;
	}
}