package day2;

public class ConditionalOperator {

	public static void main(String[] args) {
		//조건선택연산자 예제 => (조건식)? A:B
		//조건식 : 결과가 참 또는 거짓으로 나오는 식, 비교연산자나 논리연산자가 들어간 식
		
		int num = 5;
		String result = (num % 2 == 0) ? "짝수" : "홀수"; //참이면 "짝수"글자를 result에 저장, 거짓이면 "홀수"를 저장
		System.out.println(num + "는 " + result);
		
		
		
	}
}