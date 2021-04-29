package day4;

public class For15 {

	public static void main(String[] args) {
		/*100이하의 모든 소수를 출력하는 코드를 작성하세요. 
		 * 2 3 5 7 11 13 17 19 ...
		 * 기존 소수 판별 예제에서 출력 부분을 수정
		 * => 소수이면 num를 출력하고 아니면 아무것도 안함.
		 * */ 

		//100이하 소수구하기 => 1부터 하나씩 올리면서 1하고 num만으로 나눠서 성공하면됨 = 그 값을 출력 
		
		int num = 5, i , cnt = 0;
		
		for(num=1; num<=100; num+=1) {
			for(i=1,cnt=0; i<=num; i+=1) {
				if(num % i== 0) {
					cnt +=1;
				}
			}
			if(cnt==2) {
				System.out.print(num+ " ");
			}
		
		}
		
		
		
		
	}

}
	