package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		/*
		 * 게시판 글 쓰기 (제목, 내용 / 날짜, 게시글번호 - 자동)
		 * 게시판 글 수정
		 * 게시판 글 삭제
		 * 게시글 확인하기 (전체, 간략히)
		 * 종료
		 * */
		ArrayList <Contents> list = new ArrayList <Contents>();
		ArrayList <String> list1 = new ArrayList <String>();
		
		Scanner scan = new Scanner (System.in);
		String answer;
		
		
		do {
			BoardMethod.printMenu();
			answer = scan.next();
			switch(answer) {
				case "1" :
					//Contents tmp=BoardMethod.writePost();
					list.add(BoardMethod.writePost());
					break;
				case "2" : 
					//게시글 수정
					break;
				case "3" : 
					//게시글 확인 메뉴 띄우기 (1.게시글목록보기(제목만) 2. 자세히보기)
					BoardMethod.printviewList();
					String viewMenu = scan.next();
					switch(viewMenu){
						case "1" :
							
							break;
						case "2" : 
							for(int i =0; i<list.size() ;i++ ) {
								System.out.println(list.get(i));
							}
							
					}
					
					break;
				case "4" : 
					System.out.println("프로그램이 종료됩니다.");
					break;
			}	
		}while(!answer.equals("4"));
		

	}

}
