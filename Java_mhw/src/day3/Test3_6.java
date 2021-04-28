package day3;

public class Test3_6 {

	public static void main(String[] args) {
		/* 1부터 10까지의 짝수들의 합을 구하는 예제
		 * */

		int i, sum=0;
		for (i=2;i<=10;i=i+2) { //i+=2라고 써도 됨.
			sum+=i;  //sum = sum +i; 이랑 같은거고 아무거나 써도 됨.
		} // 출력을 한번만 할 것이기 때문에 괄호 닫고나서 sysout을 밑에다가 씀.
			System.out.println("1부터 10까지의 짝수들의 합: " + sum);
		
		
			
			
			
		
	}

}
