package day5;

public class While2 {

	public static void main(String[] args) {
		// while문과 continue를 이용한 짝수 출력 예제
		int i=1, num=10;
		while(i<=num) {
			if(i%2!=0) {
				i+=1;
				continue;
			}
			System.out.print(i+" ");
			i+=1;
		}
		
		
		i=0;
		while(++i<=num) {  //전위형증가코드로 조건식에 넣어놔서 따로 1씩증가한다는 변수를 넣지 않아도 돼.
			if(i%2 !=0) {
				continue;
			}
			System.out.println(i + " ");
		}
		
		
		
		
		
		

	}

}
