package Practice;

public class StringTest8 {

	public static void main(String[] args) {
		/* compareTo(문자열) 예제
		 * 생김새 : 문자열A.compareTo(문자열B)
		 * -1 : 문자열 A가 사전순으로 앞
		 *  0 : 문자열 A,B가 같음
		 *  1 : 문자열 A가 사전순으로 뒤*/
		//기능은 equals랑 비슷한데, 얘는 추가로 비교하는 문자열의 순서를 알 수 있음.

		System.out.println("abcde".compareTo("abcde")); //값: 0 => 단어가 완벽일치
		System.out.println("abcde".compareTo("f"));	//값:  => -5???
		
		
		/* contains(문자열) 예제 => 값이 boolean타입 true,false 로 나옴 (indexOf(문자열)와 기능이 비슷)
		 * 문자열 A와 B가 같으면 true, 다르면 false 출력하는 코드*/
		String A="apple";
		String B="ppl";
		System.out.println(A.contains(B));	//true
		
		
	}

}
