package day11;

public class MethodTest {

	public static void main(String[] args) {

		int res = sum(1,2);
		System.out.println(res);	
		
		//System.out.println(print());	//return값이 없는데 println이 달라고하니까 오류가 남
		//int num = print();				//print 리턴타입이 void없는데 int num에 저장할라하니까 오류가 남. //int가 아니더라도 =을 기준으로 왼쪽 오른쪽 타입이 서로 다르면 안돼 
		print();	//걍이렇게 쓰면 sysout Hello가 바로 출력됨
		
		int []arr=new int[] {1,2,3,4,5};
		System.out.println(sum2(arr));			//sum2는 arr[]를 만들고 써야 함
		
		System.out.println(sum3(1,2,3));		//sum3는 배열 만들어도되고, 내가 직접 배열 값을 입력해도 됨
		System.out.println(sum3(1,2,3,4,5));
		
	}

	public static int sum( int num1, int num2) {
		return num1+num2;
	}
	public static void print() {
		System.out.println("Hello");
	}
	public static int sum2(int []arr) {
		if(arr==null) {							//배열만들고나서 배열이 비지 않았는지 sum3과 다르게 확인을 해줘야 함
			return 0;
		}
		int res=0;
		for(int tmp:arr) {
			res+=tmp;
		}
		return res;
	}
	//혼공자 (p.252)
		public static int sum3(int ...arr) {	//...를 사용해서 매개변수의 갯수를 모를때 자동으로 만들기 
		int res=0;
		for(int tmp:arr) {
			res+= tmp;
		}
		return res;
	}
}
