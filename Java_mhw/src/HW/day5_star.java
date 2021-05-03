package HW;

public class day5_star {

	public static void main(String[] args) {
	
		
		
		//별의 갯수는 1, 3, 5, 7, 9 개
		
		/*
		 *     *		
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 * 
		 * */
								
		//줄 5줄(1 2 3 4 5) 	&  공백 4 3 2 1 0 	& 	별 1 3 5 7 9  => 1(우측필요0) 2(1) 3(2) 4(3) 5(4)
		
		int i, j;
		for(i=1; i<=5; i+=1) {
			for(j=5; j>=1+i ; j-=1) {
				System.out.print(" ");
				}if(i-1!=0) {
					for(j=1; j<=i-1; j+=1) {
						System.out.print('*');
					}
				}
			for(j=1; j<=i ; j+=1) {
				System.out.print('*');
			}System.out.println();
		}
		
		
		
System.out.println("-----------");		
		
		
		/*  *********
		 *   *******
		 *    *****
		 *     ***
		 *      *
		 * */
		
				// 5줄(1 2 3 4 5) & 공백 0 1 2 3 4 & 별 9 7 5 3 1 
		
		for(i=1; i<=5; i+=1) {					// i 커지는 중 12345 
			for(j=1; j<=i-1; j+=1) {			// j 	     01234
				System.out.print(" ");
			}	
				
			for(j=0; j<=5-i; j+=1) {				//별 	54321 9 7 5 3 1
				System.out.print('*');
			}
			
			for(j=1; j<=5-i ; j+=1) {
				System.out.print('*');					// 43210 별더하기
			}System.out.println();
		}
		
		
	
	}

}
