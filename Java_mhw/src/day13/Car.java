package day13;

public class Car {
	//전원, 기어, 차종, 제조사 => 멤버변수로, 단 접근제한자는 private
	
	//전원 on/off
	private boolean power; //기본값 false
	
	//수동: 1,2,3,4,5,R	//자동:P, D, N, R => 기어는 string이나 char 암거나 가능
	private char gear;
	
	private String type;
	private String company;
	
	public void turnOn() {power = true;}
	public void turnOff() {power = false;}
	
	public Car(String type, String company) {	//기어랑 시동은 보통 차가 만들어지면 기본값으로 되어있으니까 따로 알려줄 필요가 없어서 매개변수로 안씀
		this.type = type;
		this.company = company;
	}
	
	public boolean isPower() {
		return power;
	}
	public void print() {
		System.out.println("제조: " + company);
		System.out.println("차종: " + type);
		System.out.println("전원: " + power);
		System.out.println("기어: " + gear);
	}
	//public void setPower(boolean power) {		//외부에서 전원을 맘대로 켜고끄고할 수 없도록 지우기, 시동은 항상 내부에서만 끄고 켤 수 있도록 숨김 
	//	this.power = power;
	//}
	public char getGear() {
		return gear;
	}
	public void setGear(char gear) {
		this.gear = gear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	//public void setCompany(String company) {		//만들어질때 결정되면 회사가 중간에 바뀔일이 없으니까 삭제함
	//	this.company = company;
	//}
	
	
}
