package Practice;

public class classtest1 {

	public static void main(String[] args) {

		sum(3,2);
		System.out.println(multiple(3,2));
		
		test();

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
}
