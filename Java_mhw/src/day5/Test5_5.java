package day5;

public class Test5_5 {

	public static void main(String[] args) {
		/*1부터 10사이의 랜덤한 수를 6개 생성하여 배열에 저장한 후 출력하는 코드를 작성하세요. 
		 * 단, 생성된 랜덤한 수는 중복될 수 있음*/
								
		/**반복문 (6번 반복) - 랜덤으로 1-10사이의 수 생성, 생성된 랜덤한 수를 배열에 저장
		 * 반복문 (6번 반복) - 배열 값 출력**/
		
												// 배열 6개 만들기
												//	min 1 , max 10 => 랜덤수 6개 만들기
												//	배열 6개에 저장
												//출력
	int [] arr=new int[6];
	int min=1, max=10, r, i;

	
	for(i=0; i<arr.length; i+=1) {
		r=(int)(Math.random()*(max-min+1)+min);
		arr[i]=r;
	}
	for(i=0; i<arr.length; i+=1) {
		System.out.print(arr[i]+ " ");
	} 
		
							
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
