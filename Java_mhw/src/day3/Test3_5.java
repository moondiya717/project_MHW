package day3;

import java.util.Scanner;

public class Test3_5 {

	public static void main(String[] args) {
		/* 월의 마지막 일수를 출력하는 예제를 switch문으로 작성하세요
		 * 31일 : 1 3 5 7 8 10 12
		 * 30일 : 4 6 9 11
		 * 28일 : 2 */
		
		
		System.out.print("마지막 일수를 알고자하는 월을 입력하세요 :");

		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		switch (num) {
		case 1,3,5,7,8,10,12 :                                    //case 1: case 3: case 5: 처럼 한 줄에 한번에 나열을하면 
			System.out.println(num + "월은 31일까지 있습니다.");		  //맨마지막의 case 5만 실행문 취급(이유: break가 없어서 1->3->5)까지 진행
			break;
		case 4,6,9,11 :
			System.out.println(num + "월은 30일까지 있습니다");
			break;
		case 2 :
			System.out.println(num + "월은 28일까지 있습니다");
			break;
		default :
			System.out.println("잘못된 월을 입력했습니다.");
		}
		
		
		scan.close();
		
		
	}

}
