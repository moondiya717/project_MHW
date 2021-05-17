package day15;

public class AnonymousTest {

	public static void main(String[] args) {
		//TvRemocon클래스를 이용하여 객체를 만든 것과 같은 결과를 가진다.
		//단, 해당 익명객체를 사용하려면 코드를 복붙해야 하기 떄문에 비효율적이다.
		Remocon r = new Remocon() {
			@Override
			public void turnOn() { System.out.println("전원 켜짐");}	//이거메소든데 main안에있잖아. 원래 main안에서 메소드선언못하는데 한거라면 => 익명객체다 
			@Override
			public void turnOff() { System.out.println("전원 꺼짐");}
			
		};
		r.turnOn();
	}
}


abstract class Parent{
	public abstract void print();
}

class Child extends Parent{
	@Override
	public void print() {
		System.out.println("안녕");
	
	}
}

class TempA{
	//private Parent p = new Child();		//앞에서 child 클래스만들고나서 객체를 만든 것
	//Parent 추상 클래스를 이용하여 새로운 익명 객체를 생성한 후, 생성한 익명 객체의 주소를 p와 저장
	private Parent p = new Parent(){
		int num = 10;
		public void print() {				//지금 클래스를 새로 하나 만든 것
			System.out.println("안녕");
		}
	};
}
interface Remocon{
	void turnOn();
	void turnOff();
}
class TvRomocon implements Remocon {
	public void turnOn() {System.out.println("전워 켜짐");}
	public void turnOff() {System.out.println("전원 꺼짐");}
	
	}
}