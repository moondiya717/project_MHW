package Practice;

public class Classtest1 {

		static String color = "purple";
	
	public static void main(String[] args) {

		sum(3,2);
		System.out.println(multiple(3,2));
		
		test();
		
		
		print();
		

		
		
	}

	public static void sum(int num1, int num2) {
		System.out.println(num1+num2);
	}
	
	public static int multiple (int num1, int num2) {
		int res = num1*num2;
		return res;
	}
	public static void text(String str1) {
		System.out.println(str1);
		 
	}
	public static void test() {
		text("얼마예요?");
		sum(2000,300);
	}
	
	public static void print() {
		Classtest1.color = "purple";
		String newColor; //값을 옮겨받을 애는 값타입이 변수타입이랑 같으면 상관없나봄
		newColor = Classtest1.color;
		System.out.println(newColor);
		
	}
}
