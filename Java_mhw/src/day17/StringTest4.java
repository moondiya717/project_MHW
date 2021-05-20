package day17;

import java.util.Scanner;

public class StringTest4 {

	public static void main(String[] args) {
		
		//.replace(A,B) => (단어,문자 등)바꾸기 같은기능
		System.out.println("제 이름은 홍길동입니다.".replace("홍길동","임꺽정"));
		
		/* 문자열C를 입력받고, 해당 단어에 문자열A와 문자열B를 입력받아 문자열C에 있는 문자열 A를 문자열 B로 바꾸는 코드를 작성하세요.*/
		
		//문자열 C가 문자열A를 가지고있고 =>A를 B로 바꾼다
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 문자열을 입력하세요: ");
		String w1=scan.next();
		
		System.out.print("첫번째 문자열에서 수정할 문자열과 대체할 문자열을 입력하세요: ");
		String w2=scan.next();
		String w3=scan.next();
		
		if(w1!=null && (w1.indexOf(w2))>=0) {
			System.out.println("수정 후 문자열: " + w1.replace(w2,w3));
		}else {
			System.out.println(w2 + "는 " + w1+ "에 포함되어있지 않아, 단어를 바꿀 수 없습니다.");
		}
		
		System.out.println(w1);	//처음에 입력받은 단어 w1을 출력하면 수정전으로 출력됨 => 원본값이 바뀌지 않음을 알 수 있음
		
		//Teacher's code
		System.out.println("단어를 입력하세요: ");
		String strC = scan.next();
		System.out.println("수정할 곳의 단어와 수정될 단어를 입력하세요(예: 자바 Java): ");
		String strA = scan.next();
		String strB = scan.next();
		
		//strC = strC.replace(strA,strB);		//strC = 을 붙여줌으로써 수정된값을 원본에 저장해서 원본이 바뀜을 알 수 있음
		//System.out.println("바뀐 단어: " + strC);	//수정값을 바꾼 이후에 단어자체를 출력해보면 수정이후 바뀐 값이 나옴
		
		//위의 주석처리된 두 줄의 식을 밑으로 또 바꿀 수 있음
		if(strC != null && strC.indexOf(strA)!=-1) {
			strC = strC.replace(strA, strB);
			System.out.println("바뀐 단어 :" + strC);
		}else {
			System.out.println("단어를 바꿀 수 없습니다.");
		}
		
		
		
		scan.close();
	}

}
