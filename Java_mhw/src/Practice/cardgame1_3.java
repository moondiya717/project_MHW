package Practice;

public class cardgame1_3 {

	public static void main(String[] args) {
		/* 카드 게임: 실제 포커 게임은 모양과 숫자를 다 고려해야하지만 
		 * 			여기에선 숫자만 고려, 카드는 7장
		 * 			카드는 1~13이 4개씩(하트, 다이아, 세잎, 스페이스)
		 * 센 순서대로, 숫자 확정되면 밑에껀 확인할 필요없음.
		 * 1 포커		: 같은 숫자가 4개 
		 * 2 풀하우스 	: 트리플1 + 페어1(투페어) 또는 트리플2
		 * 3 스트레이트	: 연속된 숫자가 5개이상
		 * 4 트리플		: 같은 숫자가 3개
		 * 5 투 페어		: 같은 숫자가 2개씩 2개=> 페어가 2개
		 * 6 페어		: 같은 숫자가 2개
		 * 7 탑			: 위의 모든 조건이 없는 가장 큰 수
		 * */

		int []arr=new int[]{1,1,1,2,2,2,8};

		/*트리플인 숫자를 출력하기 (트리플 갯수 상관없음)*/
		int num=0;
		int triple[]=new int[2];
		int res=0;
		int count=1;
		
		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
				num=arr[i];
			}else{
				if(count==3){
					triple[res]=num;
					res+=1;
				}
				count=1;
			}
		}	
		if(count==3) {
			triple[res]=num;
			res+=1;
		}
		if(res==0) {
			System.out.print("트리플인 숫자: 없음");	
		}else {
			for(int i=0; i<res; i+=1) {
				System.out.print(triple[i]+ " ");
			}
		}
	}
}