package day16;

public class ThrowTest {
//일부러 개발자가 원하는 예외를 만들어서 그 예외를 처리하려는 때에 사용하는게 throw 
	public static void main(String[] args) {
		int num = 1;

		try {
		if (num == 1) {
			RuntimeException e = new RuntimeException("예외");		//표현2: 두줄이 밑에 표현1이랑 같은 뜻
			throw e;
			//throw new RuntimeException ("예외");	//표현1 //객체: new라는 연산자를 통해 만들어 낸 것
			}
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생");
		}catch(Exception e) {
			System.out.println("예외가 발생");
		}

		
		//RuntimeException예외는 실행예외이기 때문에 예외처리를 안해도 에러가 발생하지 않음
		throw new RuntimeException("예외");	
		
		throw new Exception("예외");	
		//Exception은 실행예외가 아니기때문에 예외처리가 필수이다.
		//예외처리를 안한 Exception코드는 에러발생 => (*Exception은 실행예외랑 일반예외를 둘다 포함하고 있음)
	}	
}
