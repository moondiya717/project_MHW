package day6;

public class ClassEx1 {

	public static void main(String[] args) {
		// 교재 224-226의 필드선언

		int x=1;	//int x; 로해놓고 출력하면 값이 안뜨는데 이유는 일반변수는 초기값이 자동으로 초기화 안됨.
		Point1 point = new Point1();
		System.out.println("main의 x: "+ x);
		System.out.println("point의 x: "+ point.x);
		point.x=3;
		System.out.println("point의 x: " + point.x);
		Point1 point2 = new Point1(1,2);
		System.out.println("point2의 x: " + point2.x);

	}
}

//2차원 좌표 평면의 점을 나타내는 클래스 : Point1
//x좌표, y좌표 => 정수
class Point1{
	int x;	//멤버 변수는 초기값이 자동으로 초기값이 초기화
	int y;
	public Point1() {} //이라는 코드가 자동으로 만들어져서 객체를 실행할때 생성되야돼. //자동으로만들어지지만 안에 실행코드는 없어서 실행시켜도 뭐 안나옴. 	
	public Point1(int x1, int y1){		//클래스 명과 동일한 이름이면 public이 붙음생성자라고 생각하면 됨.
		x=x1;
		y=y1;
	}
}						

