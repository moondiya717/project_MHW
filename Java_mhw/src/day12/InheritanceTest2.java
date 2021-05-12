package day12;

public class InheritanceTest2 {
	public static void main(String[]args) {
		SmartPhone sp = new SmartPhone("010-1234-5678", "퍼시픽블루", "아이폰12pro");
		sp.print();
	}
}
//폰 클래스
class Phone{
	private String num;			//같은 패키지에서 사용할 수 있도록 private말고 default로 하겠음
	private String color;
	private String model;
	public Phone(String num, String color, String model) {	//생성자를 만들엉씀
		System.out.println("폰 생성자입니다.");
		this.num = num;
		this.color = color;
		this.model = model;
	}
	public Phone() {
		System.out.println("폰 기본 생성자입니다.");
	}
	public void print() {
		System.out.println("번호 : " + num);
		System.out.println("색상 : " + color);
		System.out.println("모델 : " + model);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
//스마트 폰 클래스
class SmartPhone extends Phone{
	int camera; 	//카메라 화소(단위 만)
	public SmartPhone(String num, String color, String model) {
		//부모 클래스의 생성자가 없으면 super();가 생략되어 있음
		super(num, color, model);	//부모클래스 생성자 얘를 호출하고 밑에 this.set 3개를 모두 지웠음. 그럼num, color, model은 부모클래스서 바꾸는거임
		//this();	//에러발생: 부모클래스의 생성자를 2번 호출하는 경우이기 때문 => SmartPhone(){}기본생성자에 super();가 생략되어있어서 결국 2번 초기화하라는 뜻이라서
							//super를 쓰던지, this를 쓰던지 그래서 둘 중 하나를 써야 함.
		System.out.println("스마트폰 생성자입니다.");
		//this.setColor(color);		//getter satter 쓴거임, Phone에서 private로 멤버변수 선언해서 =>주석처리(super쓰려고 일단 지워놨음)
		//this.setModel(model);;
		//this.setNum(num);;
	}
	public SmartPhone() {}	//기본생성자 
		//super(); 가 생략되어있는것
}