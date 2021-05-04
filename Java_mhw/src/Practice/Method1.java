package Practice;

public class Method1 {

	public static void main(String[] args) {
		//메소드 예제 
		
	add(1,2);
	System.out.println(add(1,2)); //알려주기 => return

	add2(3,5);
		
	}
	/* 기능	 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수: 두 정수 => int num1, int num2 
	 * 리턴타입: 정수의 합 => 정수 => int
	 * 메소드명: add
	 * */
	
	public static int add(int num1, int num2) {
		int res=num1+num2;
		return res;
	}
	/* 기능	 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수: 두 정수 => int num1, int num2 
	 * 리턴타입: 없음 = void
	 * 메소드명: add2
	 * */
	public static void add2(int num1, int num2) {
		System.out.println(num1+num2);
	}
	
}


