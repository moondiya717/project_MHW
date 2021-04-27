package day2;

import java.util.Scanner;

public class Test2_3 {

	public static void main(String[] args) {
		/* 국어 성적을 입력 받고 국어 과목을 패스 했는지 안했는지 확인하는 코드를 작성하세요.
		 * 국어 성적이 60점 미만이면 Fail, 국어 성적이 60점 이상이면 Pass*/

		/* double kor;
		System.out.print("국어 성적을 입력하세요 : ");
		
		Scanner scan = new Scanner (System.in); //System.in은 콘솔을 통해서 입력받는 걸 의미
		kor = scan.nextDouble();
		System.out.println("국어 성적 : " + kor + "점");
		
		String result = (kor <60.0) ? "Fail" : "Pass";
		System.out.println("국어 시험 성적 통과여부 : " + result); */
		
		Scanner scan = new Scanner(System.in);

		System.out.print("국어 성적을 입력하세요 : ");
		int kor = scan.nextInt();
		System.out.println("국어 과목을 패스했습니까? " + (kor >=60));
		
		String result = kor >=60 ? "Pass" : "Fail";
		System.out.println("국어 과목을 패스했습니까? " + result);
		
		
		
		/*국어 성적이 A학점인지 아닌지를 판별하는 코드를 작성하세요.
		 * A학점은 90점이상 100점이하
		 * 90 <= 성적 <= 100 (X) 앞에 90<=성적 을 계산하면 참 true 이후에 true <=100으로 계산하기때문에 오류가 남.
		 * 90<= 성적 && 성적 <= 100 (O)
		 * */
		
		boolean result2 = 90 <= kor && kor <= 100;
		System.out.println("국어 학점은 A학점인가? " + result2);
		
		
		
		/*조건선택연산자를 통해 국어 성적의 학점을 출력하는 코드를 작성하세요. */
		String result3 = (90 <= kor && kor <= 100) ? "A" :
			             (80 <= kor && kor < 90 ? "B" :
			             (70 <= kor && kor < 80 ? "C" :
				         (60 <= kor && kor < 70 ? "D" :"F"))); //괄호 여부는 상관이 없음
		System.out.println("국어 성적 : " + result3);
		
				            		 
			            		 
			            		 
		scan.close();
		
		
		
	}

}
