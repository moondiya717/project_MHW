package boardTest;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		BoardProgram bp = new BoardProgram();
		Scanner scan = new Scanner (System.in);
		String menu;
		
		do{
			bp.printMenu();
			menu = scan.next();
			switch(menu) {
			case "1" : 
				bp.insertBoard();
				break;
				
			case "2" : 
				bp.modifyBoard();
				break;
			
			case "3" : 
				bp.deleteBoard();
				break;
				
			case "4" : 
				bp.printBoardList();
				break;
				
			case "5" : 
				bp.printBoardDetail();
				break;
				
			case "6" : 
				bp.closeBoard();
				break;
			}
		}while(!menu.equals("6"));

	
	
	}
}
