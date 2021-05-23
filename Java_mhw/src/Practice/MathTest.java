package Practice;

public class MathTest {

	public static void main(String[] args) {
		// Math.abs() : 절대값구하는 코드
				System.out.println(Math.abs(-1));		//정수, 실수로 매개변수가 다름
				System.out.println(Math.abs(-1.23));	//오버로딩: 동일한 클래스의 메소드가 여러개있는 것
				
				// Math.ceil() : 소수점 올림하는 코드
				System.out.println(Math.ceil(1.1));		//0.1을 올려서 2가 나옴

				// Math.floor() : 내림하는 코드
				System.out.println(Math.floor(1.9));	// 0.9를 버려서 1이 나옴

				// Math.rint() : 가까운 정수값의 실수
				System.out.println(Math.rint(1.2));	 	//가까운 정수값의 "실수"인 1.0이 나옴
				
				// Math.round() : 반올림한 정수값
				System.out.println(Math.round(1.2));	// rint와 round가 거의 비슷한 메소드지만 값이 실수로 나오는지 정수로 나오는지가 다름
				
				// Math.max() : 최대값
				System.out.println(Math.max(1.23, 1.24));
			
				// Math.min() : 최소값
				System.out.println(Math.min(1.23, 1.24));
				
				// Math.randon() : 0보다 크거나 같고 1보다 작은 임의 실수값을 생성하는 메소드
				System.out.println(Math.random()); 		//실행할때마다 값이 달라지는 랜덤메소드가 나옴
				
				// Math.pow(a,b) : a의 b제곱
				System.out.println(Math.pow(2, 3));	 	//2의 3제곱 = 8이 나옴
				
				// Math.sqrt(a) : 루트 a
				System.out.println(Math.sqrt(4));  		//루트4의 값 =2 나옴
				

	}

}
