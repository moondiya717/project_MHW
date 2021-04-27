package day2;

public class LogicalOperator {

	public static void main(String[] args) {
		// 논리 연산자 예제
		//!연산자 ("not연산자" 라고 읽음)
		System.out.println("4는 짝수인가? " + (4%2==0));
		System.out.println("4는 홀수가 아닌가? " + !(4%2==1));  
		//앞에 !는 false->true로 되도록not연산자 이용하고, 괄호안에 ==1(홀수) false가 나오도록
		
		
		//변수 num가 2의 배수이고 3의 배수이면 6의 배수이다.
		//num가 2의 배수 => num % 2 == 0
		//num가 3의 배수 => num % 3 == 0
		int num = 18;
		System.out.println(num+ "는 6의 배수인가? " + (num % 2 == 0 && num % 3 == 0));
	
		
		/* 청소년은 14세부터 19세까지이다.
		 * 청소년이 아닌 사람은 14세 미만이거나 19세 초과         (거나 =or / 이고 = and)
		 * 나이가 age인 학생은 청소년이 아닌지 확인하는 예제 */
		int age = 20;
		System.out.println(age + "살은 청소년이 아닌가? " + (age < 14 || age > 19));
		
		
		//xor (^) 연산자 예제 : 배타논리, 같으면 거짓, 다르면 참
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		// =는 왼쪽의 이름으로 오른쪽 값을 저장, == 은 왼쪽과 오른쪽이 같음을 의미 
		
		
		
		
		
		
	}

}
