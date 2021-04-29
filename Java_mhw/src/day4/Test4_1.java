package day4;

public class Test4_1 {

	public static void main(String[] args) {
		/* 11부터 20까지 출력하는 코드를 작성하세요.
		 * 반복횟수 : i
		 * 규칙성 : i를 콘솔에 출력
		 * 반복문 종료 후 : 없음
		 * */
	
		
		int i;
		for (i=11;i<=20;i+=1) { //i+=숫자 => 하면 숫자만큼 늘어남 ㅎㅎ
			System.out.print(i + " ");
		}

		
		System.out.println(); //위의 예제랑 아래 예제랑 따로나오게 하기위해서 줄넣기 하나 함.
		
		/**20부터 11까지 출력하는 코드를 작성하세요. =>쌤은 위에 사용한 i를 그대로 사용했고, 나는 j로 새로 만듬
		 * 반복횟수 : i는 20부터 i는 11보다 크거나 같을때까지 i는 1씩 감소
		 * 규칙성 : i를 출력
		 * 반복문 종료 후 : 없음
		 * **/

		
		int j;
		for(j=20; j>=11; j-=1) {
			System.out.print(j + " ");
		}
		
		
		System.out.println();
		
		/* 1부터 100까지 숫자 중 일의 자리가 3, 6, 9로 끝나는 수들을 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 i는 10보다 작거나 같을때까지 i는 1씩 증가    //=>for말고 다른걸로도 할 수 있지 않을까
		 * 규칙성 : i를 10으로 나눴을 때 나머지가 3과 같거나
		 * 			i를 10으로 나눴을 때 나머지가 6과 같거나
		 * 			i를 10으로 나눴을 때 나머지가 9와 같으면
		 * 			i를 출력 
		 * 반복문 종료 후 : 없음*/
		
		int k, h; //h를 만들어서 출력 값을 3개씩 나눠서 줄바꿈을 할것임. h=출력된 숫자의 갯수
		for(k=1, h=0;k<=100 ;k+=1){ //h초기화는 int나 for 상관없음
			if(k % 10 ==3 || k % 10 ==6 || k % 10 ==9) {
				System.out.print(k+" ");
				h +=1; //h는 출력을 하고나서 증가를 해야 됨.
				if(h % 3 == 0) {
					System.out.println();
				}
			}
		}	

		
		
	}
}