package day13;

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child(1,2,3);
		c.print();	//부모클래스의 메소드를 씀(상속받았으니까 가능함)
		c.print2(); //자식클래스에서 만든 메소드를 통해 부모클래스의 멤버변수값을 메소드로 출력
	}

}
class Parent{
	private int num1;	//(default)잘안씀, 같은 패키지내에서만 움직일 수 있기때문에 불편해서 이 셋중에 하나 쓰는게 젤 좋대
	protected int num2;
	public int num3;
	
	public void print() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
	}

	public Parent(int num1, int num2, int num3) {
		//super();			//부모클래스생성자 호출하는 역할, super(); 없으면 나중에 자동으로 생성됨
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public final void menu() {			//final 메소드 확인하려고 친거임
		System.out.println("메뉴입니다.");
	}
	
}
class Child extends Parent{
	public int num4;
	//부모에게 물려받은 메소드를 이용해서 자식클래스에있는 멤버변수의 값을 출력하고 싶을 때? => 메소드재정의(메소드 오버라이드/딩)을 사용한다
	
	//부모클래스 생성자가 없어서 에러가 나니까 해결하기위해 부모클래스의 생성자를 찾을 수 있게하기위해 아래에 부모클래스의 생성자를 호출했음
	public Child (int num1, int num2, int num3) {			//Q:생성자가없으면 기본생성자가 만들어진다며? ..? 
		super(num1, num2, num3);
	}
	public void print2() {
		System.out.println(getNum1());	//private여서 그냥 num1출력으로 할 수 없으니깐 getter setter생성 후, getNum1() 이라고 부모값을 호출해줌
		System.out.println(num2);
		System.out.println(num3);
	}			//317p여기서 잠깐파트														//Q: (default)는되는거?
	@Override	//이렇게 써도 오류가 안남. 이건 부모클래스 메소드를 오버라이딩했다고 걍표시하는 마크임, 알려주는 거라서. 써도되고 안써도 됨. 생략가능 
	//@Override이면서 갑자기 print메소드에 매개변수 넣어버리면 걍 다른 메소드라서 @Override쓸수없엉
	public void print() {	//오버라이딩 시, 꼭 헤드라인이 똑같아야함. => 접근제한자를 좁힐 순 없다. //부모클래스의 메소드가 public이면 private/protected로 수정할 수 없다.
		super.print();	//오버라이딩 부모클래스상속 super. 에다가 print() 메소드 내용에 밑에 하나 추가하겠다
		System.out.println("num4 : " + num4);	//오버라이드로 추가한 내용
	}		//메소드 오버라이딩이랑 부모한테 물려받은거랑해서 메소드가 총 2개 되는거. 따로따로 취급
	
	public void print (int num1) {	//오버로드/오버로딩 (위에랑다름) 이거는 메소드같은이름인데 매개변수 갯수다르거나 타입다르게해서 중복선언하는거자나
		super.print();				//오버로드&오버로딩 != 오버라이딩&오버라이딩  //메소드이름 같다고 헷갈리면 안돼
		System.out.println("num4 :" + num4);
	}
	
//	public void menu() {	//부모클래스에 있는 menu가 final이라서 메소드를 오버라이딩할 수 없어서 에러남 
	
//	}
	
}

//class SubString extends String{		//final 클래스 String을 통해 자식 클래스를 만들 수 없다 (String은 원래 대표적인 final class임)
	
//}


