package accountbook;

import java.util.Scanner;

public class AccountbookProgram2 {	

	

	AccountBook2 book;
	Scanner scan = new Scanner(System.in);
	
	//메뉴출력,  내역추가, 내역수정
	
	/* 기능    : 메뉴를 출력해줌
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : printMenu
	 * */
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 가계부 입력");
		System.out.println("2. 가계부 수정 ");
		System.out.println("3. 가계부 삭제 ");
		System.out.println("4. 가계부 확인");
		System.out.println("5. 가계부 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요: ");
	}
	public void printSubMenu() {
		System.out.println("------확인------");
		System.out.println("1. 전체 내역 상세");
		System.out.println("2. 전체 내역 요약");
		System.out.println("3. 선택 내역 상세");
		System.out.println("4. 내역 합계");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요: ");
	}
	
	/* 기능    : 내역을 입력받아 가계부에 저장하는 메소드				//acbook은 내역이 주어지면 내역 list에 저장, 이건 내역을 입력받아서 가계부에 저장
	 * 매개변수 : 없음 										//scanner로 입력받을거라 매개변수 필요없대	
	 * 리턴타입 : void
	 * 메소드명 : insert
	 * */
	public void insert () {
		System.out.println("가계부 내역을 입력하세요.");
		Item item = creatItem();
		book.insert(item);
	}
	
	
	
	/* 기능    : 수정할 내역의 번호와 내역정보를 입력받아 내역을 수정하는 
	 * 매개변수 : 없음
	 * 리턴타입 :void
	 * 메소드명 : update		
	 * */

	public void update() {
		System.out.println("수정할 내역의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index>book.getCount()||index<1) {				//book.getCount()는 저장된 갯수
			System.out.println("수정할 값이 없습니다.");
			return;
		}else {
			System.out.println("수정할 내역을 입력하세요.");
			Item item = creatItem();
			book.update(index-1, item);	//num-1를 하는 이유는 입력을 1로 받아도 배열의 0번지부터 시작해야 하기때문에 -1로 해야함
			System.out.println("수정이 완료되었습니다.");
		}

	}
	
	/* 기능    : 내역 정보를 입력받아 내역을 생성하여 알려주는 메소드
	 * 매개변수 : 없음 => 입력받는 것이기때문에 필요가 없음
	 * 리턴타입 : 생성된 내역 => Item
	 * 메소드명 : creatItem
	 * */
	private Item creatItem(){	//밖에서 쓸 일이 없기때문에 private로 할거임ㅎ
		System.out.println("수입/지출 : ");
		String type = scan.next();
		System.out.println("날짜 : ");
		String date = scan.next();
		System.out.println("자산 : ");
		String paymentType = scan.next();	
		System.out.println("분류 : ");
		String category = scan.next();
		System.out.println("금액 : ");
		int cost = scan.nextInt();
		System.out.println("내용 : ");
		String contents = scan.next();
		Item item = new Item(type, date, paymentType, category, cost, contents);
		return item;
	}
	
	/* 기능    : 삭제할 번호를 입력받아 내역을 삭제하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : delete		
	 * */
	public void delete() {
		System.out.println("삭제할 내역의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index <1 || index >book.getCount()) {
			System.out.println("없는 내역입니다. 삭제할 수 없습니다.");
		}
		book.delete(index-1);
	}
	
	
	/* 기능    : 내역 전체를 상세 출력하는 기능 
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : print	
	 * */
	public void print() {
		book.printItemListDetail();
	}
	
	/* 기능    : 내역 전체를 간략히 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : printSimple		
	 * */
	public void printSimple() {
		book.printItemSimple();
	}
	
	
	/* 기능    : 확인할 내역 번호를 입력받아 내역을 상세히 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : printDetails			
	 * */
	public void printDetails() {
		System.out.println("확인할 내역의 번호를 입력하세요: ");
		int index = scan.nextInt();
		if(index<1 || index > book.getCount()) {
			System.out.println("없는 내역입니다. 확인할 수 없습니다.");
			return;
		}
		book.printItem(index-1);
	}
	
	/* 기능    : 가계부 금액을 출력하는 메소드 
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메소드명 : printTotal
	 * */
	public void printTotal() {
		System.out.println("내역 합계: " + book.getTotal() + "원");
	}
	
	
	public AccountbookProgram2() {		//생성자인건 알겠는데 왜 book=new AccountBook2()? 라고써애돼?
		book = new AccountBook2();
	}
	public AccountbookProgram2(int max) {
		book = new AccountBook2(max);
	}
}
