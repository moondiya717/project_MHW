package day11;

public class ConstructorOverloadingEx1 {

	public static void main(String[] args) {
		A a1 = new A();			// 기본생성자 씀
		A a2 = new A(1,2);		// 밑에 생성자 쓰려면, 정수 두개를 전달해야 함.
		A a3 = new A(1.0, 2);	// 실수가 정수로 자동형변환이 안되기 때문에 에러 발생 
		A a4 = new A('a', 3);	// 문자가 정수로 자동형변환이 되기 때문에 에러 발생하지 않음
		
	}

}
class A{
	private int num1;	
	private int num2;	
	
	
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	

	public void A() {}	//생성자와 이름이 같은 메소드
	
	public A() {}		//기본 생성자
	
/*	public A(int num3, int num4) {	//기본생성자와 매개변수 갯수가 다른 생성자 
		num1 = num3;
		num2 = num4;
	}	*/
	
	public A(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	//복사 생성자 : 생성자의 매개변수로 같은 클래스의 객체가 오는 경우
	public A(A a) {
		num1 = a.num1;
		num2 = a.num2;
	}
	
	
	public A(double num10, double num11) {	// int 2개짜리 매개변수 가진 생성자와 다른 타입(하나만 달라도 가능)의 매개변수를 가진 생성자
		
	}
}
