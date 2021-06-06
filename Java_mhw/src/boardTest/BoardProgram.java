package boardTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import boardTest.Board;

public class BoardProgram {

	private ArrayList <Board> board1 = new ArrayList<Board>(10);
	private Scanner scan= new Scanner (System.in);		
	private int count; 	
	
	
	/* 기능    : 게시글을 추가하는 기능
	 * 매개변수 : 필요없음 (class보면 scanner있고 board[] 이 있기때문에)
	 * 리턴타입 : 없음 
	 * 메소드명 : insertBoard
	 * */
	public void insertBoard() {
		System.out.println("[게시글 등록]");
		//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목: ");
		String title=scan.next();
		System.out.print("내용: ");
		String contents=scan.next();
	
		Board tmpBoard = new Board(++count, title, contents);
	
		//생성된 게시글을 배열에 저장
		board1.add(tmpBoard);
	}
	
	/* 기능    :게시글 번호를 입력받아 입력받은 게시글을 확인하는 메소드
	 * 매개변수 :없음
	 * 리턴타입 :없음 => void
	 * 메소드명 : printBoardDetail
	 * */
	public void printBoardDetail() { 
		System.out.print("확인할 게시글 번호를 입력하세요: ");
		int num = scan.nextInt();
		int index =  board1.indexOf(new Board(num));
		if(index!=-1) {
			board1.get(index).print();
		}
		else {
			System.out.println("없거나 삭제된 게시글입니다.");
		}
	
	}
	
	/* 기능    : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList
	 * */
	public void printBoardList() { 
		for(Board tmp : board1) {
			tmp.summaryPrint();
		}
	}
	
	/* 기능    : 수정할 게시글 번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 없음	
	 * 리턴타입 : 없음 => void		//scanner로 입력받기때문임
	 * 메소드명 : modifyBoard
	 * */
	public void modifyBoard() { //삭제된 게시글 수정이 가능함
		System.out.print("수정할 게시글 번호를 입력하세요 :"); //중간에 사라지는데 postNum기준으로 해야돼
		int num = scan.nextInt();
		int index = board1.indexOf(new Board(num));
		
		if(index != -1) {
			System.out.print("제목 :");
			String title = scan.next();
			System.out.print("내용 :");
			String contents = scan.next();
			board1.get(index).modify(title, contents);
		}else {
			System.out.println("게시글이 없거나 삭제되었습니다. ");
		}
	}

	/* 기능    : 게시글 번호를 입력받아 삭제하는 메소드
	 * 매개변수 : 없음		//클래스 내에 게시글배열이 있기때문에 필요없어(?), 그러나 넘겨받는경우엔 매개변수가필요하대
	 * 리턴타입 : 없음 => void
	 * 메소드명 : deleteBoard
	 * */
	public void deleteBoard(){ //이미 삭제된 게시글을 또 삭제할 수 있는 것 처럼 넘어감 
		System.out.println("삭제할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		int index = board1.indexOf(new Board(num));
		board1.remove(index);

	}
	
	/* 기능    : 게시글 프로그램을 종료하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : closeBoard
	 * */
	public void closeBoard() {
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}

	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록 확인");
		System.out.println("5. 게시글 상세 확인");
		System.out.println("6. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요: ");
	}	
	
}
