package tictactoe2;

import java.util.Scanner;

public class Player {
	Scanner input 	= new Scanner(System.in);
	private String symbol;
	Player(String symbol){
		this.symbol = symbol;
	}
	public void move(Board myBoard, GuiBoard guiBoard) {
		String position = getPosition(myBoard);
		
		myBoard.mark(position,symbol);
		guiBoard.mark(position,symbol);
	}
	public String getPosition(Board myBoard) {
		String position = "";
		boolean wrongMove = true;
		position = input.nextLine();
		do {
			for(int i = 0 ; i < myBoard.getPositions().size(); i++)
				if(position.contentEquals(myBoard.getPositions().get(i))) {
					wrongMove = false;
					myBoard.removeArrayPosition(position);
					break;
				}
			if(wrongMove) {
				System.out.print("Wrong move, try again: ");
				position = input.nextLine();
			}
				
		}while(wrongMove);
		return position;
	}
}
