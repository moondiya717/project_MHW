package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		//Date클래스는 특정 시점의 날짜를 표현, 저장하는 클래스
		//Date객체 안에는 특정 시점의 연도, 월, 일, 시간정보가 저장 됨.

		//현재 시간을 객체로 생성
		Date today = new Date();	//date클래스의 today라는 이름을 가진 객체를 Date클래스를 통해 생성
									//java.util필수
		
		//Date의 toString()메소드는 영문으로 날짜를 리턴함
		System.out.println(today);	//Sun May 23 14:12:55 KST 2021 출력실행기점 시간 출력

		//현재 시간을 원하는 형태로의 문자열로 변경(Date => String)	//java.text 같이쓰기 
		//SimpleDateFormat의 생성자 매개값(String "" + 소문자 y년, M대문자 월, d일, h시 소문자m 분, s초 - 갯수는 자리수)
		SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		//위에 객체를 얻었으니, .format() 메소드 호출로 원하는 형식의 날짜정보 얻기
		//String클래스 strForm이름을 가진 변수는 SImpleDateFormat의 객체 form을 통한 메소드 .format(Date의 현재시간객체); 
		String strForm = form.format(today);
		//출력
		System.out.println(strForm);	//2021년 05월 23일 02시 12분 55초
		
		
		
		//시간표현으로 된 문자열을 시간 객체로 변경(String => Date)
		String strForm2 = "2021-05-23 02:31:10";
		SimpleDateFormat form2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today2;
		
		//출력
		System.out.println(strForm2); //2021-05-23 02:31:10
		//Unhandled exception type ParseException 가 일어나서 today2=form2.parse(strForm2)를 try-catch
		try {
			today2=form2.parse(strForm2);
			System.out.println(today2); //Sun May 23 02:31:10 KST 2021 출력
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		
		/* 입실일과 퇴실일을 입력받아 호텔 예약일과 종료일을 출력시키는 예제 
		 * */
		System.out.println("예약정보를 입력해주세요.");
		System.out.println("입실일(yyyy년MM월dd일) : ");
		Scanner scan = new Scanner(System.in);
		String startDate = scan.next();
		System.out.println("퇴실일(yyyy년MM월dd일) : ");
		String endDate = scan.next();
		Hotel hotel = new Hotel();
		hotel.setEndDate(endDate);	//여기서부터 모름 
		hotel.setStartDate(startDate);
		
		System.out.println(hotel);
		
		scan.close();
		
	}

}
class Hotel{
	Date startDate;
	Date endDate;
	


	@Override
	public String toString() {
		return "hotel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}


