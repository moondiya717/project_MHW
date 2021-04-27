package day2;

public class IncreaseDecreaseOperator {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		System.out.println("++num1 = " + ++num1 + ", num2++ = " + num2++);
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		//실행시키면 두번째 줄에 ++num1하고 num2++은 수가 차이가 나지만, 동작 후 수는 같은 상태임(출력된 값 말고)
		
		
		//위의 변수들을 실행한 값 이후에 아래의 수의 변화보기
		//이 때 num1을 출력하면 얼마가 나올까요?
		//11의 상태에서
		num1++; // 는 12
		++num1; // 는 13
		
		num1 = 10;
		num2 = 10;
		System.out.println(" num1 = " + num1 + ", num2 = " + num2);
		num1++; //++num1; 와 상황이 같다.
		System.out.println("++num1 = " + num1 + ", num2++ " + num2);
		++num2; //num2++; 와 상황이 같다.
		System.out.println(" num1 = " + num1 + ", num2 = " + num2);
		
		
	}

}
