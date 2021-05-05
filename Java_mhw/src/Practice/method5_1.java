package Practice;

public class method5_1 {

	public static void main(String[] args) {


	printChar2('*',5);
	System.out.println(printChar2('*',5));
	System.out.println(printChar2('*',3)+printChar2('&',2));
		
	}
	/*기능: 주어진 문자(ch)를 주어진 정수번(count) 반복하여 하나의 문자열로 알려주는 메소드
	 *매개변수: 문자, 횟수 => char ch, int count 
	 *리턴타입: 문자열 => String
	 *메소드명: printChar2
	 * */
	
	public static String printChar2(char ch, int count) {
		String str = "";
		for(int i=0; i<=count-1; i+=1) {	//0부터 시작이라 count-1
			str=str+ch;
		}
		return str;
	}
}