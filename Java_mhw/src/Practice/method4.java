package Practice;

public class method4 {

	public static void main(String[] args) {
		// 재사용성이 높은 메소드를 보여주기 위한 비교
				//(1. 두 방법으로 최대공약수를 구하는 메소드 이후) / 2.최대공약수를 이용하여 최소 공배수를 구하는 메소드를 작성하세요.
				//두 정수를 A, B라하고 최대 공약수를 G, 최소 공배수를 L이라고 했을때 
				//A=Ga, B=Gb로 표현할 수 있고, L=G*a*b
				//L=A*B/G로 나타낼 수 있다.

		System.out.println(gcd1(8, 16));
		
		gcd2(8,16);
		
		System.out.println(lcm(8,16));
	}

		/*
		 * 기능: 두 정수의 최대공약수를 구하기
		 * 매개타입: 두 정수 => int num1, int num2
		 * 리턴타입: 정수 => int res
		 * 메소드명: gcd1
		 * */

		public static int gcd1(int num1, int num2) {
			int res=1;
			for(int i=1; i<=num1 && i<num2; i+=1) {
				if(num1%i==0 && num2%i==0){
					res=i;
					
				}
			}
			return res;
		}
		/* 기능: 두 정수의 최대 공약수를 출력하는 메소드
		 * 매개변수: 두 정수=> int num1, int num2
		 * 리턴타입: 없음 => void 
		 * 메소드명: gcd2
		 * */
		public static void gcd2(int num1, int num2) {
			int res=1;
			for(int i=1; i<=num1 && i<num2; i+=1) {
				if(num1%i==0 && num2%i==0){
					res=i;
				}
			}System.out.println(res);
		}
		/* 기능: 두 정수의 최소 공배수를 알려주는 메소드 //구하는 법 L=A*B/G
		 * 매개변수: 두 정수=> int num1, int num2
		 * 리턴타입: 최소 공배수 => 정수 => int
		 * 메소드명: lcm ->소문자L
		 * */		
		public static int lcm(int num1, int num2) {
			int res=num1*num2/gcd1(num1, num2);
			return res;
		}
}
