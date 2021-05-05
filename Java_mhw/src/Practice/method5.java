package Practice;

public class method5 {

	public static void main(String[] args) {
		/*		*****
 				*********
				-----			을 출력하도록 메소드를 생성하여 테스트해보세요.*/
		printChar1('*',5);
		printChar1('*',9);
		printChar1('-',5);
		
	}
	/* 기능 : 주어진 문자(ch)를 주어진 정수번(count) 반복하여 출력하는 메소드
	 * 매개변수 : char ch, int count 
	 * 리턴타입 : void
	 * 메소드명: printChar1
	 * */
	
	public static void printChar1(char ch, int count) {
		for(int i=1; i<=count; i+=1) {
			System.out.print(ch);
		}System.out.println();
	}
	
	
}
