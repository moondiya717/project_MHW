package Practice;

import java.util.Scanner;

public class Test8_1 {

	public static void main(String[] args) {
		/* 1~9사이의 정수를 입력받아 각 숫자가 몇 번 입력됐는지 출력하는 코드를 작성하세요.
		 * -1이 입력되면 입력 종료하고 각 숫자가 몇 번 입력됐는지 출력
		 * 
		 * 예시)
		 * 입력: 1
		 * 입력: 1
		 * 입력: 9
		 * 입력: 3
		 * 입력: 2
		 * 입력: -1
		 * 1: 2번
		 * 2: 1번
		 * 3: 1번
		 * 4: 0번
		 * 5: 0번
		 * 6: 0번
		 * 7: 0번
		 * 8: 0번
		 * 9: 1번
		 * (반복횟수가 정해지지 않은 것을 유의할 것)
		 * */
		
		int user=0;
		Scanner scan = new Scanner (System.in);
		int arr[]=new int[10];
		
		while(true) {
			System.out.print("1-9사이의 정수를 입력하세요: ");
			user = scan.nextInt();
			if(user==-1) {
				break;
			}else if(user>=1 || user<=9){
				arr[user]=user;
			}
		}
		for(int i=1; i<10; i+=1) {
			System.out.println(i+"의 횟수 : " + arr[i] + "번");
		}
	}

}
