package day15;

public class ClassCastExceptionTest {

	public static void main(String[] args) {
		Figure f = new Rect();
		Figure f1 = new Rect();
		Figure f2 = new Figure();
		//클래스 타입 변환이 불가능하여 예외 발생
		//Rect r2=(Rect)f2; //f2가 figure부모껄로 만들어서 예외가 발생함.
		//=>조건문과 instanceof를 이용한 예외 방지
		if(f2 instanceof Rect) {
			Rect r2 = (Rect)f2;
			System.out.println("타입 변환 성공");
		}
		
		
		
		Rect r1 = (Rect)f1; //예외발생안함: Rect로 만들었으니깐
		
	}

}
class Figure{}
class Rect extends Figure{};
