package Practice;

import java.util.Scanner;

public class StringTest7 {

	public static void main(String[] args) {
		/* 취미를 한 줄로 입력받아 각 취미를 출력하는 코드를 .split() 을 이용하여 작성하세요.
		 * 예시)
		 * 취미를 입력하세요(예: 영화보기,음악감상,독서)): 영화보기,음악감상
		 * 취미리스트
		 * 1. 영화보기
		 * 2. 음악감상*/

		Scanner scan = new Scanner (System.in);
		System.out.print("취미를 한 줄로 입력하세요(예: 독서,음악감상,영화시청): ");
		String h=scan.next();
		String hList[]=h.split(",");
		
		if(hList!=null) {
			for(int i=0; i<hList.length; i++) {
				System.out.println((i+1)+". "+ hList[i]);
			}
		}
		scan.close();
	}
}
