package Practice;

public class method3 {

	public static void main(String[] args) {
	
	int num1=5, num2=10;
	System.out.println(num1+","+ num2); //메소드 전 출력 5,10
	
	swap(num1, num2);
	System.out.println(num1+ "," + num2); //메소드 발동 후 여전히 출력 5,10
		
	}
	//잘못된 메소드 예시(일반변수 값 바꾸기 시도)
	/* 
	 * 기능    : 두 정수의 값을 바꾸는 메소드
	 * 매개변수 : 두 정수
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : swap*/
	public static void swap(int num1, int num2) {
		int tmp=num1;
		num1=num2;
		num2=num1;
	}
	
}
