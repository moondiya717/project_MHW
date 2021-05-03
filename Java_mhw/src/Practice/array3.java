package Practice;

public class array3 {
	
	public static void main(String[] args) {
		/*정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력하면 됩니다.*/
	
		//num라는 정수 변수선언 + 배열10개짜리 생성
	
		int arr[]=new int[10], i, cnt=0, num=20;	//num 테스트용 수 입력
		
		//num의 약수를 구하는 코드 작성 -> 약수를 배열에 저장 -> 약수의 갯수를 
		for(i=1; i<=num; i+=1) {
			if(num%i==0) {
				arr[cnt]=i;
				cnt+=1;
				if(cnt==10) {
					break;
				}
			}
		}
		
		for(i=0; i<cnt; i+=1) {
			System.out.print(arr[i] + " ");
		}
		
		
		
		
		
	}
	
}
