package day13;

import day11.Board;

public class VariableTest {

	public static void main(String[] args) {
		int num5=0;		//일반변수, 지역변수
		String str3 = "Hello";	//참조변수, 객체(클래스 String을 통해 만들어짐), 지역변수
		
		int []arr = new int[5]; //참조변수, 배열, 지역변수
		Board[] board = new Board[5]; //참조변수, 배열, 지역변수
		
	}
}
class A{
	int num1;	//일반변수, 객체멤버변수
	static int num2;	//일반변수, 클래스멤버변수
	String str1;		//참조변수, 객체, 객체멤버변수
	static String str2;	//참조변수, 객체, 클래스멤버변수
	public A(int num3, int num4) {	// 일반변수, 매개변수 
		num1 = num3;
		num2 = num4;
	}
}
//모든 변수는 일반과 참조변수로 나뉜다. 값을 저장하면 일반, 주소를 저장하면 참조
//클래스 내에서 전체를 다 쓸 수 있으면 멤버변수, 일부 지역에서만 쓸 수 있으면 지역변수
//메소드에 전달하는 정보는 매개변수
//멤버변수는 1.클래스멤버변수 static 2.객체멤버변수 static(X)
//객체? 클래스를 통해만들어지는 것은 모두 객체, 배열은 그냥 배열