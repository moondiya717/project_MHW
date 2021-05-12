package day11;

public class MethodOverloadingTest {

	public static void main(String[] args) {
		Point2 pt = new Point2();
		pt.print();
		
		pt.move(4, 5);
		pt.print();
		
		Point2 pt2 = new Point2(10,20);
		pt.move(pt2);
		pt.print();
		
		System.out.println(1);		//println이라는 이름으로 뒤에 int 1
		System.out.println("1"); 	//String 1
		System.out.println('1');	//char 1
	}
}
class Point2{
	private int x, y;		//자동으로 초기값 int는 0들어감
	
	
	public Point2() {
		this(0,0);
	}
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2(Point2 pt) {	//복사생성자, public 클래스명(클래스명 객체명){}
		this(pt.x, pt.y); 		// this() 생성자는 항상 첫줄에 놔줘야 함
	}
	public void print() {
		System.out.println("( " + x + "," + y + " )");
	}
	/* 기능    : 이동할 x, y 좌표가 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수 : 이동할 x, y 좌표 => int x, int y
	 * 리턴타입 : 없음 => void
	 * 메소드명 : move
	 * */
	public void move(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/* 기능    : 이동할 좌표가 Point2의 객체로 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수 : 이동할 좌표 Point2의 객체 => Point2 pt
	 * 리턴타입 : void
	 * 메소드명 : move
	 * */
	public void move(Point2 pt) { //pt도 Point2로 만들어졌기때문에 Point2가 private이더라도 같은 클래스라서 Point2에 직접 접근할 수 있다
		x = pt.x;
		y = pt.y;
		
	//move라는 메소드가 2개임. => 메소드 오버로딩	
	}
	
}