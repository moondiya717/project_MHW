package day5;

import java.util.Scanner;

public class Dowhile {

	public static void main(String[] args) {
		/* 입력받은 문자가 q또는 Q이면 종료하는 예제 */

		char ch;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("입력(종료하려면 q/Q입력) :");
			ch = scan.next().charAt(0);
		}while(ch !='q' && ch !='Q');    //q랑 Q아닐때만 반복해
		
		// while문은 조건식을 생략하는 것이 불가능하기 때문에 while(true) == while(1==1) 와같이 당연한 것을 쓰면, 무한 반복함.
		
		
		
		scan.close();
	}

}
