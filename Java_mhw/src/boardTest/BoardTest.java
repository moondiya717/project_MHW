package boardTest;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		BoardProgram bp = new BoardProgram();
		Scanner scan = new Scanner (System.in);
		String menu;
		
		try {
		do{
			bp.printMenu();
			menu = scan.next();
			switch(menu) {
			case "1" : 
				bp.insertBoard();
				break;
				
			case "2" : 
				bp.modifyBoard(); //삭제된 게시글 수정이 가능함
				break;
			
			case "3" : 
				bp.deleteBoard(); //이미 삭제된 게시글을 또 삭제할 수 있는 것 처럼 넘어감 
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
		}catch(Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	
	
	}
}
