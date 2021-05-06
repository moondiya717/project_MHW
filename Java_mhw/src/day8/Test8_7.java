package day8;

public class Test8_7 {

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
		 * */

		int arr[] = new int[] {1,1,1,2,3};	//배열만들어
		int count =1;
		int res = 0; //숫자가 2개 일치하는 경우가 있는지 없는지 알려주는 변수 
		
		//같은 숫자를 카운트해서 2를 센다. 3되면 X
		for (int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
			}else{			//3개이상이던 아니던 나머지결과 값은 카운트 초기화 
				if(count==2){
					res+=1;
				}
				count=1;

			}
		}
		if(count ==2) {	//마지막에 +1해서 2가 된 경우를 위함
			res+=1;
		}
		System.out.println(res);

		

		

	}

}