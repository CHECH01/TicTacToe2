package tictactoe2;

import java.util.Scanner;

public class Menu {
	
	String header;
	String option1;
	String option2;
	
	Scanner input 	= new Scanner(System.in);
	Menu(String header,String option1, String option2){
		this.header  = header;
		this.option1 = option1;
		this.option2 = option2;
	}
	
	public String readOption() {
		String op;
		do {
			System.out.print("-> ");
			op = input.nextLine();
		}while(!op.contentEquals("1") && !op.contentEquals("2"));
		return op;
	}
	public void printMenu() {
		System.out.println(header);
		System.out.println(option1);
		System.out.println(option2);
	}
}
