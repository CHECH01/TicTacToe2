package tictactoe2;

import java.util.Scanner;

public class Player {
	Scanner input 	= new Scanner(System.in);
	String mark 	= "O";
	public void move(Board myBoard, GuiBoard guiBoard) {
		System.out.print("Player O move: ");
		String position = getPosition(myBoard);
		
		myBoard.mark(position,mark);
		guiBoard.mark(position,mark);
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
