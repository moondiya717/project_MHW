package day15;

public class NumberFormatExceptionTest {

	public static void main(String[] args) {
		//문자열에 숫자가 아닌 a라는 문자가 있어 예외발생
		String numStr = "1234a";
		//parseInt(문자열) : 문자열이 주어지면 정수를 반환하는 메소드
		int num = Integer.parseInt(numStr);	//나중에배울건데 Integer라는 클래스가 있음 //parseInt 문자열을 정수로 바꿔줌
		System.out.println(num);

	}

}
