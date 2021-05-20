package Practice;

public class WrapperTest {

	public static void main(String[] args) {

		Integer num1 = 1;	//Wrapper Class 타입 Integer도 숫자 1로 인식
		int num2 = 2;
		System.out.println(num1+num2);	//문제없이 잘 더해진 값 3 나옴

		num1=null;
		System.out.println(num1);	//null이라고 출력됨. Wrapper Class는 참조변수로서 null도 저장가능
		
		num1 = new Integer(1);	//클래스니깐 생성자를 통해서 객체를 생성할 수 있지만 원래 저장 가능해서 이렇게 쓰진 않음 (자바9버전 이후로 안씀)
		System.out.println(num1);	//1이 출력됐음

		//박싱: 기본타입을 객체로 만드는 것
		num1=1;	//타입을 바꾸는 것 (null->1)
		
		//언박싱: 객체를 기본타입으로 만드는 것
		num2=num1;	//num2는 이미 기본타입인데?
		System.out.println(num2); 	//1이 출력됐음
		
		//문자열을 기본타입으로 변환
		//래퍼클래스.parse래퍼클래스(문자열);
		String str = "1234";
		num2=Integer.parseInt(str); //NumberForamtException이 발생할 수 있음(숫자에 알파벳이나 연산자섞이면)
		System.out.println(num2);
		
	}
}
