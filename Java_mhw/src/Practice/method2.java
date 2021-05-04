package Practice;

public class method2 {

	public static void main(String[] args) {

	int []arr= new int[]{1,2,3,4,5};	
	printArray (arr);
	
	initArray (arr,0);
	printArray(arr);
	
	}
	/* 기능   : 정수 배열에 있는 모든 원소값을 출력하는 메소드 => sysout
	 * 매개변수: 정수 배열 => int [] arr 또는 int arr []			//타입은 꼭 앞에 써줄 것 
	 * 리턴타입: 없음 => void
	 * 메소드명: printArray 
	 * */
	public static void printArray(int []arr) {
		for(int tmp : arr) {
			System.out.print(tmp);

		}
	}
	/* 기능   : 배열에 지정된 정수로 모두 초기화하는 메소드
	 * 매개변수: 배열, 지정된 정수 => int []arr1, int num
	 * 리턴타입: 없음	//뭘돌려줄 필요가 없음. 초기화만하고 끝내면 됨.
	 * 메소드명: initArray 
	 * */
	public static void initArray(int []arr, int num) {
		if(arr==null) {
			return;
		}
		
		for(int i=0; i<=arr.length-1; i+=1) {
			arr[i]=num;
		}
	}
	
}
