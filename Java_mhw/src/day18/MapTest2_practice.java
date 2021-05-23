package day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class MapTest2_practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String answer, id, pw;
		HashMap<String, String> loginInfo = new HashMap<String, String>();

		
		do {
			answer=menu();	//menu에서 스캐너닫으면안된다?
			switch(answer) {
				case "1":
					id=insertId();
					if(loginInfo.containsKey(id)) {
						System.out.println("이미 사용 중인 아이디입니다.");
						break;
					}
					pw=insertPw();
					loginInfo.put(id,pw);
					
					break;
				case "2": 
					id=insertId();
					pw=insertPw();
					if(loginInfo.containsKey(id)==true && loginInfo.containsValue(pw)==true) {
						System.out.println("로그인되었습니다.");
					}else {
						System.out.println("잘못된 입력입니다.");
					}
					break;
				case "3": System.out.println("프로그램이 종료되었습니다."); break;
				default: 
					System.out.println("잘못된 입력입니다.");
					break;
			}
		}while(!answer.equals("3"));	//3이 아니어야지 true니까 작동을하겠지
	
	scan.close();
	}
	
	/* 기능    : 메뉴를 출력하고 사용자의 답변을 알려줌
	 * 매개변수 : 없음
	 * 리턴타입 : 사용자의 답변(1,2,3) => int
	 * 메소드명 : menu
	 * */
	public static String menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("<-----메뉴----->\n1.회원가입 \n2.로그인 \n3.종료 \n메뉴를 선택하세요: ");
		String answer = scan.next();
		return answer;
	}
	
	/* 기능    : 아이디를 입력받고 입력받은 아이디를 알려줌
	 * 매개변수 : 없음
	 * 리턴타입 : String
	 * 메소드명 : insertId
	 * */
	public static String insertId() {
		Scanner scan = new Scanner (System.in);
		System.out.println("아이디 :");
		String id=scan.next();
		return id;
	}
	
	/* 기능    : 비번을 입력받고 입력받은 비번를 알려줌
	 * 매개변수 : 없음
	 * 리턴타입 : String
	 * 메소드명 : insertPw
	 * */
	public static String insertPw() {
		Scanner scan = new Scanner (System.in);
		System.out.println("비밀번호 :");
		String pw=scan.next();
		return pw;
	}



}