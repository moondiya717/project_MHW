package day17;

import java.util.Scanner;

public class StringTest9 {

	public static void main(String[] args) {
		/* 공백을 포함한 긴 문자열을 입력한 후, 단어를 입력받아 해당 단어가 몇 번 나오는지 확인하는 코드를 작성하세요.
		 * 예시)
		 * 문장 입력 : Hello. Hi. HHHH. He. His
		 * 단어 입력 : H
		 * 횟수 : 8번 */

		//문장입력하고 단어를 입력하면 해당 단어가 몇번 나오는지 세는
		
		
		//Scanner를 통해 콘솔에서 문장을 입력 받음
		Scanner scan = new Scanner (System.in);
		System.out.print("문장을 입력하세요: ");
		String stc = scan.nextLine(); 

		//콘솔에서 단어를 입력받음
		System.out.print("횟수를 확인하고자 하는 단어를 입력하세요: ");
		String wd= scan.next();

		//반복문을 통해 해당 단어가 몇 번 있는지 체크(indexOf()를 이용해서)
		int count = 0; //단어의 갯수
		int index = 0; //해당 단어가있는 시작번지
		while(true) {
			index = stc.indexOf(wd);		//문장에 해당 단어가 있는 위치를 찾음
			if(index == -1) {
				break;
			}
			count++;
			stc = stc.substring(index +1);	//stc에 확인한 것 제외하고 "저장"을 반복
		}
		System.out.println(count + "번");
		
		
		
		scan.close();
	}
}
