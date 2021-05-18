package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryTest5 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요.*/
		Scanner scan = new Scanner (System.in);
		System.out.print("두 정수를 입력해주세요 (예: 정수 연산자 정수 ): ");

	try {	
		int num1=scan.nextInt();				
		char op = scan.next().charAt(0);
		int num2=scan.nextInt();
		double res = 0.0;
		
		res = calculate(num1, op, num2);	//calculate메소드에서는 try-catch없음(직접처리안하고)메인이 직접처리했음
		
			System.out.println(num1 + "" + op + "" + num2 + "=" + res);
	}catch(InputMismatchException e) {
		System.out.println("잘못된 값을 입력했습니다");
	}catch(Exception e) {
		System.out.println(e.getMessage()); 	//한줄만나온대 ?_?
	}
	System.out.println("프로그램 종료합니다.");
	scan.close();	
	}
	
	/* 기능    : 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수와 산술연산자 => int num1,  char op, int num2
	 * 리턴타입 : 산술연산결과 => 실수 => double
	 * 메소드명 : calculate
	 * */
	
	public static double calculate(int num1, char op, int num2) {
		double res = 0.0;
		
		switch(op) {
			case '+': res= num1+num2;				break;
			case '-': res= num1-num2;				break;
			case '*': res= num1*num2;				break;
			case '%': 
				if(num2==0) { 	//num2가 0인 경우, 예외가 자동으로 발생되지만 if문과 throw를 쓰는 이유는 예외 메시지를 한글로 출력하고 싶어서
					throw new ArithmeticException("0으로 나눌 수 없습니다.");
				}
				res= num1%num2; 				
				break;
			case '/': 
				if(num2==0) {  //num2가 0이어도 실수/정수 이어서 예외가 자동으로 발생하지 않아서 예외를 발생시키기 위해 조건문if와 throw를 사용, infinity뜨는 것 방지
					throw new ArithmeticException("0으로 나눌 수 없습니다.");
				}res= (double)num1/num2;		break;	//정수/정수에서만 예외가 발생하는데 double강제변환으로 실수/정수가 됐기때문
			default:
				//잘못된 연산자가 들어오면 예외를 발생시킴
				throw new RuntimeException("잘못된 연산자입니다.");	//throws는 RuntimeException인 경우, 생략이 가능해서 안보임 => 떠넘기기 (try-catch가 없어서)
			}
		return res;
	}
	
	
	
	
	
	
}
//예외클래스 상속해서 클래스 생성가능 : 잘쓰지는 않지만 가능은 함




