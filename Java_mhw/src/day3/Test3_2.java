package day3;

import java.util.Scanner;

public class Test3_2 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 0, 양수, 음수인지 판별하는 코드를 작성하세요. */ 
		
		
		System.out.print("정수를 입력하세요: ");
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if(num > 0) { 
			System.out.println(num + "은(는) 양수입니다.");
		
		} else if(num < 0) { //-1 (-)부호쓰는 것 상관없이 사용가능
			System.out.println(num + "은(는) 음수입니다.");
		
		} else if(num == 0) {  //else if랑 else - 조건식 없애야징 -> 둘다 가능
			System.out.println(num + "은(는) 0 입니다.");
		}
		
		
		
		scan.close();
		
		
	}

}
