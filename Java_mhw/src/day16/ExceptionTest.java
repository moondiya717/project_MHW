package day16;

public class ExceptionTest {

	public static void main(String[] args) {
		//예외 클래스 Exception 살펴보는 예제
		try {
			throw new Exception("예외");
		}
		//예외가 발생하면 Exception 클래스를 이용하여 객체 e를 선언하고 
		//발생한 예외객체를 e에 저장
		catch(Exception e) {	//Exception e는 선언된 여기서만 사용가능 catch 닫기 괄호까지
			//getMessage() : 생성자에서 넣어준 문자열을 가져옴
			System.out.println(e.getMessage());
			
			//printStackTrace() : 예외가 발생한 위치를 출력해주는 메소드 => 출력하면 빨갛게 나오는데 에러가 아님
			e.printStackTrace();
		}
		System.out.println("종료");
		
	}

}
