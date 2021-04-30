package day5;

public class Array2 {

	public static void main(String[] args) {
		/*5개짜리 정수 배열에 1부터 5까지 차례대로 저장 후 출력하는 예제*/

		//5개짜리 정수 배열 생성
		int []arr = new int[5];
		int i; 
		//배열의 갯수를 강조하기 위해서 <=4도 되지만 <5라고 한거임
		for(i=0; i<5; i+=1) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();// 두가지방법 출력 헷갈리지 않으려고 엔터넣음
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.print(arr[0] + " ");
		System.out.print(arr[1] + " ");	
		System.out.print(arr[2] + " ");	
		System.out.print(arr[3] + " ");	
		System.out.print(arr[4] + " ");	
		
		
		
		
	}

}
