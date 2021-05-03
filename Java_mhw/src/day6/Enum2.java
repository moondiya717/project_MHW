package day6;

import java.util.Scanner;

public class Enum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//열거형을 사용한 요일을 입력하고 출력하는 예제 - 나중에 마무리후에 업로드해주신다 함.

		Week1 today = Week1.MONDAY;
		System.out.print("요일을 입력하세요(1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일): ");
		Scanner scan = new Scanner(System.in);
		int itoday = scan.nextInt();
		today.setWeek(itoday);
		switch(today) {
		case MONDAY: System.out.println("월요일 입니다.");	break;
		case TUESDAY: System.out.println("화요일 입니다.");	break;
		case WENDESDAY: System.out.println("수요일 입니다.");	break;
		case THURSDAY: System.out.println("목요일 입니다.");	break;
		case FRIDAY: System.out.println("금요일 입니다.");	break;
		case SATURDAY: System.out.println("토요일 입니다.");	break;
		case SUNDAY: System.out.println("일요일 입니다.");	break;
		}
		//Scan.close();
	}

} 												//여기는 나중에 class를 배우고나서 설명을 해주시겠다고 하셨음
enum Week1{MONDAY(1), 
	TUESDAY(2), 
	WENDESDAY(3), 
	THURSDAY(4), 
	FRIDAY(5), 
	SATURDAY(6), 
	SUNDAY(7);	//마지막 끝괄호 뒤에 적을 것
//enum 열거형명 {이름1,이름2 ...}
	private int week;
	
	public int getWeek() {
		return week;
	}
	
	public void setWeek(int week) {
		this.week = week;
		
	}
	
	Week1(int week){
		this.week = week;
	}
}