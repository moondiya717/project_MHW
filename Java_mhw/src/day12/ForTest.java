package day12;

public class ForTest {	//307p클래스까지 나간 진도임.

	public static void main(String[] args) {
		// 조건문과 반복문의 실행문이 1줄이면 생략 가능
		for(int i=1; i<=5; i+=1) //{	반복문의 중괄호하나를 지웠음에도 실행 잘 됨.
			System.out.print(i+ " ");
		//}	//중괄호지우기위해 주석처리
		
		
		
		
		int num=2;
		if (num%2==0) //{
			System.out.println("짝수");		//if문에 실행문이 한 줄이라서 중괄호 주석처리했는데도 실행 잘됨.
		/*}*/else //{
			System.out.println("홀수");		//else에 실행문이 한 줄이라서 중괄호 주석처리했는데도 실행 잘됨.
		/*}*/
		
		
		
		
		
	}

}
