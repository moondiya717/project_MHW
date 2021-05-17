package day15;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class A1{
	void print() {
		System.out.println("Hello");
	}
}
class A2{
	void print() {
		System.out.println("Hi");
	}
}


class AC extends A1 /*, A2 */ {	//에러발생: (주석처리)애초에 A1, A2 두개가 안돼, 만약에 된다고 한들 부모 클래스에 메소드 이름이 똑같으니까 충돌나서 에러가 남 
	void test() {			//부모가 A1, A2 둘 다 이면, print() 메소드를 호출했을 때 누구의 메소드인지 구별할 수 없다. 그래서 클래스에서 상속은 부모가 1명만 올 수 있다.
		print();
	}
}		

interface B1{
	void print();
}

interface B2{
	void print();
}

class BC implements B1, B2{	//문제없음: 어차피 자식클래스에서 오버라이드하며서 메소드 재정의를 하기 때문에, 문제가 일어나지 않음. 
	@Override
	public void print() {
		System.out.println("안녕");
	}
}

//C1클래스는 A1클래스를 상속받고 B1,B2 인터페이스를 구현한 클래스이다.

class C1 extends A1 implements B1, B2{
	@Override
	public void print() {
		System.out.println("안녕");
	}
}

