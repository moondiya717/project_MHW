package Practice;

import java.util.Scanner;


public class test4 {

	public static void main(String[] args) {
		/*학생 3명의 성적을 입력 받은 후 총점과 평균을 출력하는 코드를 작성하세요.*/

		int []arr = new int[3];
		int i, sum=0;
		Scanner scan=new Scanner(System.in);
		
		for(i=0; i<arr.length; i+=1) {
			System.out.print("학생의 성적을 입력하세요: ");
			int num=scan.nextInt();
			arr[i]=num;			
		}
		for(i=0; i<arr.length; i+=1) {
			sum+=arr[i];
		}	
		System.out.print("총점: " + sum);
		System.out.print("평균: "+ (double)(sum/arr.length));


		
		
		
	}

}
