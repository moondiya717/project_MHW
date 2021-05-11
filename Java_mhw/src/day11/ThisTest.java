package day11;

public class ThisTest {

	public static void main(String[] args) {
		TestA t = new TestA(5);	//num에 5가 들어가길 바래서 5 넣음 => 근데 안들어감ㅋ
		t.print(); 
		
	}
}

class TestA{
	private int num;	//멤버변수 num
	//test할거라 번거로워서 get, set안만들고 생략하고 밑에 할라는것만 하께여
	
	public TestA(int num) {	//매개변수 num
		//멤버 변수 num에 매개변수 num의 값을 저장
		//메소드에서 우선순위는 멤버변수보다 매개변수가 높다.
		//num = num;
		this.num = num; //멤버변수 이름이랑 매개변수랑 이름이 다르면 안써도 돼 
		
	}
	public void print() {
		System.out.println("num : " + num );
	}
}