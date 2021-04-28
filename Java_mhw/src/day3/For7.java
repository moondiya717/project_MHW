package day3;

import java.util.Scanner;

public class For7 {

	public static void main(String[] args) {
		/* 두 정수의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수 (예: 6의 약수는 1, 2, 3, 6 -> 나머지가 0이란 뜻)
		 * 공약수 : 공통으로 있는 약수
		 * 8의 약수 : 1, 2, 4, 8
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8과 12의 공약수 : 1, 2, 4
		 * 최대 공약수 : 공약수 중 가장 큰 수
		 * 8과 12의 최대 공약수는 4
		 *
		 * 두 정수: num1=8, num2=12
		 * 반복횟수: i는 1부터 num1까지 1씩 증가
		 * 규칙성 : i가 num1의 약수이고 i가 num2의 약수이면 i를 변수 gcd에 저장
		 * 			=>num1을 i로 나눴을 때, 나머지가 0과 같고
		 * 			  num2를 i로 나눴을 때, 나머지가 0과 같다면
		 * 			  i를 변수 gcd에 저장
		 * 반복문 종료 후 : gcd에 저장
		 * */

		

		System.out.print("두 개의 정수를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		int i, gcd=1; //쌤은 gcd=1; 이라고 어차피 최소공약수가 1이라서 1로 초기화시키셨음
		
		for(i = 1; i<=num1&&i<=num2; i += 1) { //i<=num1&&i<=num2 는 숫자중 최소값까지만 검사, i<=num1 는 그 수까지만 체크하는데 if에서걸러짐.
			if(num1 % i ==0 && num2 % i==0) {
				gcd=i;
			}
		}
		System.out.print(num1+ "와(과) "+ num2 + "의 최대 공약수는 " + gcd + "입니다.");
		
	
		scan.close();	
	}
					
}


