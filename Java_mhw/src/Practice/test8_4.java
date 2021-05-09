package Practice;

public class test8_4 {

	public static void main(String[] args) {
		/* 1번 문제 : 1부터 10까지 한 줄로 출력되는 코드를 작성하세요.*/

		for(int i=1; i<=10; i+=1) {
			System.out.print(i+" ");
		}
		
System.out.println();
System.out.println("--------");

		/* * 2번 문제 : 다음과 같이 되도록 코드를 작성하세요.
		 * 1 2 3 4 
		 * 5 6 7 8 
		 * 9 10
		 * 힌트 : 4의 배수에서 줄바뀜*/
		for(int i=1; i<=10; i+=1) {
			System.out.print(i+" ");
			if(i%4==0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("--------");

		/* * 3번 문제 : 다음과 같이 되도록 코드를 작성하세요.
		 * 1, 2, 3, 4 
		 * 5, 6, 7, 8 
		 * 9, 10,11,12
		 * 힌트: 4의 배수이면 엔터를 출력, 4의 배수가 아니면 , 를 출력
		 * */
		for(int i=1; i<=12; i+=1) {
			System.out.print(i+" ");
			if(i%4==0) {
				System.out.println();
			}else if(i%4!=0) {
				System.out.print(",");
			}
		}
		
		System.out.println();
		System.out.println("--------");		
		
		/* * 4번 문제 : 다음과 같이 출력 되도록 코드를 작성하세요.
			힌트: 3번문제코드에 홀수일때 +1, 짝수일때 -1출력을 이용
		 	* 2 1 4 3					1 2  3  4
		 	* 6 5 8 7 					5 6  7  8
		 	* 10 9 12 11 				9 10 11 12
		 * */
		
		for(int i=1; i<=12; i+=1) {
			if(i%4==0) {
				System.out.print(i-1+ " ");
				System.out.println();
			}else if(i%2==0) {
				System.out.print(i-1+ " ");
			}else if(i%2!=0) {
				System.out.print(i+1+" ");
			}
		}
		
		
		
		
		
	}

}
