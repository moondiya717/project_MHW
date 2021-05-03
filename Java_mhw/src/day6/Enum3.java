package day6;

import java.util.Calendar;

public class Enum3 {

	public static void main(String[] args) {

		
		
		
		Calendar now = Calendar. getInstance();			//실행했을 당시의 날짜와 시간을 알려줌
		int year = now.get(Calendar.YEAR);				//now.get(1)이랑 같음	 	=>calendar.year이 더 인지하기 쉬워서 //현재 날짜의 년도를 알려줌
		int month = now.get(Calendar.MONTH) + 1;		//now.get(2)와 같음 		//현재 날짜의 월을 알려줌(0부터 시작을 함, 0부터 11까지라서 +1를 해줘야함)
		System.out.println(year + "년" + month + "월");
		
		
				
				

	}

}
