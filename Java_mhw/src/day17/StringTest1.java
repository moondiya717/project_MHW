package day17;

import java.util.Scanner;

public class StringTest1 {
	//charAt()메소드예제
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.print("문자를 입력: ");
		//char op = scan.next().charAt(0);	//이 한줄을 밑에 2줄로 나타낼 수 있음 => 체이닝기법(메소드가 연달아나옴) : next()메소드 . charAt(0) 메소드 
																			//리턴타입이 String인경우에 연달아서 체이닝기법을 쓸 수 있음	
		//Scanner 클래스에서 제공하는 next()라는 메소드를 통해 콘솔에서 입력받은 문자열을 가져옴
		String str = scan.next(); //next()에 마우스올리면 String클래스, java.utill ____ , next()메소드이름	
		//String 클래스에서 제공하는 charAt()라는 메소드를 통해 0번지에 있는 문자를 가져옴
		char op = str.charAt(0);
		
		System.out.println("입력 문자: " + op);
		scan.close();
	}

}
//scan.next(); 는 콘솔에서 문자열을 입력받아서 문자를 가져오는 역할
//next(), charAt()은 제공하는 클래스가 서로 다름 