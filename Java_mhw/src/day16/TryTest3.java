package day16;

public class TryTest3 {

	public static void main(String[] args) {
		int num1=1, num2=0;
		try {
			System.out.println(num1 / num2);
		}catch(Exception e) {
			System.out.println("예외 발생");
			return; //return;을 넣자마자 메소드가 종료되지만 항상실행되는 finally는 작동하지만 마지막에 "프로그램종료"sysout은 작동안함
		}finally {	//보통 finally는 안써도 상관은 없어(필수아님), 하지만 위에서 return을 통해서 메소드를 종료시켜버리면 finally를 실행하고안하고에 차이가 생김
			System.out.println("finally 실행");	//finally는 메소드가 종료되더라도 실행됨을 기억 ^______^*
		}
		System.out.println("프로그램 종료");

		
	}
}
