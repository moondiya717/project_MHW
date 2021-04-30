package day5;

public class Array3 {

	public static void main(String[] args) {
		/*정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력하면 됩니다.*/
		/**반복횟수	 	: i는 1부터 num보다 작거나 같을 때까지 1씩 증가
		 * 규칙성			: num를 i로 나누었을때 나머지가 0과 같으면 배열 cnt번지에 i를 저장 후
		 * 					cnt를 1증가 후 cnt가 10과 같으면 반복문 종료
		 * 반복문 종료 후 : 배열에 있는 값을 0번지부터 cnt가 출력**/
		
		
		// 정수 num 변수 만들기 , 약수만들기
		
		int i, num = 12;
		int []arr = new int[10]; //new int뒤에 []안에 번지 아니고 10개짜리 갯수
		int cnt = 0;	
		
		//약수를 구하는 for문만들기
		for(i=1; i<=num; i+=1) {
			if(num % i==0 ) {
				arr[cnt]=i;
				cnt+=1;	  //cnt를 1증가 후 
				if(cnt==10) {  //cnt가 10과 같으면 반복문 종료
					break;//반복문 종료;
				}
			}		
		}
		//출력 => 향상된 for문을 쓰지 않는이유는 무조건 10개가 보여지니까 갯수가 10개가 안될 때  0 0 0 0 0 이런식으로 뒤에 나옴.
		for(i=0; i<cnt; i+=1) {
			System.out.println(arr[i]+ " ");
		}

	
			
		

		
		
				
				

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
