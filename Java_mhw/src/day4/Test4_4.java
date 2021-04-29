package day4;

import java.util.Scanner;

public class Test4_4 {

	public static void main(String[] args) {
		/**/
	//Math.random() 은 0보다 크거나 같고 1보다 작은 임의의 실수를 생성하는 기능
	/*Math.random(): A
	 * 0 <= A < 1 
	 * 0 **/
	
	
	
	/*정수를 랜덤으로 생성하여 생성된 숫자를 맞추는 게임
	 * 예시(랜덤하게 생성된 숫자가 25인 경우)
	 * 정수가 랜덤으로 생성되었습니다. 게임시작!
	 * 정수를 입력하세요: 100
	 * down
	 * 정수를 입력하세요: 40
	 * down
	 * 정수를 입력하세요: 10
	 * up
	 * 정수를 입력하세요: 20
	 * up
	 * 정수를 입력하세요: 25
	 * 정답입니다. 
	 * 
	 * 반복횟수 : X (모르면, 안쓰면 됨)
	 * 규칙성 :  "정수를 입력하세요: " 라는 문자열을 출력
	 * 			콘솔에서 정수를 입력받기
	 * 			입력받은 정수가 랜덤한 수보다 크면 down이라고 출력하고, 
	 * 			입력받은 정수가 랜덤한 수보다 크면 작으면 up이라고 출력하고, 
	 * 			입력받은 정수가 랜덤한 수보다 크면 같으면 "정답입니다"라고 출력 후 반복문 종료.
	 * 반복문 종료 후: 없음
	 * */
		
	
		int min=1, max=100;
		int r=(int)(Math.random()*(max-min+1)+min);
	
		Scanner scan = new Scanner(System.in); //scanner는 반복문 안으로 만들면 반복으로 오류가 발생함
	
	for( ; ; ) {
		System.out.print("정수를 입력하세요 (" + min + "~" + max + "): ");
			
			System.out.println(r); //랜덤으로 숫자가 나오니까 답을 확인하기 어려우니 답을 보게하고나서 테스트하면 편함
			int num=scan.nextInt();
		
			if(num>r) {
				System.out.println("down");
			} else if(num<r) {
				System.out.println("up");
			} else {
				System.out.println("정답입니다.");
				break;
			} 

			
	}
	scan.close(); //num를 계속해서 사용해야하기때문에 반복문 밖으로 빼놓기

		
		
	
	
	

	
	}

}
