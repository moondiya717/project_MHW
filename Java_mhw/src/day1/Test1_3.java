package day1;

import java.util.Scanner;

public class Test1_3 {

	public static void main(String[] args) {
		// 두 정수와 문자를 입력받아 출력하는 예제를 작성하세요.
		/* 정수1을 입력하세요: 1
		 * 문자를 입력하세요 : +
		 * 정수2를 입력하세요 : 2
		 * 1 + 2 
		 * */

		//ctnl+shift+O =>단축기 scanner더하는 
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수1을 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("입력받은 값 : " + num1);
		
		System.out.print("문자를 입력하세요 : ");
		char ch = scan.next().charAt(0);
		System.out.println("입력받은 값: " + ch);
		
		System.out.print("정수2을 입력하세요 : ");
		int num2 = scan.nextInt();
		System.out.println("입력받은 값 : " + num2);
		
		
		System.out.println(""+num1+ch+num2);
		
		
		System.out.print("두 정수와 문자를 입력하세요(예: 1+2) :");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
		System.out.println("" + num1 + ch + num2);
		
		//테스트할 때, 1+2 입력할 경우에는 스페이스바를 중간에 껴넣어줘야 함. 숫자 더하기 계산이 아니라서.

		
		
		
		scan.close();
	}

}
