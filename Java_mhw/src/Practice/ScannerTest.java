package Practice;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
	//	Scanner scan = new Scanner(System.in); //(system.in) : 표준입력으로 콘솔에서 입력받아서 동작시키겠다라는 뜻
		
		/* next() 		: 공백(엔터, 스페이스)을 만나기전까지 문자열을 가져오는 메소드
		 * nextLine()	: 처음 만나는 엔터까지 문자열을 가져오고 만났던 엔터는 버리는 메소드
		 * */
		
		Scanner scan = new Scanner("1234 1234\n4567\n8910\n++++\n");
		String stc = scan.nextLine();
		System.out.println(stc);	//엔터전까지 값을 추출, 만났던 엔터 버림
		
		stc = scan.nextLine();
		System.out.println(stc);	//엔터전까지 값 추출, 만났던 엔터버림
		
		int num = scan.nextInt();	//공백전까지 값을 추출
		System.out.println(num);
		
		stc = scan.nextLine();		//int num가 8910숫자만 추출, 남아있는 엔터바로 만남
		System.out.println(stc); 	
		
		stc = scan.nextLine();		//위에서 엔터가져가고 남아있던 ++++ 추출, 엔터버림
		System.out.println(stc);	
		
		stc = scan.nextLine();		//더이상남아있는문자열이 없어서 콘솔창에러
		System.out.println(stc);
		
		scan.close();
	}

}
