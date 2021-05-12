package day12;

public class initializeTest {	//초기화순서
	public static void main(String []args) {
		TestA ta = new TestA();
		System.out.println(ta.getNum());
		System.out.println(TestA.getRes());
	}
}
/* 객체 변수 초기화 순서 //생성자 초기화로 초기화하는게 코드다루기 편함
 * 1. 변수 선언시 기본값으로 초기화
 * 	- num는 0으로 초기화
 * 2. 명시적 초기화
 * 	- num는 1로 초기화
 * 3. 초기화 블록
 * 	- num= 3
 * 4. 생성자 초기화
 * 	- num는 2로 초기화 
 * 
 * -> 기본값이 아닌 값들은 생성자에서 초기화 하자, 그러면 항상 마지막이 생성자이기때문에 다른 초기화를 신경쓰지 않아도 돼(객체 변수에 한해서)
 * 
 * 클래스 변수	//생성자초기화는 객체없이 쓸수가 없자넝 그래서 클래스 변수는 그게 없어서 3개, 명시적 초기화가 코드다루기 편함
 * 1. 변수 선언시 기본값으로 초기화
 * 	-res를 0으로 초기화
 * 2. 명시적 초기화
 * 	-res를 10으로 초기화
 * 3. 초기화 블록
 * */
class TestA{
	private int num=1;	//변수선언 및 초기화, 명시적 초기화
	private static int res= 10;
	{					// {} 중괄호를 열고 닫는 사이에 써주면 그게 초기화 블록임, 초기화 블록: 객체변수
		num=3;			
	}	
	//초기화 블록 : 클래스 변수(static이 붙은거)
	static {
		res = 20;
	}
	
	public TestA() {	//생성자를 통해 초기화
		num=2;
	} 
	public int getNum() {
		return num;
	}
	public static int getRes() {	//static -> class
		return res;
	}
}