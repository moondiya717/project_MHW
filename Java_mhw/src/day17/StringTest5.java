package day17;

import java.util.Scanner;

public class StringTest5 {

	public static void main(String[] args) {
		
		//String str = "안녕하세요";
		//System.out.println(str.substring(2));	//()번지부터 마지막번지까지 부분 문자열 생성
		//System.out.println(str);				//.substring은 원본을 수정하는 것이 아니라 새로운 문자열을 생성해서 전달
		//System.out.println(str.substring(2,3));	//(A,B) A번지부터 B번지 "전"까지 새로운 부분 문자열을 생성

		
		/* 주민등록번호를 입력해서 생년월일 부분을 추출하여 년도 월 일을 출력하는 코드를 작성하세요.
		 * 예시: 
		 * 주민번호를 입력하세요 : 020101-3234567
		 * 2002년 1월 1일
		 * 
		 * 예시:
		 * 주민번호를 입력하세요 : 020101-1234567
		 * 1902년 1월 1일
		 * */
		
		//뒷자리 1,2 => 1900년대 3,4면 2000년대 

		Scanner scan = new Scanner (System.in);
	
		
		System.out.print("주민번호를 입력하세요(예: 000000-0000000): ");
	try {	//0-0입력하면 계속 에러가 나길래 예외처리해봤음
		String idnum= scan.next(); //콘솔로 입력받게되면 null값인지 아닌지 확인할 필요가 없다.
		String year =idnum.substring(0,2);
		String month = idnum.substring(2,4);
		String day = idnum.substring(4,6);
		String gd = idnum.substring(7,8);//<=문자열 //또는 char gd = str.charAt(7); <=문자
	
		//방법1
	
		if(gd.equals("1")||gd.equals("2")) {				//gd타입이 String이니까 gd.equals() 괄호안에 1이 아니라 "1" 문자열취급 필수!
			System.out.println("19"+year+"년 "+ month+"월 "+ day+"일");
		}else if(gd.equals("3")||gd.equals("4")) {
			System.out.println("20"+year+"년 "+ month+"월 "+ day+"일");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}catch(RuntimeException e) {
		e.printStackTrace();	//어떤오류인지 잡아내는곻ㅎㅎ넘죠타
		System.out.println("잘못된 입력입니다.");
	}
		
		/*
		//방법2
		switch(gd) {
		case "1", "2" :
			year = "19" + year;
			break;
		case "3", "4" :
			year = "20"+ year;
			break;
		}
		System.out.println(year + "년"+ month + "월" + day + "일");
		
		*/
		
		scan.close();
	}

}
