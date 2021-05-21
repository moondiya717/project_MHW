package day18;

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
		
		//필요한 객체를 생성
		Scanner scan = new Scanner (System.in);
		HashSet<Integer> set = new HashSet<Integer>();

		//반복문을 통해 정수를 콘솔에서 입력 받음
		/*
		 *  while(true) {
				System.out.print("정수를 입력하세요: ");
				int num = scan.nextInt();
				set.add(num);
				if(set.size()==5) {
					break;
				}
			}
		*/
		while(set.size() < 5) {	//일단얘도 0부터 시작해서 4까지오면 5갠가보다?
			System.out.print("정수를 입력하세요: ");
			//Integer num = scan.nextInt();
			//set.add(num);
			set.add(scan.nextInt());	//위에 주석처리한 두 줄을 한줄로 이렇게 나타낼 수 있음
		}
		
		//입력받아서 저장했던 숫자들을 출력
		System.out.print("입력된 정수: ");
		Iterator<Integer> it = set.iterator();	
		while(it.hasNext()) {	
			//Integer tmp = it.next();	
			//System.out.print(tmp+ " ");	
			System.out.print(it.next() + " ");	//위에 두줄을 한줄로 나타낼 수 있음
		}								
		System.out.println();
	
	scan.close();
	}
}
