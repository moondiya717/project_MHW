package day17;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
	//	Scanner scan = new Scanner(System.in); //(system.in) : 표준입력으로 콘솔에서 입력받아서 동작시키겠다라는 뜻
		
		/* next() 		: 공백(엔터, 스페이스)을 만나기전까지 문자열을 가져오는 메소드
		 * nextLine()	: 처음 만나는 엔터까지 문자열을 가져오는 메소드
		 * */
		
	
		Scanner scan = new Scanner("1234 1234\n4567\n8910\n++++\n");
		String str = scan.nextLine();
		System.out.println(str);
		System.out.println("-------");		//1234 1234 (엔터전까지 인식하고) \n버리고, str=4567\n8910\n++++\n
		
		str=scan.nextLine();				//
		System.out.println(str);			//4567 (엔터전까지 인식하고) \n버리고, str=8910\n++++\n
		System.out.println("-------");
		
		int num = scan.nextInt();			//8910 (nextInt는 숫자"만"인식) num에 저장하면서 빼내감 nextInt라서 \n은 남겨진 상태, str=\n++++\n
		System.out.println(num);
		System.out.println("-------");
		
		str = scan.nextLine();				//빈공백인 \n 을 만나기 전까지의 값이 없는 상태=> 공백 출력,  str=++++\n
		System.out.println(str);			
		System.out.println("-------");
	
		
	/*	Scanner scan = new Scanner("1234 1234\n\n\n4567\n8910\n++++\n");
		//scan.hasNext() 다음에 가져올 애가 있는지 없는지 체크(true, false)
		while(scan.hasNext()) {
			String str = scan.nextLine();
			if(str.length() != 0) {	// 배열로치면 !=null 이랑 같은 뜻이지, 길이라서 1이면 0번지가 있다는거라서 0이 아니면으로 씀
				System.out.println(str);
			}
		}
	*/	
		
		
		scan.close();
	}

}
