package Practice;

import java.util.HashMap;
import java.util.Scanner;

public class MapTest2 {

	public static void main(String[] args) {

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
