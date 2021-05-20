package day17;

import java.util.Scanner;

public class StringTest2 {
	//equals예제
	public static void main(String[] args) {
		System.out.println("홍길동".equals("홍길동")); //문자열 상수에서도 사용가능이래 "A단어".equals("B단어")

		/*두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		System.out.print("두 단어를 입력하세요(예: abc cde): ");
		String w1 = scan.next();
		String w2 = scan.next();
		
		//w1과 w2가 같다면 같은 단어라고 출력하고 다르면 다른단어라고 출력
		if(w1 != null && w1.equals(w2)) {	//꼭 항상 앞에서 null인지 아닌지 확인을 해줘야 함
			System.out.println("단어" + w1+ "과 단어" + w2 + "는 같은 단어입니다.");
		}else if(!(w1.equals(w2))) {			//else로 써서 더 짧게 가능 //나는 !를 넘써보고싶었쪙
			System.out.println("단어" + w1+ "과 단어" + w2 + "는 다른 단어입니다.");
		}
		
		scan.close();
	}

}
// 코드로 나타내야하는 문제가 "같다" 일때, 일반변수: A==B / 참조변수: A.equals(B)
//***일반변수는 클래스가 아니기때문에 equals를 쓸 수 없음. 참조변수는 주소값이기때문에 equals를 쓸 수 있는 것임