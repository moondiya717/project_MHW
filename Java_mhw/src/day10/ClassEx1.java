package day10;

public class ClassEx1 {

	public static void main(String[] args) {
		A a = new A();
		a.num=10;	//public이라서 에러가 발생하지 않음
		B b = new B();
		b.num=10;	//protected : Class B와 ClassEx1은 같은 패키지에 있기때문에 에러 발생하지 않음
		C c = new C();
		c.num=10;	//(default) : Class C와 ClassEx1은 같은 패키지에 있기때문에 에러 발생하지 않음
		D d = new D();
		//d.num=10;	//값을 10으로 바꾸려고헀는데 에러발생 : num의 접근 제한자가 private여서 
		d.setNum(10);	//에러안남. private안에 있는 num값을 같은 클래스내의 public인 데로 옮겨서 갖고옴
		System.out.println(d.getNum());
	}

}
