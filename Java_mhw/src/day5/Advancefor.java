package day5;

public class Advancefor {

	public static void main(String[] args) {
		/*향상된 for문 예제
		 * - 배열이나 컬렉션프레임워크에서 사용가능한 for문
		 * - 전체 탐색할 때 사용
		 * - 값을 가져올 때 사용										=> 
		 * - 값을 변경할 때 사용하지 않음 (배열의 값이 바뀔때 사용하지 않음.)
		 * 
		 * for(타입 변수 : 배열명){
		 * 		 실행문;
		 * }
		 * 
		 * */
	
		int []arr = {1, 2, 3, 4, 5};
		
		
		//코드1(향상된for문 => 전체탐색할 때 사용/ 부분탐색할땐 사용X) - 몇번째 배열의 값인지 모름 & 배열의 값을 변경할 수 없음. 
		for (int tmp : arr) { //1. arr의 0번지 값을 tmp한테 넣어줌              3. 자동으로 1번지로 가서 반복문을 실행
			System.out.print(tmp + " "); //2. 콘솔에 tmp를 출력함
		}
		
		
		System.out.println();
		//코드1과 같은 코드는 아래와 같음
		
		//코드2 - 몇번째 배열의 값인지 또는 배열의 값을 변경할 수 있음. 
		for(int i = 0; i<arr.length; i+=1) {
			int tmp= arr[i];
			System.out.print(tmp + " ");
		}
		
		
		
	}

}
