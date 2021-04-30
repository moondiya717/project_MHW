package Practice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		////Math.random() 은 0보다 크거나 같고 1보다 작은 임의의 실수를 생성하는 기능
	
		//최대와 최소를 먼저 만들어야 돼 => 랜덤값을 만들고
		
		int min=1, max=100, num;
		int r = (int)(Math.random()*(max-min+1)+min);
		
		System.out.println(r);
		for( ; ; ) {
			System.out.print("정수를 입력하세요" + "(" + min + "~" + max + "): " );
			Scanner scan = new Scanner (System.in);
			num=scan.nextInt();
		 if(num<r) {
			System.out.println("up");
		}else if(num>r) {
			System.out.println("down");
		}else {
			System.out.println("정답!");
			}
		}
	
		
		
		
		
		
	}

}
