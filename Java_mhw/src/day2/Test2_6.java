package day2;
import java.util.Scanner;

public class Test2_6 {

	public static void main(String[] args) {
		/* 성적을 입력 받아 입력받은 성적을 출력하는 코드를 작성하세요.
		 * A : 90이상 100이하
		 * B : 80이상 90미만
		 * C : 70이상 80미만
		 * D : 60이상 70미만
		 * F : 0 이상 60미만 
		 * 잘못된 성적 : 0미만, 100초과*/

		System.out.print("성적을 입력하세요 : ");

		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();                 //선생님은 int score = 점수(수동기입 후 콘솔입력이 아니라 창에서 변수값 바꿔가면서 test)
	
		if(score >= 90 && score <=100) {
			System.out.println("성적: A");
			
		} else if(score >= 80 && score <90) {
			System.out.println("성적: B");
			
		} else if(score >= 70 && score <80) {
			System.out.println("성적: C");
			
		} else if(score >= 60 && score <70) {
			System.out.println("성적: D");
			
		} else if(score > 0 && score <60) {
			System.out.println("성적 : F");
			
		} else {
			System.out.println("잘못된 성적입니다.");
		}
		
		
	}

}
