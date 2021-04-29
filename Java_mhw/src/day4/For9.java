package day4;

public class For9 {

	public static void main(String[] args) {
		/* 무한루프 : 반복문이 끝나지 않는 경우를 무한루프라 한다.
		 * */

		for( ; ;) {
			System.out.println("Hello world!"); //=> 초기화 증감식은 생략한 경우 항상 참이라서 무한루프에 빠지게 됨.
		}
	//	System.out.print(Hi); //=>위에서 무한루프를 진행중이라서 여기까지 실행 순서가 오질 않아서 출력이 안됨.
		
	}

}
