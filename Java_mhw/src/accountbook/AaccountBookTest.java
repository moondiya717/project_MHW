package accountbook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AaccountBookTest {

	public static void main(String[] args) {
		AccountbookProgram2 abp = new AccountbookProgram2();	
		int menu=0;
		Scanner scan = new Scanner (System.in);
		int subMenu=0;
		//do-while을 처음부터 끝까지 다 포함해보리면 예외가발생했을 때, 바로 catch로가서 null값이 나오게됨
		do {
			try {
			abp.printMenu();
			menu=scan.nextInt();
			switch(menu) {
			case 1:	abp.insert(); break;
			case 2: abp.update(); break;
			case 3: abp.delete(); break;
			case 4: 
				abp.printSubMenu();
				subMenu = scan.nextInt();
				switch(subMenu) {
				case 1: abp.print(); break;
				case 2: abp.printSimple(); break;
				case 3: abp.printDetails(); break;
				case 4: abp.printTotal(); break;
				default : System.out.println("잘못된 메뉴입니다.");
				}
				break;
			case 5: System.out.println("프로그램 종료"); break;
			default: System.out.println("잘못된 메뉴입니다."); break;
			}
			}catch(/*Exception*/ InputMismatchException e) {
				//System.out.println(e.getMessage());	//지정된 메세지없어서 null
				System.out.println("예외 : 값을 잘못 입력했습니다.");
				
				
				//scan.nextLine(); => 공백(스페이스)를 포함한 문자열을 엔터까지 가져옴
				scan.nextLine();	//얘를지우고 실행하게되면, 무한반복에들어감=>위에 menu에 a를 입력하고 menu에 계속 문자a가 남아있어서 무한반복
				menu=0;
			}
		}while(menu!=5);
		scan.close();

	}
}

 