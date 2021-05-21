package day18;

import java.util.Calendar;

public class CalendarTest {	//추상클래스
	//글자보여주려고
		static int num1;			//static 이면 기울임꼴
		final static int num2=0;	//final(=상수, 여기서는 클래스상수라서) 굵은글자
		
		public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		//get메소드쓰는데 ()안에 숫자에 따라서 숫자가 달라짐
		int year = now.get(Calendar.YEAR);		//0,1 이런걸 넣으면 알기쉽지않아서 클래스 상수를 사용함, year=1;
		int month = now.get(Calendar.MONTH)+1;	//month=2 get(2)랑같은데, 의미전달때문에 클래스상수 , month는 0~11값을가져오니까 +1을해서 12까지 나타내야함
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		String weekStr="";
		switch(week) {
		case Calendar.MONDAY: 	weekStr="월";	break;
		case Calendar.TUESDAY: 	weekStr="화";	break;
		case Calendar.WEDNESDAY:weekStr="수";	break;
		case Calendar.THURSDAY: weekStr="목";	break;
		case Calendar.FRIDAY: 	weekStr="금";	break;
		case Calendar.SATURDAY: weekStr="토";	break;
		default:				weekStr="일";	break;
		}
		System.out.println(year+"년 "+month+"월 "+day+"일 "+weekStr+"요일");

		int amPm=now.get(Calendar.AM_PM);	//오전,오후를 확인
		String amPmStr = amPm == Calendar.AM ? "오전" : "오후";
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.println(amPmStr + " " + hour + "시 "+ minute+ "분 "+ second + "초");
		
	}

}
