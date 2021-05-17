package day15;

//인터페이스의 다형성
public class PolymorphismTest {

	public static void main(String[] args) {
		Car car = new Car();
		car.frontLeft.roll();
		car.frontRight.roll();

		repair(car.frontLeft);	//한국타이어 수리
		repair(car.frontRight);	//금호타이어 수리
		
	}
	//인터페이스를 이용한 매개변수의 다형성을 살펴보는 예제
	public static void repair(Tire tire) { //매개변수가 Tire로 오게해서 한국,금호타이어를 모두 수리할 수 있도록 함 => 매개변수의 다형성
		/*(HankookTire)tire.company : Tire 인터페이스의 멤버변수 company를 찾은 후, tire를 HankookTire로 타입변환
		 *((HankookTire)tire).company : tire를 한국타이어로 타입 변환 후, 멤버 변수 company를 찾음
		 * 
		 * */
		if(tire instanceof HankookTire) {
			HankookTire t = (HankookTire)tire;
			System.out.println(t.company + "수리합니다."); //밑에랑 같은거
			System.out.println(((HankookTire)tire).company + "수리합니다.");
		}
		if(tire instanceof KumhoTire) {
			KumhoTire t = (KumhoTire)tire;
			System.out.println(t.company + "수리합니다.");
			System.out.println(((KumhoTire)tire).company + "수리합니다.");
		}
	}
}
class Car{			// hankooktire = new kumhotire; 안돼. 상속관계가 아니라서 
	//인터페이스를 이용한 멤버변수(필드)의 다형성 예제
	Tire frontLeft = new HankookTire();
	Tire frontRight = new KumhoTire();
}	

interface Tire{
	void roll(); //바퀴가 구르는 기능 
}
class KumhoTire implements Tire{
	String company = "금호";
//class랑 interface 가 KumhoTire앞자리에 올 수 있고    tire앞에는 extends나 implements가 올수 있는자리. 
//class => interface는 객체를 만들 수 없으므로 class이며, implements => tire를 구현해야함.
	public void roll() {
		System.out.println("금호 타이어가 굴러갑니다.");
	}
}
class HankookTire implements Tire{
	String company = "한국";
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");
	}
}