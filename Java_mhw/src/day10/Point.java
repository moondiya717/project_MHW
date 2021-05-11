package day10;

/* 2차원 좌표 평면의 점을 타나내는 클래스 : Point
 * 멤버 변수 : x좌표, y좌표
 * 멤버 메소드 : 좌표를 출력하는 기능, 좌표를 이동하는 기능*/
public class Point {
	private int x,y; //private로 된 멤버변수 선언 ( private 타입 멤버변수)

	/* 기능	  : 멤버변수 x,y좌표를 출력하는 기능 
	 * 매개변수 : 없음(멤버 변수 x,y를 이용) 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print
	 *  */
	
	public void print() {
		//멤버변수(위에선언한x,y)를 멤버메소드에서 사용하는 경우, 따로 선언을 하지 않아도 됨. (지역변수와 다른 개념)
		System.out.println("(" + x + "," + y + ")");
	}
	/* 기능    : 지정된 좌표로 이동하는 메소드
	 * 매개변수 : 이동해야할 지정된 좌표 x, y => int x1, y1
	 * 리턴타입 : 없음 => void (이동하고 끝)
	 * 메소드명 : move
	 * */
	public void move(int x1, int y1) {
		x=x1;
		y=y1;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	/* 초기 x,y좌표가 x1, y1주어지면 주어진 x,y좌표로 멤버변수를 초기화하는 생성자*/
	public Point(int x1, int y1) {
		x =x1;
		y =y1;
	}
	public Point() {
							// public Point(int x1, int y1)~ } 는 생성자를 위에 써서 이전에 다른 클래스에서 가져간 point 값들이 쓰던 기본 생성자들이 자동으로 없어져서
	}						// public Point(){} 기본생성자 한줄을 추가해줘야 값을 가져간 다른 클래스들 오류가 해결 됨.	
	
	public Point(Point pt) {	//lu를 위한거껄?
		x = pt.x;
		y = pt.y;
	}
}
