package Practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest2 {

	public static void main(String[] args) {
	/* 중복되지 않는 5개의 수가 입력 될 때 까지 입력한 후, 입력이 완료되면 종료하는 코드를 작성하세요.
	 * 예시)
	 * 정수를 입력하세요 : 1
	 * 정수를 입력하세요 : 2
	 * 정수를 입력하세요 : 3
	 * 정수를 입력하세요 : 4
	 * 정수를 입력하세요 : 1
	 * 정수를 입력하세요 : 2
	 * 정수를 입력하세요 : 3
	 * 정수를 입력하세요 : 5
	 * 입력된 정수 : 1 2 3 4 5 (출력은 순서에 상관없이 나오는 것) =>만약에 순서가 상관이있으면List가 낫지
	 * */
	Scanner scan = new Scanner (System.in);
	HashSet<Integer> num = new HashSet<Integer>();
	
		while(num.size()<5) {
			System.out.print("정수를 입력하세요: ");
			num.add(scan.nextInt());
		}
		Iterator<Integer> it = num.iterator();	
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
	}
}