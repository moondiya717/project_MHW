package day3;

import java.util.Scanner;

public class For6 {

	public static void main(String[] args) {
		/**정수의 약수를 출력하는 코드를 작성하세요. => 나머지가 0
		 * 예시
		 * 정수를 입력하세요 : 6
		 * 1 2 3 6 
		 * 정수 : num
		 * 반복횟수 : i는 1부터 정수까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력 => num를 i로 나눴을때, 나머지가 0과 같으면 i를 출력
		 * 반복문 종류 후 : 없음
		 * **/
		
		System.out.print("양의 정수를 입력하세요 :");
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int i;									//result에 i의 값을 나열처럼 저장해서 마지막에 ""문자열이랑 함께 한 줄로 출력하고싶다.
		
		for(i=1;i<=num ;i++){ //앞으로 수업에서는 i++ 을 i+=1로 통일하겠음.
			if(num % i == 0) {
				System.out.print(i+ " ");
			}
		
			scan.close();
		}

		
		
		
		
		
	}

}
