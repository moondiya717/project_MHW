package boardList;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardProgram {

	private ArrayList<Board>list = new ArrayList<Board>();
	private Scanner scan = new Scanner(System.in);
	private int max=0;
	
	public void insertBoard() {
		System.out.println("게시글 정보를 입력하세요.");
		System.out.print("제목 :");
		String title = scan.next();
		System.out.print("작성자 :");
		String writer = scan.next();
		System.out.print("내용 :");
		String contents = scan.next();
		
		//타입은 게시글로 지정, 번호는 배열의 번지를 이용
		String type = "게시글";
		
		//입력된 정보를 이용하여 게시글 생성
		Board tmpBoard = new Board(++max, title, contents, writer, type);
		//생성된 게시글을 배열에 저장
		list.add(tmpBoard);
	}
	
	public void printBoardDetail() {
		System.out.print("확인할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num)); //익명객체로 일회용으로 num만 쓰고 버리려고 하는거임
		if(index !=-1) {
			list.get(index).print();
		}else {
			System.out.println("해당 게시글이 없거나 삭제되었습니다.");
		}
	}
	
	public void printBoardList() {
		for(Board tmp:list) {
			tmp.summaryPrint();
		}
	}
	
	public void modifyBoard() {
		System.out.println("수정할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			System.out.println("제목 :");
			String title = scan.next();
			System.out.println("내용 :");
			String contents = scan.next();
			list.get(index).modify(title, contents);
		}else {
			System.out.println("게시글이 없거나 삭제되었습니다.");
		}
	}
	
	public void deleteBoard() {
		System.out.print("삭제할 게시글 번호를 입력하세요 :");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		list.remove(index);
	}
	
	public void closeBoard() {
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}
}
