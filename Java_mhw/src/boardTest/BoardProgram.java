package boardTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import boardTest.Board;

public class BoardProgram {

	private Board test = new Board();
	private Board []board = new Board[10];		
	private Scanner scan;		
	private int count; 	
	
	


	public Board getTest() {
		return test;
	}




	public void setTest(Board test) {
		this.test = test;
	}




	public BoardProgram(Board test) {
		super();
		this.test = test;
	}




	/* 기능    : 게시글을 추가하는 기능
	 * 매개변수 : 필요없음 (class보면 scanner있고 board[] 이 있기때문에)
	 * 리턴타입 : 없음 
	 * 메소드명 : insertBoard
	 * */
	public void insertBoard() {
		Scanner scan = new Scanner (System.in);
		System.out.println("[게시글 등록]");
		//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목: ");
		String title=scan.next();
		System.out.print("내용: ");
		String contents=scan.next();
		int num = count+1;
		int views = 0;
		//Date date = new Date();
		//SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		//String today=form.format(date);
		//입력된 정보를 이용하여 게시글 생성
		Board tmpBoard = new Board(num, title, contents, views, test.today());
		//생성된 게시글을 배열에 저장
		board[count] = tmpBoard;
		count+=1;
	}
	
	/* 기능    :게시글 번호를 입력받아 입력받은 게시글을 확인하는 메소드
	 * 매개변수 :없음
	 * 리턴타입 :없음 => void
	 * 메소드명 : printBoardDetail
	 * */
	public void printBoardDetail() {
		Scanner scan = new Scanner (System.in);
		System.out.print("확인할 게시글 번호를 입력하세요: ");
		int num = scan.nextInt();
		
		if(board[num-1]!=null&&num<count) {
			System.out.println(board[num-1]);
		}else {
			System.out.println("해당 게시물이 존재하지않습니다.");
		}
	}
	
	/* 기능    : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList
	 * */
	public void printBoardList() {
		for(int i =0; i<count; i++) {
			if(board[i]!=null) {
				board[i].summaryPrint();
			}
		}
	}
	
	/* 기능    : 수정할 게시글 번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 없음	
	 * 리턴타입 : 없음 => void		//scanner로 입력받기때문임
	 * 메소드명 : modifyBoard
	 * */
	public void modifyBoard() {
		Scanner scan = new Scanner (System.in);
		System.out.print("수정할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		if(board[num-1]!=null) {
			System.out.print("제목을 입력하세요 :");
			String title = scan.next();
			System.out.println("내용을 입력하세요 :");
			String contents = scan.next();
			if(board[num-1]!=null) {
			board[num-1].modify(title, contents);
			}
		}
	}

	/* 기능    : 게시글 번호를 입력받아 삭제하는 메소드
	 * 매개변수 : 없음		//클래스 내에 게시글배열이 있기때문에 필요없어(?), 그러나 넘겨받는경우엔 매개변수가필요하대
	 * 리턴타입 : 없음 => void
	 * 메소드명 : deleteBoard
	 * */
	public void deleteBoard(){
		Scanner scan = new Scanner (System.in);
		System.out.println("삭제할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		if(board[num-1]!=null& num<count ) {
			board[num-1] = null;
		}
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
	

	public BoardProgram() {}
	
	
}
