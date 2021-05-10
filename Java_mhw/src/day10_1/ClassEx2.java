package day10_1;

import day10.A; //day10패키지에 있는 A라는 클래스를 가져오려한다.
import day10.B;
import day10.C;
import day10.D;
import day10.ClassEx1; //day10패키지에 있는 클래스 ClassEx1을 가져오려 한다.

public class ClassEx2 {

	public static void main(String[] args) {
		A a = new A();
		//public이라서 에러가 발생하지 않음
		B b = new B();
		//protected : Class B와 ClassEx1은 같은 패키지에 있기때문에 에러 발생하지 않음
		//클래스 B와 ClassEx2는 다른 패키지에 있기 때문에 에러 발생
		C c = new C();
		//(default) : Class C와 ClassEx1은 같은 패키지에 있기때문에 에러 발생하지 않음
		//클래스 C와 ClassEx2는 다른 패키지에 있기 때문에 에러 발생
		D d = new D();
		//d.num=10; 에러발생 : num의 접근 제한자가 private여서 


	}

}
