package Practice;

import java.util.Scanner;

public class test8_3 {

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

		int i,sum=0;
		boolean pass=true; //참&거짓 결과
		int scoreArr[] = new int [4];
		Scanner scan = new Scanner(System.in);
		
		for(i=0; i<scoreArr.length; i+=1) {
			System.out.print("성적을 입력하세요: ");
			scoreArr[i] = scan.nextInt();
		}
		scan.close();
		
		for(int tmp:scoreArr) {
			sum=sum+tmp;
		}
		
		double avg = (double) sum / scoreArr.length;
		if(avg<60) {
			pass=false;
		}
		
		for(int tmp : scoreArr) {
			if(tmp<40) {
				pass=false;
			}
		}
		
		if(pass) {
			System.out.print("합격입니다.");
		}else {
			System.out.print("불합격입니다.");
		}

	}

}
