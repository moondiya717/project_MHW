package day2;

public class ArithmeticOperator {

	public static void main(String[] args) {
		// 산술연산자 /(나누기) 예제
		//정수/정수=정수, 계산식에 실수가 하나라도 있으면 답도 실수로 나옴
		System.out.println("1  /2   = " + 1  / 2);
		System.out.println("1.0/2   = " + 1.0/2);
		System.out.println("1  /2.0 = " + 1  /2.0);
		System.out.println("1.0/2.0 = " + 1.0/2.0);
		int num1 = 1, num2 = 2;
		/*실수의 값을 내야할 때, 숫자가 아니라 변수 이름으로 계산해야 하면 
		 * num1을 일시적으로 아래와 같이 실수로 변환하여 계산함. (강제 타입 변환) */
		System.out.println((double)num1 / num2); //나누기 연산자
	
		
		System.out.println( "7 % 4 = " + 7 % 4); //나머지 연산자
		
		//문자에 +더하기를 하면 그 다음 문자가 나옴.
		char ch = 'A';
		ch = (char)(ch + 1);
		System.out.println(ch);
		
		char ch2 = 65;
		// char 65 + int 1  => int가 되어서 char에 그냥 저장할 수 없음
		// 강제 타입 변환을 해줘야 한다. (더하기를 할때는 타입이 큰 쪽에 맞춰서 더하기가 진행됨)
		ch2 = (char)(ch2 + 1);
		System.out.println(ch2);
		
		
		
	}

}
