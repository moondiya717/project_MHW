package Practice;

import java.util.Scanner;

public class StringTest9 {

	public static void main(String[] args) {
		/* 공백을 포함한 긴 문자열을 입력한 후, 단어를 입력받아 해당 단어가 몇 번 나오는지 확인하는 코드를 작성하세요.
		 * 예시)
		 * 문장 입력 : Hello. Hi. HHHH. He. His
		 * 단어 입력 : H
		 * 횟수 : 8번 */
		
		Scanner scan = new Scanner (System.in);
		int index=0; //찾고자하는 단어가 들어가있는 시작번지
		int count=0; //중복횟수 체크
		
		System.out.print("공백을 포함한 문자열을 입력하세요: ");
		String line = scan.nextLine();
		System.out.print("중복횟수를 확인할 단어를 입력하세요: ");
		String check = scan.next();
		
	
		while(true) {
			index = line.indexOf(check);
			if(index ==-1) {
				break;
			}
		count++;
		line=line.substring(index+1);	//문자열 앞에서부터 확인하고 겹친거 확인하면 앞에 떼어내기 .substring()
		}
		System.out.println(count+"번");
			
		
		
		scan.close();
	}
}
