package Practice;

public class while2 {

	public static void main(String[] args) {
		// while문과 continue를 이용하여 1~10 사이의 짝수 출력 예제
		
		//방법1 
		int i=1, num=10;
		while (i<=num) {
			if(i%2==0) {
				System.out.print(i+ " ");
				i+=1;
			}else if(i%2!=0) {
				i+=1;
				continue;
			}
		}
		
System.out.print("---------");		
		
	//**While문은 for와 다르게 초기화가 없기때문에, 변수값을 새 코드만들때마다 넣어줘야 함(변수선언X).
		//방법2
		i=1;
		while(i<=num){
			if(i%2!=0) {
				i+=1;
				continue;
			}
			System.out.print(i + " ");
			i+=1;	//값을 올리지않으면 같은 i값에서 무한반복이 됨.
		}

		
	//방법3
		i=1;
		while(i++<=num) {		//++을 써서 자동으로 값을 올렸음.
			if(i%2==0) {
				System.out.print(i + " ");
			}else {
				continue;
			}
		}
		
		
		
		
		

	}

}
