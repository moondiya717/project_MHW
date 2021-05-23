package Practice;

import java.util.Calendar;

public class CalendarTest {
	//static => 기울임꼴, final(상수) => 굵은글씨체 //클래스아래, 메인위에 선언
	static int italic;
	static final int italicBold=0;
	
	
	public static void main(String[] args) {
		// Calendar클래스는 추상클래스
		// Calendar 클래스는 운영체제의 날짜와 시간을 얻을 때 사용 
		// 해당 운영 체제의 Calendar객체를 얻으면 연도, 월, 일, 요일, 오전/오후, 시간 등의 정보를 얻을 수 있음
		

		//캘린더 클래스를 이용해서 now라는 멤버변수, 객체를 선언함 
		//Calendar의 static메소드인 .getInstance()를 이용하면 현재 운영체제 설정의 시간대를 기준으로 한 Calendar하위 객체 얻을 수 있음
		Calendar now = Calendar.getInstance();
		
		
		//get메소드쓰는데 ()안에 숫자에 따라서 숫자가 달라짐
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1; 		//month가 0~11까지라서 +1해서 12맞추기
		int day= now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		int week = now.get(Calendar.DAY_OF_WEEK); 	//요일 =>String으로나오게 해야험
		String strWeek="";
		switch(week){ //week 정수에 따라 String의 strWeek의 값을 요일별로 설정해서 출력
		case Calendar.MONDAY :	strWeek="월요일"; break;
		case Calendar.TUESDAY: 	strWeek="화";	break;
		case Calendar.WEDNESDAY:strWeek="수";	break;
		case Calendar.THURSDAY: strWeek="목";	break;
		case Calendar.FRIDAY: 	strWeek="금";	break;
		case Calendar.SATURDAY: strWeek="토";	break;
		default:				strWeek="일";	break;
		}System.out.println(year+"년 "+month+"월 "+day+"일 "+strWeek+"요일");
		
		int amPm = now.get(Calendar.AM_PM);			//오전,오후 => String으로
		String strAmPm=    amPm==Calendar.AM ? "오전":"오후";	//amPm==Calendar.AM 참(오전),거짓(오후) 값을 strAmPm에 저장
		System.out.println(strAmPm + " " + hour + "시 "+ minute+ "분 "+ second + "초");

	}

}
