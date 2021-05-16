package day13;

public class CarTest {

	public static void main(String[] args) {
		AutoCar ac = new AutoCar("1종", "기아");
		StickCar sc = new StickCar("2종", "현대");
		
		ac.turnOn();
		ac.setGear('D');
		
		sc.setGear('2');
		
		ac.print();
		System.out.println("--------------------");
		sc.print();
		
		System.out.println("--------------------");
		Car c = ac;
		c.print();	// p.333 클래스간 자동타입변환이 일어남

		System.out.println("--------------------");
		//Car c2 = new Car("1종", "기아");	//안되는 경우, 에러는 안나는데 실행이 안됨	(객체이름이 되는경우랑 같아서 둘중 하나는 숨김처리해야됨)
		//안되는 이유가 Car라는 애를 new로만들었는데 그 공간이 autoCar보다 좁아서 오류가 남
		
		Car c2 = new AutoCar("1종", "기아");//되는경우, 자동으로 안되서 명시적으로 타입변환을해야함
	
		ac = (AutoCar)c2;	
		ac.print();
			
			//차를 관리하는데 수동은 수동끼리 자동은 자동끼리 관리
			AutoCar [] acList = new AutoCar[5]; //예를들어 5개
			StickCar [] scList = new StickCar[5];
			acList[0]=ac;
			scList[0]=sc;
			
			
			//차를 관리하는데 수동과 자동 상관없이 같이 관리  //자식클래스 객체를 부모클래스 객체로 변환하는게 가능하니까
			Car [] cList = new Car[5];	//형변환 
			cList[0] = ac;	
			cList[1] = sc;
			
			//부모클래스의 객체가 자식클래스의 생성자를 통해 만들어진 경우는 자식클래스의 내용이 커도 수용이 가능
	}

}
