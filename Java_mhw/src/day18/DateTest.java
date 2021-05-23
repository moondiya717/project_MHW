package day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {	//Date클래스 (너무 중요하니까, 코드를 저장해놨다가 나중에 필요할때 꼭 쓰셈)

	public static void main(String[] args) {
		//현재 시간을 객체로 생성
		Date date = new Date();		//생성자를 통해 객체 만들기, Date에서 java.utill 눌러주기~
		
		//현재시간을 출력
		System.out.println(date);	//실행했을 때의 시간이 출력 예)Fri May 21 09:45:52 KST 2021

		//현재 시간을 원하는 형태로 문자열로 변경(Date => String)	확인할때 필요 getter
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//대소문자* 꼭 지켜주기 달M 분m, 연도 yyyy
		String str=form.format(date);
		System.out.println(str);
	
		
		
		//시간표현으로 된 문자열을 시간 객체로 변경(String => Date)		setter
		String str2="2021-05-21 09:50:55";
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2;
		try {
			System.out.println(str2);
			date2 = form2.parse(str2); 		//RuntimeException이아니라서 처리해줘야돼 ParseException
			System.out.println(date2);		//str2가 이렇게 출력됨: Fri May 21 09:50:55 KST 2021 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("예약 정보를 입력하세요.");
		System.out.println("입실일(yyyy년MM월dd일) : ");
		Scanner scan = new Scanner (System.in);
		String startDate = scan.next();
		System.out.println("퇴실일(yyyy년MM월dd일) : ");
		String endDate = scan.next();
		Hotel hotel = new Hotel();	//hotel객체 만듬
		hotel.setEndDate(endDate);
		hotel.setStartDate(startDate);
		
		System.out.println(hotel);
		
		scan.close();
	}
}
class Hotel{	//날짜가 웹에서선택하면 문자열로 들어감
	
	Date startDate;		//입실일
	Date endDate;		//퇴실일
	
	//다른 정보는 생략
	

	
	public String getStartDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");	
		String str=form.format(startDate);
		return str;
	}
	public void setStartDate(String startDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");

		try {
			this.startDate = form2.parse(startDate); 		
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
	public String getEndDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");	
		String str=form.format(endDate);
		return str;
	}
	public void setEndDate(String endDate) {
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy년MM월dd일");

		try {
			this.endDate = form2.parse(endDate); 		
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
	@Override	//이거 왜한거지? => 책에 나와있대
	public String toString() {
		return "Hotel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	
}