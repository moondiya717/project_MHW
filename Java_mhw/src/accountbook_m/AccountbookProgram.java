package accountbook_m;

public class AccountbookProgram {

		/*1. 수입/지출 등록 => 수입 또는 지출 중에서 선택 (현금/은행/  카드-수입없음)- 배열하나에 수입은 홀수번지, 지출은짝수번지에 등록, 카드금액은 다른배열사용
		 *2. 수입/지출 목록 확인 => 수입 또는 지출 중에서 선택 - (수입)홀수번지모두 리스트로 호출, (지출)짝수번지모두 리스트호출
		 *3. 수입/지출 내역 삭제 => 수입 또는 지출에서 선택한 번호를 삭제시키기
		 *4. 수입&지출 총액 확인 => 수입금액 표시, 각항목의 지출금액 표시, 지출금액에 총액금액표시, 잔액 확인해주기(-음수 나올 수 있어야 함, 카드때문에)
		 *5. 프로그램 종료 => break;
		 * */
		
		//멤버변수
		private AccountbookCard []cardList;
		private AccountbookCash []cashList;
		private int count;
		private int cashTotal;
		private int cardTotal;

		
		public void printMenu(){
			System.out.println("------메뉴------");
			System.out.println("1. 수입/지출 등록");
			System.out.println("2. 수입/지출 내역 삭제");
			System.out.println("3. 수입/지출 목록 확인");
			System.out.println("4. 수입&지출 총액 확인");
			System.out.println("5. 프로그램 종료");
			System.out.println("---------------");
			System.out.print("메뉴를 선택하세요: ");
		}
		
		//멤버메소드
		/* 기능    : 내역이 주어지면 주어진 내역을 가계부에 저장하는 메소드 => 현금
		 * 매개변수 : 내역
		 * 리턴타입 : void
		 * 메소드명 : moneyList
		 * */
		public void cashList(AccountbookCash AccountbookCash){
			cashList[count++]= AccountbookCash;
		}
		 
		
		/* 기능    : 내역이 주어지면 주어진 내역을 가계부에 저장하는 메소드 => 카드 */
		public void cardList(AccountbookCard AccountbookCard){
			cardList[count++]= AccountbookCard;
		}
		
		/* 기능    : 지출 목록 간략하게 확인하기
		 * 매개변수 : 없음
		 * 리턴타입 : void
		 * 메소드명 : simpleSpending
		 * */
		public void simpleSpending() {
			System.out.println("항목번호  |  돈의 종류  |   금액   |  날짜");
			
		}
		
		/* 기능    : 수입 목록 확인*/
		
		
		/* 기능    : 수입 목록 상세 확인*/
		
		
		/* 기능    : 지출 목록 상세 확인*/


		/* 기능    : 수입 선택한 번호 삭제*/

		
		/* 기능    : 지출 선택한 번호 삭제*/
		
		
		/* 기능    : 수입총액, 지출(1. 카드지출총액, 2. 현금&뱅킹 지출총액), 현재 잔액(카드값도 합산하고싶당) 출력 */


	

	
}
