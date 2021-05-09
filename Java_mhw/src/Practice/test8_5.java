package Practice;

public class test8_5 {

	public static void main(String[] args) {
		/* 10개짜리 배열에 1부터 10를 저장한 후 출력하는 코드를 작성하세요. 
		 * */
		int arr[]=new int[10];
		for(int i=0; i<arr.length; i+=1) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}
		
		
		
System.out.println();		
		/* 10개짜리 배열에 피보나치수열을 저장한 후 출력하는 코드를 작성하세요.
		 * 피보나치 수열
		 *  - 앞에 두 개를 더하여 나열함
		 *  - 0번지 : 1, 1번지 : 1 (고정)
		 *  - 저장 및 출력 값: 1 1 2 3 5 8 13 21 34 55
		 * 힌트 : arr[i] = arr[i-2] + arr[i-1]
		 * */
		
		int arrP[] = new int[10];
		arrP[0] = arrP[1] = 1;
		
		for(int i=2; i<=arrP.length-1; i+=1) {
			arrP[i]=arrP[i-2]+arrP[i-1];
		}
		for(int i=0; i<=arrP.length-1; i+=1) {
			System.out.print(arrP[i] + " ");
		}
		
		
		
		
System.out.println();		
		/* 5개짜리 배열에 저장된 숫자들중 연속된 숫자가 3개인지 아닌지를 확인하는 코드를
		 * 작성하세요. 단, 숫자들은 정렬되었다고 가정
		 * 예시 
		 * 입력 : 1 1 2 3 4
		 * 연속
		 * 예시 
		 * 입력 : 1 2 4 5 8
		 * 연속 아님
		 * 예시 : 1 3 5 6 7
		 * 연속  
		 * 뒤번지의 값과 1차이가 나면 count 변수를 1 증가, 
		 * 1차이가 나지 않으면 count를 1으로
		 * count가 3이되면(연속) 반복문 종료
		 * */

		int arr1[] = new int[] {1,2,2,2,4};
		int count=1;
		
		for(int i=0; i<arr1.length-1; i+=1) {
			if(arr1[i]==arr1[i+1]) {
				count+=1;
			}else{
				count=1;
			}if(count==3) {
				break;
			}
		}
		if(count==3) {
			System.out.print("연속");
		}else {
			System.out.print("연속 아님");
		}
	}
}