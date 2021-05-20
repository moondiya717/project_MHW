package day17;

public class WrapperTest {

	public static void main(String[] args) {
		Integer num1 = 1;
		int num2 = 2;
		System.out.println(num1 + num2);
		num1 = null;
		System.out.println(num1);
		//num2 = null;	//에러발생: 기본타입은 null을 저장할 수 없음
		num1 = new Integer(1);	//클래스니깐 생성자를 통해서 객체를 생성할 수 있지만 원래 저장 가능해서 이렇게 쓰진 않음 (자바9버전 이후로 더이상 사용되지않음)
		System.out.println(num1);
	
		//기본타입을 객체로 만드는 것을 박싱
		num1=1;	//타입을 바꾸는 것
		
		//객체를 기본타입으로 만드는 것을 언박싱
		num2=num1;
		System.out.println(num2);
		
		//문자열을 기본타입으로 변환
		//래퍼클래스.parse래퍼클래스(문자열);
		String str = "1234";
		num2=Integer.parseInt(str); //NumberForamtException이 발생할 수 있음
		System.out.println(num2);
		
	}

}
