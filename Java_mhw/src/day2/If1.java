package day2;

public class If1 {

	public static void main(String[] args) {
		// If문 예제1
		//기본문법1 => 계산 후, 거짓일 경우는 아무런 작동을 하지 않는다. (참일때만 일함)
		int num = -1;
		
		if(num == 0) {
			System.out.println("0입니다.");
			
		} else if(num ==1) { //기본문법3 if와 else사이에 껴넣기 
			System.out.println("1입니다. ");
			
		} else { //else를 붙여서 기본문법2(else if없는상태)를 진행함. 그렇게하면 거짓일 경우 밑에있는 거짓을 위한 답변이 실행됨. else뒤에 암것도안와 { 하나만 쓰고, ()도 안돼.
			System.out.println("0과 1이 아닙니다.");
		}
		
		
		
		
		
		
		
	}

}
