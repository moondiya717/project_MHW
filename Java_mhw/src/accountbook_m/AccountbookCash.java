package accountbook_m;

public class AccountbookCash {

		/*1. 수입/지출 등록 => 수입 또는 지출 중에서 선택 (현금/은행/  카드-수입없음)- 배열하나에 수입은 홀수번지, 지출은짝수번지에 등록, 카드금액은 다른배열사용
		 *2. 수입/지출 목록 확인 => 수입 또는 지출 중에서 선택 - (수입)홀수번지모두 리스트로 호출, (지출)짝수번지모두 리스트호출
		 *3. 수입/지출 내역 삭제 => 수입 또는 지출에서 선택한 번호를 삭제시키기
		 *4. 수입&지출 총액 확인 => 수입금액 표시, 각항목의 지출금액 표시, 지출금액에 총액금액표시, 잔액 확인해주기(-음수 나올 수 있어야 함, 카드때문에)
		 *5. 프로그램 종료 => break;
		 * */
		
		//필요한 멤버변수들 : 현금금액, 은행금액, 카드금액, 배열1(수입지출), 배열2(카드만), 은행명, (지출/수입내용)note, 날짜, 
		private int cash;					//현금및은행금액+-
		private int card;					//카드금액사용+-
		private String moneyType;			//은행명&카드명&현금 종류입력
		private String note;				//내역의 내용 
		private String registerDate;		//날짜
		private int totalcash;				//현금총액
		private int totalcard;				//카드총액
		private AccountbookCard []cardList;
		private AccountbookCash []cashList; 

		
		//생성자 만들기
		//날짜-> 돈의종류선택 ->  금액입력 -> 내용
		public AccountbookCash(String registerDate, String moneyType, int cash, String note) {
			this.registerDate = registerDate;
			this.moneyType = moneyType;
			this.cash = cash;
			this.note = note;
		}
		
		
		
		//기능 : 가계부 등록하는 메소드
		
		
		//기능 : 가계부 목록 확인하는 메소드 (수입만&지출)

		
		//기능 : 가계부 목록 확인하는 메소드 (카드)

		
		//기능 : 가계부 목록에서 (수입지출)선택항목 삭제하기
		
		
		//기능 : 가계부 목록에서 카드선택항목 삭제하기

		
		//기능 : 

		//기능 : 

		//기능 : 


}


