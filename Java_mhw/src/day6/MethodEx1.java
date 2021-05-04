package day6;

public class MethodEx1 {

	public static void main(String[] args) {
		//메소드 예제 //(클래스 안에 만들기=> 메인 밑에다가 만들어야 함.)
		//메소드명(값); ->매개변수마다 다르기때문에 "값"이라고 표현했고, 갯수가 꼭 하나는 아님.	
		
		add(1,2);	//3이랑 같다고..? , 실행은 되지만 동작은 없음. 따라서 큰의미는 없는 
		System.out.println(add(1,2));
		
		add2(1,2);
		printMultiTable(7);//구구단 7단을 출력하기위해서
		
		int num1=8, num2=12;
		int res = gcd(num1, num2);
		System.out.println(num1 + "와"+ num2+ "의 최대공약수: "+ res);
	}
	/* 기능	 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수: 두 정수 => int num1, int num2 
	 * 리턴타입: 정수의 합 => 정수 => int
	 * 메소드명: add
	 * */
	//public static 리턴타입 메소드명(매개변수) {
		
	//}
	
	public static int add(int num1, int num2) {		//함수 선언을 했음
		int res = num1+num2;
		return res; 	//결과값을 return을 통해서 알려줌
	}
	/* 기능	 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수: 두 정수 => int num1, int num2 
	 * 리턴타입: 없음 = void
	 * 메소드명: add2
	 * */
	public static void add2(int num1, int num2) {		//여기는 리턴이 없어서 void쓰는거임
		int res = num1+num2;
		System.out.println(num1 + " + " + num2 + " = " + res);	
	}
	/* 기능: 두 정수와 산술 연산자가 주어지면 두 정수의 산술 연산 결과를 알려주는 메소드
	 * 매개변수: 두 정수와 산술 연산자 => int num1, char op, int num2
	 * 리턴타입: 산술 연산 결과=> 실수=> double
	 * 메소드명: calculate
	 * 
	 * */
	public static double calculate(int num1, char op, int num2) {
		return 0.0;
		
	}
	/* 기능 : 두 정수의 최대 공약수를 알려주는 메소드 => 출력이있으면 안돼
	 * 매개변수 : 두 정수 => int num1, num2
	 * 리턴타입 : 최대공약수 => 정수 => int 
	 * 메소드명 : gcd
	 * */
	public static int gcd(int num1, int num2) { //이건 메소드 gcd
		int i=1, gcd=0;							//이건 변수 메소드 gcd , 서로다른거지만 이름은 같을 수 있음
		for(i=1; i<=num1; i+=1) {
			if(num1%i==0 && num2%i==0){
				gcd=i;
			}
		}
		return gcd; //빨간색 줄가는거 없애려고 했다는데
	}
	/* 기능: num단을 출력하는 메소드
	 * 매개변수 : 정수 num (몇단을 쫙 불러오기) => int num 
	 * 리턴타입 : 없음 => void		//출력하는건 리턴할 필요가 없어.
	 * 메소드명 :printMultiTable 
	 * */
	public static void printMultiTable(int num) {
		//return ;	//return 0;는 안되지만 return;이나 생략. 둘 중 하나면 됨. void여도 괜찮아.
		int i;			//num는 초기화하면 안돼, 외부에서 숫자 수정하면 쫙 나올 수 있도록. 내부에서는 초기화시키지 말 것
		//System.out.print(num+"단"); ->메소드 장점: 코드 수정이 쉬워짐
		for(i=1; i<=9 ; i+=1) {
			System.out.println(num + " x " + i + " = " + (num*i));
		}

		
	}
	
}



