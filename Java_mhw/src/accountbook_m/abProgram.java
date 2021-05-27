package accountbook_m;

import accountbook.Item;

public class abProgram {

	public static void main(String[] args) {
		Abmethod method;
		
	}
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 가계부 입력");
		System.out.println("2. 가계부 수정");
		System.out.println("3. 가계부 삭제");
		System.out.println("4. 가계부 확인");
		System.out.println("5. 가계부 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요: ");
	}
	public void removeMenu() {
		System.out.println("------확인------");
		System.out.println("1. 선택 내역 삭제");
		System.out.println("2. 전체 내역 삭제");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요: ");
	}
	
	/* 기능    : 내역을 입력받아 가계부에 저장하는 메소드
	 * 매개변수 : 없음 								
	 * 리턴타입 : void
	 * 메소드명 : insert
	 * */
	public void insert () {
		System.out.println("가계부 내역을 입력하세요.");
		NewPost newPost = creatItem();
		book.insert(item);
	}
	
	
}
