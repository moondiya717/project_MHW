package Practice;

import java.util.HashMap;
import java.util.Scanner;

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
		HashMap<String,String> loginInfo = new HashMap<String,String>();
		
		do {
			System.out.println("-----메뉴------ \n 1.회원가입\n 2.로그인 \n 3.종료\n--------------" );
			System.out.print("메뉴를 선택하세요: ");
			answer = scan.next();
			switch(answer) {
			case "1": 
				System.out.print("아이디 :");
				String id = scan.next();
				if(loginInfo.containsKey(id)) {
					System.out.println("이미 사용 중인 아이디입니다.");
					break;
				}
				System.out.print("비밀번호 :");
				String pw = scan.next();
				loginInfo.put(id,pw);
				break;
			case "2": 
				System.out.print("아이디 :");
				id=scan.next();
				System.out.print("비밀번호 :");
				pw=scan.next();
				if(!loginInfo.get(id).equals(pw)) {
					System.out.print("잘못된 입력입니다.");
					break;
				}
				System.out.println("로그인되었습니다. ");
				break;
			case "3": System.out.println("프로그램이 종료됩니다."); break;
			default: System.out.println("잘못된 입력입니다. ");break; 
			}
		}while(!answer.equals("3"));
		
		
		
		
	}

}
