package day4;

import java.util.Scanner;

public class For10 {

	public static void main(String[] args) {
		/*반복횟수가 정해져 있지 않은 예제
		 * 콘솔에서 q나 Q를 입력받을 때까지 반복하는 예제*/

		Scanner scan = new Scanner(System.in);
		
		char ch = 'a'; //반복문에서 값을 비교하려면 초기값이 있어야 함.
		for( ; ch != 'q' && ch != 'Q' ; ) { // && 로 해야 함. ||로 하면 둘 중 하나만 아니어도 되는거라서 작동해버림.
			System.out.print("알파벳을 입력하세요(종료하려면 q 또는 Q를 입력): ");
			ch= scan.next().charAt(0);
		}

		
		
		
		
		
		
		scan.close();
	}

}
