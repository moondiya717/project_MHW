package accountbook_m;

public class AccountbookCard {

		/*1. 수입/지출 등록 => 수입 또는 지출 중에서 선택 (현금/은행/  카드-수입없음)- 배열하나에 수입은 홀수번지, 지출은짝수번지에 등록, 카드금액은 다른배열사용
		 *2. 수입/지출 목록 확인 => 수입 또는 지출 중에서 선택 - (수입)홀수번지모두 리스트로 호출, (지출)짝수번지모두 리스트호출
		 *3. 수입/지출 내역 삭제 => 수입 또는 지출에서 선택한 번호를 삭제시키기
		 *4. 수입&지출 총액 확인 => 수입금액 표시, 각항목의 지출금액 표시, 지출금액에 총액금액표시, 잔액 확인해주기(-음수 나올 수 있어야 함, 카드때문에)
		 *5. 프로그램 종료 => break;
		 * */
		
		//필요한 멤버변수들 : 현금금액, 은행금액, 카드금액, 배열1(수입지출), 배열2(카드만), 은행명, (지출/수입내용)note, 날짜, 
		private int cash;				//현금및은행금액+-
		private String moneyType;		//은행명&카드명&현금 종류입력
		private String note;			//내역의 내용 
		private String registerDate;	//날짜
		private int cardSpending;		//카드지출금액
		private int income;				//현금&뱅킹 수입
		private int spending;			//현급&뱅킹 지출
		private int card;				//카드금액사용+-
		
		
		public int getCash() {
			return cash;
		}
		public void setCash(int cash) {
			this.cash = cash;
		}
		public String getMoneyType() {
			return moneyType;
		}
		public void setMoneyType(String moneyType) {
			this.moneyType = moneyType;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(String registerDate) {
			this.registerDate = registerDate;
		}
		public int getCardSpending() {
			return cardSpending;
		}
		public void setCardSpending(int cardSpending) {
			this.cardSpending = cardSpending;
		}
		public int getIncome() {
			return income;
		}
		public void setIncome(int income) {
			this.income = income;
		}
		public int getSpending() {
			return spending;
		}
		public void setSpending(int spending) {
			this.spending = spending;
		}
		public int getCard() {
			return card;
		}
		public void setCard(int card) {
			this.card = card;
		}
		
		
		//생성자 만들기
		//날짜-> 돈의종류선택 ->  금액입력 -> 내용
		public AccountbookCard(String registerDate, String moneyType, int card, String note) {
			this.registerDate = registerDate;
			this.moneyType = moneyType;
			this.card = card;
			this.note = note;
		}


}
