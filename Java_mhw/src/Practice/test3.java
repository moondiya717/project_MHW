package Practice;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		/* 콘솔에서 정수를 5번 입력받아 입력받은 값을 출력하는 코드를 작성하세요.*/
		
		int i, j=0;
		Scanner scan = new Scanner(System.in);
		
	
		
		/*콘솔에서 정수를 5번 입력받아 배열에 저장한 후 저장된 값을 출력하는 코드를 작성하세요.*/
		int []arr=new int[5];
		
		for(i=0; i<arr.length; i+=1) {
			System.out.print("정수를 입력하세요 :");
			arr[i] = scan.nextInt();
			System.out.println("입력된 값: "+ arr[i]);
		}
		
		
		
		
		
	}

}
