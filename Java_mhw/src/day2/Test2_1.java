package day2;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		/* 국어, 영어, 수학 성적을 입력받아 출력해보세요.
		 * 단, 성적은 0~100점 사이의 실수 */

		//변수 타입이 동일한 경우에는, 한번에 콤마 이용해서 변수선언 가능
		double korScore, engScore, mathScore;
		
		//점수 한번에 입력가능함...신기
		System.out.print("국어, 영어, 수학 성적을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);

		korScore = scan.nextDouble();
		engScore = scan.nextDouble();
		mathScore = scan.nextDouble();
		
		System.out.println("국어 : " + korScore + "점");
		System.out.println("영어 : " + engScore + "점");
		System.out.println("수학 : " + mathScore + "점");
		
		scan.close();
		
		
		
	}

}
