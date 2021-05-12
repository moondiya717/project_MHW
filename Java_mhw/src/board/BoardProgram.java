package board;

import java.util.Scanner;

public class BoardProgram {	//여기다 BoardTest2의 기능을 여기서 구현함. 내용들음 BoardTest의 것들을 복붙해서 메소드만들어줌

	
	private Board []board;		//배열 []모양이 중간에 가야함
	private Scanner scan;		//게터세터 필요없대, 값을 확인만 하면 되는거라서
	private int count; 			//현재 저장된 갯수, 초기화를 따로 안해도 돼. int는 초기값0을 가지고 있어서.
	
	public BoardProgram() {	////this. ->객체(나! 매개변수랑 헷갈리지말아라는 듯) ,   this()  ->생성자
		//board = new Board[10];
		//scan = new Scanner(System.in);
		this(10);		//BoardProgram이라는 이름을 가진게 2개임 ()이랑(int max)랑. this(10)는 괄호안에 정수들어간 BoardProgram(int max) 이거랑 같은거임.	
	}					//그래서 BoardProgra(int max)를 데리고와서 그 안의 것들을 똑같이 여기 안에서 사용할건데 괄호안에 10을 넣었으니까 10대입한 값이 여기 자리하는거임.
	
	public BoardProgram(int max) {
		if(max <= 10) {		//10은 임의로 정한 숫자라서 맘대로 하면 됨.
			max = 10;
		}
		board = new Board[max];
		scan = new Scanner(System.in);
	}
	/* 기능    : 게시글을 추가하는 기능
	 * 매개변수 : 필요없음 (class보면 scanner있고 board[] 이 있기때문에)
	 * 리턴타입 : 없음 
	 * 메소드명 : insertBoard
	 * */
	public void insertBoard() {
		System.out.println("등록");
		//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목: ");
		String title=scan.next();
		System.out.print("작성자: ");
		String writer=scan.next();
		System.out.print("작성일: ");
		String registerDate=scan.next();
		System.out.print("내용: ");
		String contents=scan.next();
		//타입은 게시글로 지정, 번호는 배열의 번지를 이용
		String type = "게시글";
		int num = count+1;
		//입력된 정보를 이용하여 게시글 생성
		Board tmpBoard = new Board(num, title, contents, writer, registerDate, type);
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
		System.out.print("상세 내용을 확인할 게시글의 번호를 입력하세요: ");
		int num = scan.nextInt();
		if(num <= count && board[num-1]!=null) {
			board[num-1].print();	
		}else {
			System.out.println("해당 게시글이 없거나 삭제되었습니다.");
		}
	}
	
	
	/* 기능    : 게시글 전체를 확인하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printBoardList
	 * */
	public void printBoardList(){
		for(int i=0; i<count; i+=1) {
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
		System.out.println("수정할 글 번호를 입력하세요: ");
	int	num=scan.nextInt();
		if(num<=count && board[num-1]!=null) {
			System.out.print("제목: ");
			String title=scan.next();
			System.out.print("내용: ");
			String contents=scan.next();
			board[num-1].modify(title, contents);
		}else {
			System.out.println("게시글이 없거나 삭제되었습니다.");
		}
	}
	
	/* 기능    : 게시글 번호를 입력받아 삭제하는 메소드
	 * 매개변수 : 없음		//클래스 내에 게시글배열이 있기때문에 필요없어(?), 그러나 넘겨받는경우엔 매개변수가필요하대
	 * 리턴타입 : 없음 => void
	 * 메소드명 : deleteBoard
	 * */
	public void deleteboard() {
		System.out.println("삭제할 글 번호를 입력하세요: ");
		int num=scan.nextInt();
		if(num <= count) {
			board[num-1]=null;
		}
	}
	
	/* 기능    : 게시글 프로그램을 종료하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : closeBoard
	 * */
	public void closeBoard() {
		System.out.println("프로그램 종료합니다.");
		scan.close();
	}
}
