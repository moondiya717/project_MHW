package Practice;

public class test8_6 {

	public static void main(String[] args) {
		/* 5개짜리 배열에 같은 숫자가 2개 있는지 없는지 판별하는 코드를 작성하세요
		 * 단, 숫자는 정렬되어 있다고 가정
		 * 
		 * 예시 : 1 1 2 3 4
		 * 있음
		 * 
		 * 예시 : 1 2 3 4 5
		 * 없음
		 * 
		 * 예시 : 1 1 2 2 4
		 * 있음
		 * 
		 * 예시: 1 1 1 2 3
		 * 없음
		 * 
		 * i번지의 값고 i+1번지의 값이 같으면 count를 1증가
		 * 다르면, count의 값이 2와 같으면 result를 true로 수정 
		 * 		  count를 1로 초기화 (break안걸어줌)
		 * 반복문 종료 후,
		 * res가 true이면 있음이라고 출력, false이면 없음이라고 출력
		 * */

		int arr[] = new int[] {1,1,2,3,4};
		int count=1;
		boolean res = false;

		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
			}else{
				if(count==2) {
				res=true;
				}
			count=1;
			}
		}
		if(count==2) {
			res=true;
		}
		if(res==true) {
			System.out.print("있음");
		}else {
			System.out.print("없음");
		}
	 }
	}