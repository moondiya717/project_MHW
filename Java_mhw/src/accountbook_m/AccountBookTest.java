package accountbook_m;

import java.util.Scanner;

import accountbook.AccountbookProgram2;

public class AccountBookTest {

	public static void main(String[] args) {
		/* 가계부 프로그램 구현하려고 한다. 이 때 필요한 클래스를 만들어보세요. 
		 * 수입 : 수입/지출
		 * 날짜 : 
		 * 자산 : 현금/은행/카드
		 * 분류 : 식비/교통/건강
		 * 금액 : 
		 * 내용 : 
		 * */
		
		
		/*1. 수입/지출 등록 => 수입 또는 지출 중에서 선택 (현금/은행/  카드-수입없음)- 배열하나에 수입은 홀수번지, 지출은짝수번지에 등록// 카드금액은 다른배열사용
		 *2. 수입/지출 목록 확인 => 수입 또는 지출 중에서 선택 - (수입)홀수번지모두 리스트로 호출, (지출)짝수번지모두 리스트호출
		 *3. 수입/지출 내역 삭제 => 수입 또는 지출에서 선택한 번호를 삭제시키기
		 *4. 수입&지출 총액 확인 => 수입금액 표시, 각항목의 지출금액 표시, 지출금액에 총액금액표시, 잔액 확인해주기(-음수 나올 수 있어야 함, 카드때문에)
		 *5. 프로그램 종료 => break;
		 * */
		  	
		Scanner scan = new Scanner (System.in);
		AccountbookProgram hw = new AccountbookProgram();
		int menu=0;
		
		do {
			hw.printMenu();
			menu=scan.nextInt();
			switch(menu) {
			case 1:
				if()
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu!=5);
		scan.close();
		
		
		
	}

}

 