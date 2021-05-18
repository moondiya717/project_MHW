package day16;

public class TryTest1 {
//예외처리: 예외발생을 막을 순 없지만, 프로그램이 정상적으로 종료될 수 있도록 할 수 있음
	public static void main(String[] args) {
		int num1 =1, num2=0;
		/*예외 발생 시, catch에서 해당 예외 클래스와 조상 클래스가 있으면 예외를 처리한다
		 * 나누기는 ArithmeticException이 발생할 수 있는 코드이다.
		 * 혼공자445p)자식 ArithmeticException > RuntimeException > Exception 조상
		 * */
		
		try {
			System.out.println(num1 / num2);
		}catch(Exception e) {							//Exception은 ArithmeticException의 조상이므로 처리할 수 있다.
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외처리 1번 종료");
		
		
		try {
			System.out.println(num1 / num2);
		}catch(ArithmeticException e) {					//ArithmeticException은 예외의 당사자(본인)이기때문에 예외처리가능		
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외처리 2번 종료");
		
		
		try {
			System.out.println(num1 / num2);
		}catch(RuntimeException e) {					//RuntimeException은 ArithmeticException의 부모(조상)이기 때문에 예외 처리 가능		
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외처리 3번 종료");
		
		
		try {
			System.out.println(num1 / num2);
		}catch(ClassCastException e) {		//ClassCastException e => 는 나누기연산자로 일어나는 예외가 아니고, 조상이 아니기때문에 예외처리 불가능으로 프로그램이 정상적으로 종료가 안되고 중단됨
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외처리 4번 종료");
		
		
		System.out.println("프로그램 종료");				
	
		//꿀팁: 커서있는라인에 Alt누르고 화살표움직이면 그 라인이 막 위아래로 움직임 통째로
		//finally안씀? => 필수는 아님. try catch는 필수임
		//catch로 예외처리 잡을 수 있는건, 본인이나 조상예외들임
	}
}
