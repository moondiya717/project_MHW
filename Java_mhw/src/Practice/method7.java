package Practice;

public class method7 {

	public static void main(String[] args) {
		
		int []arr= new int[]{1,2,3,4,5};
		int num=3;
		System.out.println(contains(arr, num, arr.length)); //arr.length를 다른 숫자로 넣으면 거기까지만 확인함.
		System.out.println(contains(arr, num, 2)); //배열 1,2까지만 2개를 확인하니깐 없다고 함.

		
		//initRandomArray(arr, 1, 9);
		
		initRandomArray2(3,1,9);

		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		
	}
	/* 기능 : 배열이 주어지고, 주어진 배열에서 0번지부터 count개까지 확인하여 정수 num가 있는지 없는지 확인하는 메소드
	 * 		(배열에 정수 num가 있는지 중복체크)
	 * 매개변수 : 주어진 배열([1,2,3,4,5], 배열 int []arr, 중복확인 대상인 int num, 갯수 int count 
	 * 리턴타입 : 있는지 없는지 => 참 또는 거짓 => boolean
	 * 메소드명 : contains
	 * */
	public static boolean contains(int []arr, int num, int count) {
		//예외처리 : 배열의 크기보다 count가 큰 경우
		if(arr.length < count) {	
			count=arr.length;
		}
		//배열의 값과 num의 값이 같은 경우(=중복된 경우)
		for(int i=0;i<count;i+=1) {
			if(arr[i]==num) {
				return true; //다확인할필요없이, 중간에 찾으면 찾자마자 알려줌
			}
		}
		return false; //중복X
	}
	/* 기능 : 배열에 랜덤한 수를 생성하여 저장하는 메소드
	 * 매개변수 : 배열, 랜덤한 수를 만들기위한 범위=> int []arr, int min, int max, 
	 * 리턴타입 : 없음
	 * 메소드명 : initRandomArray 
	 *  */
	public static void initRandomArray(int []arr, int min, int max){
		//예외 처리1 : 배열이 없는 경우
		if(arr==null) {
			return;	//종료
		}
		//예외 처리2 : min과 max가 바뀐 경우
		if(min>max) {
			int tmp = min;
			min=max;
			max=tmp;
		}
		//예외처리3: 랜덤 범위의 갯수가 배열의 크기보다 작은 경우
		if(max-min+1<arr.length) {/*랜덤범위갯수*/
			return;
		}
		//배열에 랜덤으로 수를 생성하여 저장(중복 제거)
		int cnt = 0; //저장된 수
		while(cnt<arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min); //랜덤한 수가 같았을때, 중복될 수 있음(중복제거를 안했기때문에)
			//if 중복체크 후, 중복되지 않으면 저장
			if(!contains(arr,r,cnt)) { //중복되지 않으면 false
				arr[cnt]=r; //0번지에 r저장하고
				cnt+=1; //번지를 하나씩 올려서 중복아닌 숫자를 저장해라
			}
			
		}
	}
	public static int[] initRandomArray2(int size, int max, int min) { //배열에 랜덤으로 수가 중복되지않게 수정
		int[]arr=new int[size]; //size개 만큼의 배열을 생성하겠다.

		//예외 처리2 : min과 max가 바뀐 경우
		if(min > max) { //두 수를 바꿀 때, tmp라는 새로운 변수 1개가 필요함(그래야 두 수를 잃지 않고 값을 바꿈)
			int tmp = min;
			min = max;
			max = tmp;
		}
		//배열에 랜덤으로 수를 생성하여 저장(중복 제거)
		int cnt=0; //배열에 저장된 수의 갯수
		while(cnt<arr.length) {
			int r= (int)(Math.random()*(max-min+1)+min); //랜덤한 수가 같았을때, 중복될 수 있음(중복제거를 안했기때문에)
			//if 중복체크 후, 중복되지 않으면 저장
			if(!contains(arr,r,cnt)) { //중복되지않으면
				arr[cnt]=r;
				cnt+=1;
			}
		}
		return arr;

	}

}
