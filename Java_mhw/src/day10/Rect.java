package day10;

public class Rect {
	//너비 : width, 정수  & 높이 : height, 정수
	private int width, height;

	//왼쪽 위의 점 : leftUp (int로 표시하고싶으면 따로따로 만들어야 돼. int left, up => 관리 편하지 않음)
	private Point leftUp;
	
	//오른쪽 아래의 점 : rightDown
	private Point rightDown;
	
	/* 기능    : 사각형의 정보를 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 void
	 * 메소드명 : print 
	 *  */
	
	public void print () {
		System.out.print("왼쪽 위 점: ");
		leftUp.print();
		System.out.print("오른쪽 위 점: ");
		rightDown.print();
		System.out.println("너비: "+ width );
		System.out.println("높이: " + height);

	}
	/* 기능    : 주어진 좌표로 왼쪽위의 점을 이동시키는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : move
	 *  */
	
	
	/* 기본 생성자 : 왼쪽위의 점을 나타내는 객체를 생성하고, 오른쪽 위의 점을 나타내는 객체를 생성 */
	public Rect() {
		leftUp = new Point(); 		//leftUp을 위에 선언만했는데, 선언했을 때 Point라는 클래스에서 좌표를 가지고와서 있는걸 써서 만들었음. 
		rightDown = new Point();	//그래서 위에 선언한 클래스명이랑 new뒤 초기화랑 같아야돼
	}
	/* 생성자		: 좌상점과 우하점이 주어지면 해당 점을 이용한 사각형이 되도록 초기화
	 * 				좌상점, 우하점 초기화, 너비와 높이도 계산해서 초기화 
	 * 매개변수	: 좌상점 우하점
	 * */
	public Rect(int left, int up, int right, int down) { //방법1
		leftUp = new Point(left, up);		//새로만들어줘야 함. 기본생성자할 때 만들어줬어도, 생성자가 두개면 하나만쓰기때문s에 이때 객체생성이 또 안된걸로 쳐질 수 있으니까 다시 생성하기.
		rightDown = new Point (right, down);
		width = right - left;	//좌표평면 기준으로 식 만들기
		height = up - down;
	}
	
	public Rect(Point lu, Point rd) {
		leftUp = lu;	//완성된 코드는 아님 => 내일 할 예정 5/11 
		rightDown = rd;
		width = rightDown.getX()-leftUp.getX();		//ctrl +shift 자동완성있어서 편하게 입력 가능
		height = leftUp.getY()-rightDown.getY();
	}
	

	
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getLeftUp() {
		return leftUp;
	}

	public void setLeftUp(Point leftUp) {
		this.leftUp = leftUp;
	}

	public Point getRightDown() {
		return rightDown;
	}

	public void setRightDown(Point rightDown) {
		this.rightDown = rightDown;
	}	

	

}
