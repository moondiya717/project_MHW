package day2;
import java.util.Scanner;

public class Test2_8 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 입력받은 연산자에 맞는 연살결과를 출력하는 코드를 작성하세요.
		예시 
		두 정수와 연산자를 입력하세요 : 1 + 2
		1 + 2 = 3
		
		예시
		두 정수와 연산자를 입력하세요 : 1 / 2
		1 / 2 = 0.5
		
		*=> 입력받은 연산자가 +이면 +한 결과를 출력, -이면 -한 결과, *이면 *한 결과, %이면 %결과
		*/
		
		System.out.print("두 정수와 연산자를 입력하세요 :");
		
				Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		char ch = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		//if(ch == '+') {
			//System.out.println(""+ num1 + ch + num2 + "=" + (num1+num2));
			
		//}else if(ch == '-') {
			//System.out.println("" + num1 + "" + ch + "" + num2 + "=" + (num1+num2));
		
		double result = 0.0;
				
				if(ch == '+') {
					result= num1 + num2;
				}else if(ch == '-') {
					result = num1 - num2;
				}else if(ch == '*') {
					result = num1 * num2;
				}else if(ch == '%') {
					result = num1 % num2;
				}else if(ch == '/') {
					result = (double)num1 * num2;
				}
				System.out.println("" + num1 + ch + num2 + "=" + result);
		
	}
}	
		

		
		
