package day10;

import java.util.Scanner;

public class ClassEx5 {

	
	public static void main(String[] args) {
		/* Circle 클래스를 이용하여 원 객체를 생성한 후 테스트 하는 예제*/
		Circle  c1 = new Circle();
		//클래스명 객체이름(맘대로) = new 클래스명(); 
		c1.print();
		
		//중심점을 5,5로 이동
		c1.move(5, 5);
		c1.print();
		
		//반지름 길이 변경 5로
		c1.setRadius(5);
		c1.print();
		
		//생성자를 설명하기 위한 Scanner 입력
		Scanner scan = new Scanner(System. in);
		//클래스  객체 = new [생성자             ]
		//Scanner라는 클래스를 이용하여 scan 객체를 선언하고, Scanner(System.in) 생성자를 이용하여 객체를 생성
		//new가 객체를 만들고, 만들어진 객체에 멤버변수를 Scanner(System.in) 생성자를 이용하여 초기화.
		int x = scan.nextInt();
		scan.close();
	}

}
