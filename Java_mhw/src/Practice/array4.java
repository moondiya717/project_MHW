package Practice;

public class array4 {

	public static void main(String[] args) {
		/* 1~10 사이의 정수 3개를 랜덤으로 생성하여 배열에 저장한 후
		 * 생성된 값들이 중복되었는지 안되었는지 확인하는 코드를 작성하세요.
		 * 예시 :
		 * 
		 * 랜덤 :  3 8 2 => 중복되지 않음 (출력)
		 * 
		 * 랜덤 : 2 8 8 => 중복 (출력) 
		 * 
		 * */
		 
		 
		 //정수 배열3개짜리 생성 //3개짜리 [3]으로 해야돼. arr[]가 0으로 시작하는거임, new int랑 헷갈리지 말 것.
		int arr[]=new int[3], i, min=1, max=10;
		

		System.out.print("랜덤: ");
		//반복문 사용 -> 정수의 랜덤3개수 생성 + 배열에 저장 
		for(i=0; i<3; i+=1) {
			arr[i]=(int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i] + " ");		//코드확인을위한 랜덤값출력
		}
			
		int j;
		//값 중복에 대한 확인코드 작성
		
		boolean isDuplicated= false;			//확인위한 기본값(중복X) 변수선언
		for(i=0; i<=arr.length-1; i+=1) {		//수 비교하려는 줄 수 세팅(예: 5개숫자는 대조할때 4줄나열)
			for(j=i+1; j<arr.length; j+=1) {    //각개의 숫자들 비교를 위한 반복횟수 세팅
				if(arr[i]==arr[j]) {			//i번째 열이랑 k번째 열이랑 순서대로 숫자 비교 중 
					isDuplicated=true;			//기본값(중복X)을 중복이라고 값을 덮어씀
				}
			}
		}
		if(isDuplicated) {
			System.out.print("중복");
		}else {
			System.out.print("중복이 아님");
		}
		
		
		
	}
}
