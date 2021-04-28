package day3;

public class Switch1 {

	public static void main(String[] args) {
		// Switch문을 이용한 홀,짝 판별 예제
		int num = 123;
		
		switch(num % 2) { //정수형&문자열만 가능 - 변수나 식 넣기 , num>0 은 결과값이 참,거짓으로 나오기때문에 오류남
		case 0:
			System.out.println("짝수");
			break;
		default : //case 1: 이라고 해도되지만, 홀짝은 두개뿐이니깐 default 씀
			System.out.println("홀수");
		}

		
		
		
		
		
		
	}

}
