package accountbook;

import java.util.Scanner;

public class AaccountBookTest {

	public static void main(String[] args) {
		AccountbookProgram2 abp = new AccountbookProgram2();
		int menu=0;
		Scanner scan = new Scanner (System.in);
		int subMenu=0;
		
		do {
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
			
		}while(menu!=5);
		scan.close();
		
		


	}
}

 