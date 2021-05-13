package day13;

public class StickCar extends Car {	//처음에 StickCar에 오류가남 => 1.부모클래스에 생성자 만들기 2. 여기에 생성자만들기 둘중 하나해야돼
	
	public StickCar(String type, String company) {
		super(type, company);
		super.setGear('1');
	}
	
	@Override
	public void setGear(char gear) {
		//수동은 1,2,3,4,5단과 후진 r만 가능하기때문에
		//기어값이 D가 올 수 없다. 기어값이 D, N등 다른 값이오면 1단으로 설정
		switch(gear) {
		case '1', '2', '3', '4', '5', 'r':
			super.setGear(gear);
			//this.gear(gear); 부모클래스가 public이었으면 할 수 있었겠지만 private라서 set값으로 이용해야함
			break;
		default:
			super.setGear('1');	//다른값이들어오면 기어를 1단으로 기본값을 준다
		}
	}
}
