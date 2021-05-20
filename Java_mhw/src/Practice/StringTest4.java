package Practice;

import java.util.Scanner;

public class StringTest4 {

	public static void main(String[] args) {
		/* .replace(A,B) 를이용하여 "제 이름은 홍길동입니다." 를 임꺽정으로 바꾸기*/
		System.out.println("제 이름은 홍길동입니다.".replace("홍길동","임꺽정"));
		
		/* 문자열C를 입력받고, 해당 단어에 문자열A와 문자열B를 입력받아 문자열C에 있는 문자열 A를 문자열 B로 바꾸는 코드를 작성하세요.*/
		//문자열C 는 A를 가지고있고, A=>B
		
		Scanner scan= new Scanner(System.in);
		System.out.print("문자열을 입력하세요: ");
		String wordC = scan.next();
		System.out.print("입력된 문자열 중에서 수정하고싶은 단어와 수정할 단어를 입력하세요: ");
		String wordA = scan.next();
		String wordB = scan.next();
		
		if(wordC!=null && wordC.indexOf(wordA)!=-1) {
			wordC=wordC.replace(wordA, wordB);	//원래값이 .replace(A.B)로는 바뀌지 않으니 저렇게 좌항에써서 값저장해주기
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		System.out.println(wordC);
		scan.close();
	}

}
