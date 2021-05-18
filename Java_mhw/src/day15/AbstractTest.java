package day15;

public class AbstractTest {

	public static void main(String[] args) {
		// 클래스 A의 객체 a를 생성
		A a = new A();	//기능은 없지만 생성되는 데 문제 없음

		//추상클래스B의 객체 b를 생성
		B b = new B(); //오류발생: 추상클래스는 객체를 생성할 수 없다
		
		//추상 클래스 B를 상속받은 클래스 C의 객체 c를 생성
		C c = new C();
		
		//클래스 C를 이용하여 객체를 생성한 후, 추상 클래스 B의 객체에 저장
		B b1 = new C();	//클래스 타입변환(자동)
	}

}
class A{}	//일반클래스


abstract class B{
	abstract void print();	//추상 메소드 만들 수 있음. (구현을 안해도 되니깐 더 편함)
} //추상클래스


class C extends B{

	@Override
	void print() {
		// TODO Auto-generated method stub
		
	}}	//B를 상속받는 일반 클래스 C
//추상메소드 B에 추상메소드를 만들자 C에 오류남. 해결책1. C를 추상클래스로 만들거나 해결책2. 오버라이드를 해줘야 함.




//타입 변환은 부모-자식 관계에서만 가능함
//상속받은 자식클래스를 이용하거나	C c = new C(); , 상속받은 클래스를 통해서 객체 생성가능 B b1 = new C();