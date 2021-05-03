package day6;

public class VariableEx1 {
	static int num=10;	//VariableEx1 클래스의 멤버변수 num
	public static void main(String[] args) {
		/* 지역변수 : 우리가 지금까지 사용한 일반 변수, 특정 지역에서만 사용가능한 변수 
		 * 			- 선언된 위치부터 해당 {}안 끝까지 사용 가능
		 * 멤버변수 : 클래스 안에 있는 변수로, 해당 클래스의 모든 곳에서 사용가능
		 * */
		//i는 main메소드 안에서 선언했기 때문에 선언 위치부터 main위치 끝까지 사용 가능.
		int i; 				//반복문 앞에서 선언 =>라인11~21까지 사용가능(보통괄호 앞 줄까지 글쓰니깐)	
		for(i=1; i<=5; i+=1) {
			System.out.print("*");
		}
		System.out.println(i); //5까지반복이니까 끝난 6때 잘 출력이 됨. 선언한 i값이 출력가능 범위 안이니깐.
		
		for(int k=1; k<=5; k+=1) {	//반복문 안에서 선언했기때문에 반복문 안에서만 사용가능 =>라인17~라인18까지 사용가능
			System.out.print("*");
		}
		System.out.println(/*k*/); //에러 발생: k는 반복문안에서만 선언됐기때문에 밑에서 출력을 할 수 없음.
		System.out.println(num);
	}
	public static void test() {
		//i=10; //에러 발생: test메소드에서는 i라는 변수를 선언하지 않았기 때문에
		System.out.println(num);
	}
}
