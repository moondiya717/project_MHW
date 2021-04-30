package day5;

public class Test5_1 {

	public static void main(String[] args) {
		/* while문을 이용하여 구구단 7단을 출력하는 코드를 작성하세요. */
		//While문이 뭐 입력해서 그거 답나오게하는거 할때 조건만 있으니까 딱 어울린대
		
		int i=1;
		while(i<=9) {
			System.out.println("7 X " + i + " =" + (7*i));
			i+=1; //잊지말아야지! for과 다르게 따로 써줘야하니까!
		}
	
System.out.println("---------------");
		
		for(i=1; i<=9; i+=1) {
			System.out.println("7 X " + i + " =" + (7*i));
		}
		
		
		
		
	}

}
