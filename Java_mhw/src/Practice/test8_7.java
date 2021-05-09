package Practice;

public class test8_7 {

	public static void main(String[] args) {
		/* 5개짜리 배열에 페어가(같은 숫자가 2개 있는 경우) 
		 * 몇 개 있는지 판별하는 코드를 작성하세요.
		 * 단, 숫자는 정렬되어 있다고 가정
		 * 
		 * 예시 : 1 1 2 3 4
		 * 1
		 * 
		 * 예시 : 1 2 3 4 5
		 * 0
		 * 
		 * 예시 : 1 1 2 2 4
		 * 2
		 * 
		 * 예시: 1 1 1 2 3
		 * 0
		 * 
		 * 힌트: 5개짜리 배열에서 페어가 가능한건 최대2개
		 * */
		
		int arr[] = new int[] {1,1,1,2,3};
		int count=1;
		int res = 0;
		
		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
			}else{
				if(count==2) {
					res+=1;
				}
				count=1;
			}
		}
		if(count==2) {
			res+=1;
		}
		System.out.print(res);
	}
}
