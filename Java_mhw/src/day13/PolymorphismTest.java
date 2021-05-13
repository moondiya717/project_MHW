package day13;

public class PolymorphismTest {  //필드의 다형성		//매개변수의 다형성(다양한 클래스로 만들수 있게 해주는 게 다양성)

	public static void main(String[] args) {
		// 330?~334p : 필드(멤버변수)의 다형성 , 335p~ : 매개변수의 다형성
		Car2 c = new Car2();		//Car2의 멤버변수들이 Tire라는 클래스의 ...?
		c.frontLeftTire = new KumhoTire();
		c.frontRightTire = new KumhoTire();
		c.frontLeftTire = new HankookTire();
		c.frontRightTire = new HankookTire();
		
		//사고 후, 앞 왼쪽 바퀴를 한국타이어로 교체
		c.frontLeftTire = new HankookTire();
		c.frontRightTire = new HankookTire();
		
		//왼쪽 앞바퀴를 정비하고싶을 때
		boolean isOk1 = confirm(c.frontLeftTire);
		boolean isOk2 = confirm(c.frontRightTire);

		
	}
	/* 기능    : 타이어에 이상이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 타이어 //금호,한국 타이어를 모두 확인할 수 있는 타이어로 해야 함 => Tire t
	 * 리턴타입 : 이상여부 => 참/거짓 => boolean
	 * 메소드명 : confirm */
	
	//매개변수의 다형성을 확인하는 예제, instanceof를 이용하면 매개변수의 다형성을 처리하기가 쉬워진다.
	public static boolean confirm(Tire t) {
		//타이어 t가 한국타이어면 예외가 발생하지 않고, 금호타이어면 예외가 발생함
		//HankookTire ht = (HankookTire)t;			예외가 발생할 수도 있고 안할수도있는데 쌤은 발생해는데 나는 암것도 안뜸 왜지
		if(t instanceof HankookTire) {
			HankookTire ht = (HankookTire)t;
			//한국 타이어 검사하는 코드 작성 (했다고 가정.)
			System.out.println("한국타이어 검사 끝!");

		}
		else if (t instanceof KumhoTire) {
			KumhoTire kt = (KumhoTire)t;
			//금호 타이어 검사하는 코드 작성(했다고 가정.)
			System.out.println("금호 타이어 검사 끝!");
		}
		return false;	//확인할 수 있는 방법이 없으니까 항상 false가 나올거임ㅋ 실제로 메소드(기능)를 만드는게 아니라, 이런 메소드가 있다를 보여주기 위한 예시
	}

}
class Car2{		//똑같은 이름의 클래스가 같은 패키지 안에 있으면 안되서 Car2라고 이름지음 
	//멤버변수(필드)의 다형성
	public Tire frontLeftTire;
	public Tire frontRightTire;
	public Tire backLeftTire;
	public Tire backRightTire;
}
class Tire{}

class KumhoTire extends Tire{}
class HankookTire extends Tire{}

//부모클래스를 통해서 다른 클래스들을 모두 아우를 수 있도록 매개변수와 매개변수를 사용하도록 해라. => 다양성
//자식 클래스를 기준으로하면, 부모의 다른 자식 클래스들을 모두 확인하거나 호환하지 못해
