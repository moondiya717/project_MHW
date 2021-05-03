package day6;

public class MethodEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = new int[] {1,2,3,4,5};
		printArray(arr); //public static 타입 뒤에있는 이름
		initArray(arr,0); //initarray 초기화
		printArray(arr); //printarray는 출력
		
	}
	/* 기능   : 정수 배열에 있는 모든 원소값을 출력하는 메소드 => sysout
	 * 매개변수: 정수 배열 => int [] arr 또는 int arr []			//타입은 꼭 앞에 써줄 것 
	 * 리턴타입: 없음 => void
	 * 메소드명: printArray 
	 * */
	public static void printArray(int []arr) {
		/*향상된 for문
		 * - 배열이나 컬렉션프레임워크
		 * - 전체를 탐색하는 경우
		 * - 배열의 값을 수정하는 것이 아니라 값을 가져와서 활용을 하는 경우에만 씀
		 * */
		for( int tmp : arr ) {		//왼쪽은 일반 변수 : 오른쪽은 배열
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
	/* 기능   : 배열에 지정된 정수로 모두 초기화하는 메소드
	 * 매개변수: 배열, 지정된 정수 => int []arr, int num
	 * 리턴타입: 없음	//뭘돌려줄 필요가 없음. 초기화만하고 끝내면 됨.
	 * 메소드명: initArray 
	 * */
	public static void initArray(int []arr, int num) {
		//예외 처리 - 배열이 생성이 안된 경우, 메소드를 종료 
		if(arr == null) {	//배열 생성안되어있으면,
			return;			//종료할 것. (return은 알려주면서 종료하는 역할을 함)
		}
		int i;
		for(i=0; i<arr.length; i+=1) {		//향상된 for문은 쓸 수 없음, 값을 초기화해야하는 수정이 일어나기 때문에
			arr[i]=num;
		}
	}
}
