package tictactoe2;

import java.util.ArrayList;

public abstract class AbstractBoard {
	ArrayList<String> positions = new ArrayList<String>();
	
	public abstract void mark(String pos, String mark);
	public abstract void generateEmptyBoard();
	
	public void removeArrayPosition(String pos) {
		positions.remove(positions.indexOf(pos));
	}
	public void initializeArrayPositions() {
		for (int i = 0;i < 9; i++)
			positions.add(String.valueOf(i+1));
	}
	public ArrayList<String> getPositions() {
		return positions;
	}
}
