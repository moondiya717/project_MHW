package Practice;

public class baseball {

	public static void main(String[] args) {
		/*선택형 숙제
		 * - 1 ~ 9 사이의 중복되지 않은 3개의 정수를 랜덤으로 생성
		 * - B : 숫자는 있지만 위치는 다른 경우
		 * - S : 숫자도 있고, 위치가 같은 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 예시 : 3 9 5(예를들어 랜덤으로 만들었을 때)
		 * >입력하세요 : 1 2 3 (입력)
		 * >1B (출력)
		 * >입력하세요 : 4 5 6 
		 * >1B
		 * 입력하세요 3 4 5 
		 * > 2S
		 * 입력하세요 : 3 5 9 
		 * >1S2B
		 * >입력하세요 : 6 7 8
		 * >O
		 * >입력하세요 : 3 9 5 
		 * > 3S
		 * 정답입니다. */
		
		
		//중복되지 않은 정수 3개 랜덤생성
		//3개의 랜덤 숫자를 배열에 저장
		//배열의 번호로 경우의 수를 생각해서 B,S,O가 나오도록 만들기
		
		int i, min=1, max=9;
		int arr[]=new int[3];
		
		for(i=0; i<3; i+=1) {
			int r = (int)(Math.random()*(max-min+1)+min);
			arr[i]=r;
			if(arr[i]==arr[i-1]) {
				arr[i]=
			}
		}
		
		
		

	}

}
