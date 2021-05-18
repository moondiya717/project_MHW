package day16;

import java.util.Scanner;

public class TryTest4 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요.*/
		Scanner scan = new Scanner (System.in);
		System.out.print("두 정수를 입력해주세요 (예: 정수 연산자 정수 ): ");

	try {	
		int num1=scan.nextInt();				//입력자가 숫자가 아닌 다른것을입력했을때 예외발생
		char op = scan.next().charAt(0);
		int num2=scan.nextInt();
		double res = 0.0;
		
		
		//조건문을 이용하여 산술연산자에 따라 연산을 함
		switch(op) {
		case '+': 
			res= num1+num2;				break;
		case '-': 
			res= num1-num2;				break;
		case '*': 
			res= num1*num2;				break;
		case '%': 
			res= num1%num2; 			break;
		case '/': 
			res= (double)num1/num2;		break;	//정수/정수에서만 예외가 발생하는데 double강제변환으로 실수/정수가 됐기때문
		default:
			throw new Exception("잘못된 연산자입니다.");
		}
			System.out.println(num1 + "" + op + "" + num2 + "=" + res);
	}catch(ArithmeticException e) {
		System.out.println("0으로 나눌 수 없습니다.");
	}catch(Exception e) {
		System.out.println(e.getMessage()); 	
	}
	System.out.println("프로그램 종료합니다.");
	scan.close();	
	}
}
//예외클래스 상속해서 클래스 생성가능 : 잘쓰지는 않지만 가능은 함

// ? ? ? 넣으면 왜 null 뜨지 갑자기 아깐 예외발생했다고 했지않았나




