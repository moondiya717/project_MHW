package day17;

import java.util.Scanner;

public class StringTest7 {

	public static void main(String[] args) {

	//	String str = "1234-567-1564";
	//	String []arr = str.split("-"); //-를 기준으로 문자열을 나눠서 []arr배열에 각각 저장하겠다
	//	System.out.println(arr[0]);		//출력하면 -기준으로 덩어리째 문자열들이 번지에 들어가있는 것을 확인가능 
	//	System.out.println(arr[1]);
	//	System.out.println(arr[2]);

	
	
	/* 취미를 한 줄로 입력받아 각 취미를 출력하는 코드를 작성하세요.
	 * 예시)
	 * 취미를 입력하세요(예: 영화보기,음악감상,독서)): 영화보기,음악감상
	 * 취미리스트
	 * 1. 영화보기
	 * 2. 음악감상*/
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("취미를 입력하세요(예: 영화보기,음악감상,독서)): ");
	String h=scan.next();
	String []arr1 = h.split(",");
	
	if(arr1!=null) {
		for(int i=0; i<arr1.length; i++) {
			System.out.println((i+1)+ ". " + arr1[i]);
		}
	}
		
	
	scan.close();
	}

}
