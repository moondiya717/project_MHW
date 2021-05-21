package day17;

public class StringTest8 {

	public static void main(String[] args) {
		/* compareTo(문자열) 예제
		 * 생김새 : 문자열A.compareTo(문자열B)
		 * -1 : 문자열 A가 사전순으로 앞
		 *  0 : 문자열 A,B가 같음
		 *  1 : 문자열 A가 사전순으로 뒤*/
		//기능은 equals랑 비슷한데, 얘는 추가로 비교하는 문자열의 순서를 알 수 있음.
		System.out.println("A".compareTo("B"));	//-1
		System.out.println("A".compareTo("A"));	//0
		System.out.println("B".compareTo("A")); //1
		
		
		
		/*contains(문자열) 예제 => 값이 true,false 로 나옴
		 * 문자열 A와 B가 서로 포함관계에 있으면 ture, 아니면 false로 나옴*/
		//indexOf(문자열)와 기능이 비슷
		System.out.println("Hello".contains("He"));
		System.out.println("Hello".contains("Hi"));
		
		
		
		
		
	}

}
