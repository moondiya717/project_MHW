package Practice;

import java.util.Scanner;

public class StringTest1 {
	//charAt()메소드예제
	public static void main(String[] args) {
		/* 문자를 입력받고 입력받은 문자의 0번지 값을 출력하는 코드를 작성*/

		Scanner scan = new Scanner (System.in);
		System.out.print("문자를 입력하세요: ");
		char op = scan.next().charAt(0);	//next().charAt(번지) =>next()메소드 + charAt()메소드 
											//메소드가 연달아 나오는 체이닝기법*
		
	
		//char op = scan.next().charAt(0) 을 다른 코드로 쓴다면 아래 두 줄과 같음
		//String str =scan.next();
		//char op = str.charAt(0);
		
		
		System.out.println(op);	
		scan.close();
	}

}
