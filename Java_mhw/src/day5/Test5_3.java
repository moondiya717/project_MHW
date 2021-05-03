package day5;

import java.util.Scanner;

public class Test5_3 {

	public static void main(String[] args) {
		/* 콘솔에서 정수를 5번 입력받아 입력받은 값을 출력하는 코드를 작성하세요.*/

		
		int i;
		Scanner scan = new Scanner(System.in);
		
		for (i=1; i<=5 ; i+=1) {
			System.out.print("정수를 입력하세요: ");
			int num=scan.nextInt();
			System.out.println("출력 :" + num);
		} 

		/*콘솔에서 정수를 5번 입력받아 배열에 저장한 후 저장된 값을 출력하는 코드를 작성하세요.*/
		
		int []arr = new int[5];
		
		for (i=0; i<arr.length ; i+=1) { //0번지부터 시작 & 크기보다 5 (강조) 작을때까지! 라고 꼭 기억할 것  = arr.length 
			System.out.print("정수를 입력하세요: ");
			arr[i]=scan.nextInt();
			System.out.println("출력 :" + arr[i]);
		} 
		

		
		
		
		
		
		
		
			scan.close();
	}

}
