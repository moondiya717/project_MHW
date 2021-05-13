package day13;

public class AutoCar extends Car {
	
	public AutoCar(String type, String company) {
		super(type, company);
		super.setGear('P');			//기본기어값을 P로 둠
	}
	@Override
	public void setGear(char gear) {
		switch(gear) {
		case 'D', 'N', 'P', 'R':
			super.setGear(gear);
			break;
		default:
			super.setGear('P');
		}
	}
}
