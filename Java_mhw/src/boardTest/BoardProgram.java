package boardTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import board.Board;

public class BoardProgram {

	private Board test = new Board();
	private Board []board;		
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
		System.out.println("등록");
		//게시글 정보를 입력(제목, 작성자, 작성일, 내용)
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목: ");
		String title=scan.next();
		System.out.print("내용: ");
		String contents=scan.next();
		int num = count+1;
		int views = 0;
		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String str=form.format(date);
		//입력된 정보를 이용하여 게시글 생성
		Board tmpBoard = new Board(num, title, contents, views, str);
		//생성된 게시글을 배열에 저장
		board[count] = tmpBoard;
		count+=1;
	}
}
