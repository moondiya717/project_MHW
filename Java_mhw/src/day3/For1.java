package day3;

public class For1 {

	public static void main(String[] args) {
		/* Hello world! 5번 for문으로 출력하는 예제*/
		int i;
		/* 반복횟수 : i는 1부터 5까지 1씩 증가 => 초기화(~부터), 조건식(~까지), 증감식(~씩 증가/감소)을 결정
		 *          1->10으로 가면 크거나 같다 <-> 10->1 역으로 내려고게되면 조건식이 작거나 같다로 바뀌어야 함
		 * 규칙성 : Hello world! 를 콘솔에 출력
		 */
		
		for(i=1; i<=5; i++) { //동작하는게 없어서 전위형 써도 상관이 없음
			System.out.println("Hello world!");
			
		}
		
	}

}
