package day10;

public class Sort {

	public static void main(String[] args) {
		/* 배열 정렬: 버블 정렬 
		 * - 옆에 요소와 비교하여 정렬하는 방법
		 * 예시)
		 * 5 4 6 9 8 7 10 [0,1번지 비교]
		 * 4 5 6 9 8 7 10 [1,2]
		 * 4 5 6 9 8 7 10 [2,3]
		 * 4 5 6 9 8 7 10 [3,4]
		 * 4 5 6 8 9 7 10 [4,5]
		 * 4 5 6 8 7 9 10 [5,6] 
		 * 4 5 6 8 7 9 10 =>10이 확정 (0,1번지 비교에서 5,6번지 비교까지오는게 한 번, 이 절차를 여러번 함)
		 * 4 5 6 8 7 9 10 [0,1 번지 비교]
		 * 4 5 6 8 7 9 10 [1,2]
		 * 4 5 6 8 7 9 10 [2,3]
		 * 4 5 6 8 7 9 10 [3,4]
		 * 4 5 6 7 8 9 10 [4,5] =>9가 확정 (이미 10이 확정이라 5,6번지 비교는 안함)
		 * (이아래는 0,1번지가 확정 될 때까지 버블 정렬을 진행함. 정렬이 끝났어도 이 방법은 계속 정렬하기때문에 효율이 떨어짐)
		 * 두 수를 비교해서 작은 숫자를 앞으로 보냄
		 * ==> 작은 반복문의 횟수:배열에서 두 수의 비교 (6=> 5=> 4=> 3=> 2=> 1번) = 	6-i(반복횟수) < 7(배열의 갯수)-i(=arr.length-i)
		 * (0=>1=>2=>3=>4=>5(큰 반복횟수의 i값) 
		 * */

		int []arr = new int [] {5,4,6,9,8,7,10};
		printArray(arr);
		System.out.println();
		for(int i=0; i<arr.length-1; i+=1) {
			for(int k=0; k<arr.length-1-i; k+=1) {  //arr.length-1-i 는 k를 번지 기준으로 0부터 시작해서 -1까지 해줘야함.
				if(arr[k]>arr[k+1]) {
					int tmp = arr[k];	//배열 위치 조정하기위해서 다른 변수하나에 담고 옮겼음
					arr[k] = arr[k+1];
					arr[k+1]=tmp;
				}
				printArray(arr);
				System.out.println();
			}
		}
		printArray(arr);
	}
	public static void printArray(int []arr) {
		for(int i=0; i<arr.length; i+=1) {
			System.out.print(arr[i]+" ");
		}
	}
}
