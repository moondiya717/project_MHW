package day6;

public class MethodEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 20;
		System.out.println(num1+ ", " + num2);
		swap(num1, num2);	//1과 2가 바뀌어서 나와야하는데, 바뀌지않고 출력이 됨. 
		System.out.println(num1 + ", " + num2);
		
		
	}
	/* <잘못된 메소드의 예시>
	 * 기능    : 두 정수의 값을 바꾸는 메소드
	 * 매개변수 : 두 정수
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : swap*/
	public static void swap(int num1, int num2) {
		int tmp=num1;	//일반변수는 원본의 값이 바뀌지 않는다.
		num1 = num2;
		num2 = tmp;
	}
}
