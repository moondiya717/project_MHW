package day4;

public class Test4_2 {

	public static void main(String[] args) {
		/*1부터 10까지의 짝수들을 continue를 이용하여 출력하는 코드를 작성하세요.*/ 

		
		int i;
		for(i=1; i<=10; i+=1) {
			if(i % 2 == 0) { //i가 홀수이면 건너뛰면 됨
				continue;
			}
			System.out.print(i + " ");
		}
		
	
		
		
	}

}
