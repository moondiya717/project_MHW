package Practice;

import java.util.Scanner;

public class StringTest5 {

	public static void main(String[] args) {
		/*.substring()를 이용하여 "안녕하세요."에서 "하세요."만 출력하는 코드*/ 
		System.out.println("안녕하세요.".substring(2));
		
		/*.substring(A,B)를 이용하여 "안녕하세요."에서 "녕하"만 출력하는 코드*/
		System.out.println("안녕하세요.".substring(1,3));
		
		/* 주민등록번호를 입력해서 생년월일 부분을 추출하여 년도 월 일을 출력하는 코드를 작성하세요.
		 * 예시: 
		 * 주민번호를 입력하세요 : 020101-3234567
		 * 2002년 1월 1일
		 * 
		 * 예시:
		 * 주민번호를 입력하세요 : 020101-1234567
		 * 1902년 1월 1일
		 * */
		
		Scanner scan = new Scanner (System.in);
		System.out.print("주민등록번호를 입력하세요(예: 000000-0000000): ");
		try {
			String num=scan.next();
			String year=num.substring(0,2);
			String month=num.substring(2,4);
			String day=num.substring(4,6);
			String gender=num.substring(7,8);
			
			if(gender.equals("1") || gender.equals("2")) {
				System.out.println("19"+year+"년 "+ month+"월 "+ day+"일 ");
			}else if(gender.equals("3") || gender.equals("4")) {
				System.out.println("20"+year+"년 "+ month+"월 "+ day+"일 ");
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}catch(Exception e){
			e.printStackTrace();	//어떤오류인지 잡아내는 코드 (출력빨간색 에러난거 아님)
			System.out.println("잘못된 입력입니다.");
		}
		
		scan.close();
	}

}
