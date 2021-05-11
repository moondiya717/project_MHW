package day11;

public class FinalTest {

	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		System.out.println(ft.sum(1,2));
		TestC.PI2= 5; //에러발생 : 상수(final이 붙은 것)를 수정하려고 했기 때문에 
		TestC c = new TestC();
		c.PI  =3; //에러발생: 상수를 수정하려고 했기 때문에
	}
	public /* static */ int sum(int num1, int num2) {	//static이 붙은건 클래스 멤버 메소드라는 뜻, static이 안붙으면 객체 메소드=> 객체메소드는 객체없이 못씀
		return num1 + num2;						//객체메소드가 클래스메소드에서 사용될라면 객체 만들고나서 static없이(=객체메소드) 가능
	}
}
class TestC{
	public final double PI = 3.14;
	public static final double PI2 = 3.14;	//final이 붙으면 값을 수정할 수 없음
	public final int MAX_COUNT;		//생성자에서 상수를 초기화할 수 있음
	public TestC() {
		MAX_COUNT = 10;	//final 변수를 생성자에서 초기화
	}
}