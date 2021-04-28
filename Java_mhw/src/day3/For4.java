package day3;

public class For4 {

	public static void main(String[] args) {
		/* 1부터 10까지의 짝수들만 출력하는 코드를 작성하세요
		 * 1. 짝수인지 아닌지 확인해서 출력하는 방법
		 * 2. X2로 출력하기
		 * 3. 2로 시작해서 +2를 진행
		 * 
		 * */ 

		
		int i; //2부터 10까지 짝수들만 확인하고 출력
		for (i=2;i<=10;i=i+2) {
			System.out.print(i + " ");
		}
		
		
		int m;
		for (m=1; m<=5; m++) {
			System.out.print(m*2 + " ");
		}
		
		
		int w; // 1부터 10까지 다 확인 한 후 짝수들만 출력
		for(w=1; w<=10; w++) {
			if(w % 2 == 0) {
				System.out.print(w + " "); //ln 줄바꿈 빼고 옆에 띄어쓰기를 넣으니까 가로로 배열되서 나옴
			}
		
		}
		int h; //2부터 10까지 짝수들만 확인하고 출력
		for(h=2; h<=10; h=h+2) {
			System.out.print(h + " ");		
		
		}
		
	

	}
}
	

	
