package accountbook_m;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class accountbook {

	public static void main(String[] args) {
		/* 메뉴: 가계부 입력, 수정, 확인, 삭제, 종료 */
		
	Scanner scan = new Scanner (System.in);
	String answer;
	
		while(true) {
			System.out.println("------메뉴------");
			System.out.println("1. 가계부 입력");
			System.out.println("2. 가계부 수정 ");
			System.out.println("3. 가계부 삭제 ");
			System.out.println("4. 가계부 확인");
			System.out.println("5. 가계부 종료");
			System.out.println("---------------");
			System.out.print("메뉴를 선택하세요: ");
			answer=scan.next();
			switch(answer) {
			case "1" : 
				break;
			case "2" : break;
			case "3" : break;
			case "4" : break;
			case "5" : break;
				
			}
		}
		
		
	}

}
class BookList{
	int postNum;	//게시글번호
	String type;	//수입, 지출
	int money;		//금액
	String title;	//제목
	String writer;	//작성자
	Date date = new Date();		//날짜
	SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today=form.format(date);
	
}