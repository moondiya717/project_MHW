package Practice;

public class StringTest6 {

	public static void main(String[] args) {
		//.toUpperCase() 를 사용하여 "abcdefghijklmnop" 를 모두 대문자로 바꿔 출력하는 코드
		System.out.println("abcdefghijklmnop".toUpperCase());
		
		//.toLowerCase() 를 이용하여 "QRSTUVWXYZ"를 소문자로 바꿔 출력하는 코드
		System.out.println("QRSTUVWXYZ".toLowerCase());
		
		
		//.trim() 을 이용하여 "\n\n\n\n\n 123 4567 \n910"에서 공백을 제거하여 출력하는 코드
		String str = "\n\n\n\n\n       123 4567 \n";
		System.out.println(str);		
		System.out.println(str.trim()); //문자열전후의 공백은 사라졌으나 123과 4567사이의 공백은 존재함**

		
		//String.valueOf() 는()괄호 안을 문자열로 만들어줌
		String num1 = "22";
		int num2 = 20;
		System.out.println(num1 + num2);	//문자열"22"+정수이기 때문에 값이 2220으로 문자열이 나옴
		String num3=String.valueOf(num2);	//num3는 num2의 기본타입 정수값을 문자열로 저장한 값으로 문자열20임
		System.out.println(num3 + num2);	//num3이 문자열이기때문에 2020으로 문자열이 나옴
		System.out.println(num2*2);			//num2*2=40으로 num2가 기본정수임=>num1, num3은 문자열이라 계산이안됐음
	
	}

}
