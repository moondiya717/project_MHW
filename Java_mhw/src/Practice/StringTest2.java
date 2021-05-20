package Practice;

import java.util.Scanner;

public class StringTest2 {
	//equals예제
	public static void main(String[] args) {
		/* "홍길동"이라는 단어와 "홍길동"이라는 단어가 같은지 equals를 사용해서 비교하는 코드 */
		System.out.println("홍길동".equals("홍길동"));	//결과값 boolean=>참/거짓
				
		/*두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 단어를 입력하세요(예: 홍길동 홍길동): ");
		String w1 = scan.next();
		String w2 = scan.next();
		
		// System.out.print(w1.equals(w2)); 를 아래와 같이 멋드러지게~yay
		if(w1.equals(w2)) {
			System.out.println(w1+ "과 "+ w2+"는 "+ "같은 단어입니다.");
		}else {
			System.out.println(w1+ "과 "+ w2+"는 "+ "다른 단어입니다.");
		}
		
		scan.close();
	}

}
