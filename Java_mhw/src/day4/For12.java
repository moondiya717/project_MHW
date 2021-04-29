package day4;

public class For12 {

	public static void main(String[] args) {
		/* 하나의 *(곱하기)를 이용하여 다음과 같이 출력되도록 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * */

		int i, k;
		//*를 이용하여 *****
		for(k=1;k<=5;k+=1) {
					for(i=1; i<=5; i+=1) {
			System.out.print("*");

		}
		System.out.println();
		}

		System.out.println("11111111111111111111111");
		
		
		// 뭔가 Test4_1이랑 결합해서 중첩for문말고 이걸로도 가능하지 않을까? 나중에 해봐여지
		char op='*';
		for(k=1;k<=25;k+=1) {
			System.out.print(op);
			if(op==(op*5)) {
				System.out.println( );;
			}

			}
	
	
		}
		
	}


