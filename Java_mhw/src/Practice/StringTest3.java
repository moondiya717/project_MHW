package Practice;

import java.util.Scanner;

public class StringTest3 {

	public static void main(String[] args) {
		/* .indexOf()를 사용하여 포함된, 겹치는 단어의 번지 수 알아내기*/
		System.out.println("abcde".indexOf("bc"));	//값: 1 번지
		System.out.println("abcde".indexOf("dsf"));	//값: -1 없음
		System.out.println("abcde".indexOf("e"));	//값: 4 번지
		
		
		/*두 단어, 단어A와 단어B를 입력받고 단어A에 단어B가 있는지 없는지 확인하는 코드를 작성하세요*/
		Scanner scan = new Scanner (System.in);
		System.out.print("단어를 입력하세요: ");
		String w1=scan.next();
		System.out.print("중복여부를 확인할 단어를 입력하세요: ");
		String w2=scan.next();
		
		if((w1.indexOf(w2))>=0) {
			System.out.print(w1+"에는 "+ w2+"(이)가 있습니다.");
		}else {
			System.out.print(w1+"에는 "+ w2+"(이)가 없습니다.");
		}
		
		//문자열의 길이를 확인할 때, .length()를 이용! =>얘는 length뒤에 괄호가 있음!! // 배열 : 배열이름.length는 뒤에 괄호가 없음***
		System.out.println("abcde".length());
		
		scan.close();
	}
}
