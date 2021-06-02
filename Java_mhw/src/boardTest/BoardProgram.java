package boardTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import boardTest.Board;

public class BoardProgram {

	private Board test = new Board();
	private Board []board = new Board[10];	
	private ArrayList <Board> board1 = new ArrayList<Board>(10);
	private Scanner scan;		
	private int count; 	
	
	


	public ArrayList<Board> getBoard1() {
		return board1;
	}




	public void setBoard1(ArrayList<Board> board1) {
		this.board1 = board1;
	}




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
	
		Board tmpBoard = new Board(num, title, contents, views, test.today());
	
		//생성된 게시글을 배열에 저장
	//	board[count] = tmpBoard;
		board1.add(tmpBoard);
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
		
		//num와 일치하는 게시물이 있는지 확인
		if(board1.contains(num)) {
			int index = board1.indexOf(num);
			Board tmp = board1.get(index);
			tmp.print();
		}
		else {
			System.out.println("없거나 삭제된 게시글");
		}
		/*
		if(board1.get(num-1).equals("삭제된 게시물입니다.")==true) { //contains도 안되고
			System.out.println("삭제된 글은 열람할 수 없습니다."); //왜안뜨
		}else if(board1.get(num-1)!=null&&num<=count) {
			board1.get(num-1).print();
		}else {
			System.out.println("해당 게시물이 존재하지않습니다."); //이거왜안나오지?
		}*/
	}
	
	/* 기능    : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList
	 * */
	public void printBoardList() { 
		if(board1.isEmpty()==false) {
			for(int i =0 ; i<board1.size(); i++) {
					if(board1!=null) {
						board1.get(i).summaryPrint();
					}else if(board1==null){
						continue;
					}
				}
		}else {
			System.out.println("등록된 게시물이 없습니다.");
		}
		//}if(board1.isEmpty()==true) {
			//System.out.println("등록된 게시물이 없습니다.");
		//}
		
	}
	
	/* 기능    : 수정할 게시글 번호와 정보를 입력받아 수정하는 메소드
	 * 매개변수 : 없음	
	 * 리턴타입 : 없음 => void		//scanner로 입력받기때문임
	 * 메소드명 : modifyBoard
	 * */
	public void modifyBoard() {
		Scanner scan = new Scanner (System.in);
		System.out.print("수정할 게시글 번호를 입력하세요 :"); //중간에 사라지는데 postNum기준으로 해야돼
		int num = scan.nextInt();
		if(board1.get(num-1)!=null&& num<=count) {
			System.out.print("제목을 입력하세요 :");
			String title = scan.next();
			System.out.println("내용을 입력하세요 :");
			String contents = scan.next();
			board1.get(num-1).modify(title, contents); //set
			System.out.println("수정이 완료되었습니다.");
		}else if(board1.get(num-1).equals(null)) {
			System.out.println("해당 게시물은 이미 삭제되었거나 없는 게시물입니다.");
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
		if(board1.get(num-1)!=null&& num<=count ) {
			board1.get(num-1).modify("삭제된 게시물입니다.", "삭제된 게시물입니다.");//삭제말고 값을 null로 해놔야 리스트 번지가 당겨지지않아서 수정에 문제가 안될듯
			if(board1.isEmpty()==true) {
				System.out.println("게시글이 삭제되었습니다.");
			}
		}else {
			System.out.println("게시글이 존재하지 않아 삭제할 수 없습니다."); //이건 왜 안뜨나?
		}
	}
	
	/* 기능    : 게시글 프로그램을 종료하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : closeBoard
	 * */
	public void closeBoard() {
		Scanner scan = new Scanner (System.in);
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
