package Practice;

import java.util.Scanner;

public class Dowhile {

	public static void main(String[] args) {
		/* 입력받은 문자가 q또는 Q이면 종료하는 예제 */
		
		int i;
		Scanner scan = new Scanner(System.in);
		
	
		for( ; ; ) {
			System.out.print("종료하려면 q또는 Q를 입력하세요. ");
			char op = scan.next().charAt(0);
			if((char)op=='q' ||(char)op=='Q') {
				break;
			}
		}
	
				
		//Dowhile문으로 입력받은 문자가 q또는 Q이면 종료하는 예제 만들기		
		/* 	do{
				실행문;
			}while(조건식);  */
				
		char ch;
				
			do {
				System.out.print("종료하려면 q 또는 Q를 입력하세요.");
				ch=scan.next().charAt(0);
			}while((char)ch!='q' || (char)ch!='Q');
				
		
		
		/*- 논리연산자 : 참 또는 거짓
   		 	&&: ~하고, 둘다 참인경우만 참, 나머진 거짓
  			||: ~하거나, 둘다 거짓인 경우만 거짓, 나머진 참
  			! : 반대, 참이면 거짓, 거짓이면 참*/
		
		
		
	}

}
