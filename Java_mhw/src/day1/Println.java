package day1;

public class Println {

	public static void main(String[] args) {
		/* System.out.println() : ()안에 있는 내용을 콘솔에 출력하는 메소드(기능)
		 * 						   내용을 출력 후 엔터를 침
		 * 						   print뒤에 ln은 콘솔에 출력되는 글자에 엔터쳐주는거임
		 * System.out.println(문자열)
		 * System.out.println(정수)
		 * System.out.println(실수)
		 * System.out.println(문자)
		 * 		 */
		System.out.println("Hello");
		System.out.println(1);
		System.out.println(3.14);
		System.out.println(true);
		System.out.println('A');
		
		// ""는 문자열
		System.out.println(1+2+3);
		
		//문자열 "1" + 정수2 => 문자열12 가 되고 그 이후에, 문자열 12+ 정수3 => 문자열 123
		System.out.println("1"+2+3);
		
		//우선순위 괄호 안의 수 2와 3을 더하고, 문자열 1을 더함. => 문자열1 + 괄호안의정수 5 => 15
		System.out.println("1"+(2+3));
		
		//정수 1+2 =>3 하고 문자열 3을 더해서 => 33이 출력
		System.out.println(1+2+"3");
	}

}
