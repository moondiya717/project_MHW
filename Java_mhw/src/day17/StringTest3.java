package day17;

import java.util.Scanner;

public class StringTest3 {
	public static void main(String[] args) {
		System.out.println("abcdef".indexOf("bc"));	//결과: 1 => 앞에서부터 순서대로 0번지부터 세서 겹치는 첫글자로 숫자로 보여줌
		System.out.println("abcdef".indexOf("ad"));	//결과: -1 => 아니면 무조건 -1이나옴
		
		/*두 단어, 단어A와 단어B를 입력받고 단어A에 단어B가 있는지 없는지 확인하는 코드를 작성하세요*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("두 단어를 입력하세요(예: abcd dc): ");
		String str1 = scan.next();
		String str2 = scan.next();
		
		//.indexOf() 는 겹치는게 있는지 없는지 확인가능 => 조건문에서 리턴타입int니까 boolean으로 나올 수 있도록 조건식 만들어야 함
		if(str1!=null && str1.indexOf(str2)>=0) { //>=0 또는 !=-1 으로 나타낼 수 있음 => 포함되어있을땐 겹치는 첫글자기준 번지가 나오니까 수가 계속 바뀌어서 0이나 -1처럼 기준값이 있어야함
			System.out.println("첫 번째 단어 "+ str1+ "에 " + "두번째 단어 "+str2+ "가 포함되어 있습니다.");
		}else {
			System.out.println("첫 번째 단어 "+ str1+ "에 " + "두번째 단어 "+str2+ "가 포함되어 있지 않습니다.");
		}
		
		
		//문자열의 길이를 확인할 때, .length()를 이용! =>얘는 length뒤에 괄호가 있음!! // 배열 : 배열이름.length는 뒤에 괄호가 없음***
		if(str1!=null) {
			System.out.println(str1+"의 길이 :" + str1.length());
		}
		
		
		
		
		
		scan.close();
	}

}
