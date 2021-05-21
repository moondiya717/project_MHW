package day18;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest2 {

	public static void main(String[] args) {
		/* 다음 두 가능을 가진 프로그램을 작성하세요.
		 * 1. 회원 가입
		 * 2. 로그인
		 * 3. 종료
		 * 예시)
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 회원가입
		 * 아이디 : abc123
		 * 비밀번호: abc123
		 * 회원가입되었습니다.
		 * 1. 회원가입
		 * 2.로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 아이디 : abc123
		 * 이미 가입된 회원입니다.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택: 2
		 * 아이디 : abc123
		 * 비밀번호 : abc123
		 * 로그인 성공
		 * 메뉴 선택: 2
		 * 아이디 abc123
		 * 비밀번호 : 1234
		 * 로그인 실패
		 * */

		Scanner scan = new Scanner (System.in);
		String answer;
		HashMap<String, String> map = new HashMap<String, String>();

		do {
			System.out.println("<-----메뉴----->\n1.회원가입 \n2.로그인 \n3.종료 \n메뉴를 선택하세요: ");
			answer = scan.next();
			switch(answer) {
				case "1":
					System.out.println("아이디: ");
					String id=scan.next();
					if(map.containsKey(id)==true) {
						System.out.println("이미 가입된 아이디입니다.");
						break;
					}
					System.out.println("비밀번호: ");
					String pw=scan.next();
					map.put(id,pw);
					break;
				case "2": 
					System.out.println("아이디: ");
					id=scan.next();
					System.out.println("비밀번호: ");
					pw=scan.next();
					if(map.containsKey(id)==true && map.containsValue(pw)==true) {
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
	/* 기능	 : 아이디입력하라고 출력, 입력받기 + 비번입력하라고 출력, 입력받기 + 저장
	 * 매개변수: String id, String pw
	 * 리턴타입: void
	 * 메소드명: singUp*/
	public void putId(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();

		System.out.println("아이디: ");
		String id1=id;
		System.out.println("비밀번호: ");
		String pw2=pw;
		map.put(id1,pw2);

	}
}


