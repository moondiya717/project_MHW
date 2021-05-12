package day12;

public class InheritanceTest1 {
	public static void main(String[] args) {
		Parent p = new Parent();	//부모클래스의 객체 p를 만들었음
		p.print();
		
		Child c = new Child();	//자식클래스의 객체 c를 만듦
		c.print();				//부모클래스의 내용을 물려받았기때문에 print가능함
	}
}
class Parent{
	public int num;
	private int num2;
	protected int num3;
	int num4;
	public void print() {
		System.out.println("num : " + num);
		
	}
}
class Child extends Parent{
	public void print2() {
		//System.out.println("num2 : " + num2);	//num2는 private로 되어있어서 에러남
		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);

	}
}