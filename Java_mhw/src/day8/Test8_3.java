package day8;

import java.util.Scanner;

public class Test8_3 {

	public static void main(String[] args) {
		/* 4개의 성적을 입력받아 합격인지 불합격인지 판별하는 코드를 작성하세요
		 * 합격 기준
		 * - 모든 성적이 과락이 없어야 함
		 * - 평균 60점 이상
		 * 과락 : 성적이 40점 미만인 경우
		 * 
		 * 예시1) 과락이 있는 경우
		 * 성적 : 40 30 100 100
		 * 불합격입니다.
		 * 
		 * 예2)
		 * 성적: 60 40 100 100
		 * 합격입니다.
		 * 
		 * 예3) 평균이 60미만인 경우
		 * 성적: 40 50 40 60
		 * 불합격입니다.
		 * */

		int score[] = new int[4];
		Scanner scan = new Scanner (System.in);
		System.out.print("성적을 입력하세요: ");  	//성적을 입력하라고 표시 - 성적 입력받기 -
	
		for(int i=0; i<score.length; i+=1) {
			score[i]=scan.nextInt();	//입력받는곳에서 한번에 할 수 있지만 나눠서 해보겠음.
		}
		scan.close();	//더이상 입력안받을거라 여기서 끝내면 됨(맨끝도 괜찮).
				
		//합격 여부 결정
		//평균이 60점이상
		int sum = 0;
		boolean pass = true;  	//false =불합격, true = 합격		
		for( int tmp : score) {	//전체탐색이라 향상된for문 씀, for써도 되긴함.
			sum += tmp;
		}
		double avg = (double)sum / score.length;
		if(avg < 60) {
			pass = false;
		}
		//과락이 있는지 없는지 => 전체 점수를 확인
		for(int tmp : score) {
			if(tmp < 40) {   //과락을 찾는거
				pass = false;  
			}
		}
		if(pass) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
				
		
	}

}
