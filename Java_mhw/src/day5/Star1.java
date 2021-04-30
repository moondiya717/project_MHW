package day5;

public class Star1 {

	public static void main(String[] args) {

		/* 
		 * ***** 	k=1	*=5개  //별이 4개가 되면 처음 for가 아니라 안에 속한 for에 조건값을 수정해야돼
		 * ***** 	k=2	*=5개
		 * ***** 	k=3	*=5개
		 * ***** 	k=4	*=5개
		 * ***** 	k=5	*=5개
		 */
		
		
		int i, k;
		for(k=1; k<=5; k+=1) {
			for(i=1; i<=4; i+=1) {
				System.out.print("*");
			}
				System.out.println();
			
		}
		
	System.out.println("----------");
		
		/* 
		 * * 			k=1	*=개  
		 * **			k=2	*=개
		 * *** 			k=3	*=개
		 * **** 		k=4	*=개
		 * ***** 		k=5	*=개
		 */
		
		
		//이게 별 하나씩 늘어날라면 k가 숫자가 1씩 올라가니까 k개로 for안의 이중for문의 조건값을 k개로 적어주면 되는거래
		for(k=1; k<=5; k+=1) {
			for(i=1; i<=k ; i+=1 ) {
				System.out.print("*");
				
			} System.out.println();
		}
		
		System.out.println("----------");		
		
		/* 별 앞에공백 4칸 넣기
		 *     **** 	공백4	*=4개  
		 *     **** 	공백4	*=4개
		 *     **** 	공백4	*=4개
		 *     **** 	공백4	*=4개
		 *     **** 	공백4	*=4개
		 */
		
 //아니 밑에거를 for > for > for로 쓰면 되는건데 .. 나는 그냥 추가해ㅓ렸ㄴ.....
		for(k=1; k<=5; k+=1) {
			for(i=1; i<=1; i+=1) {
				System.out.print("    ");
				System.out.print( "****");
			}
				System.out.println();
			
		}
	
		
		System.out.println("----------");
		
		/*     *		k=1		공백4		* 1개	
		 *    **		k=2		공백3		* 2개
		 *   ***		k=3		공백2		* 3개
		 * 	****		k=4		공백1		* 4개
		 * *****		k=5		공백0		* 5개
		 * 						공백=5-k
		 * 	 */
		
		for(k=1; k<=5; k+=1) { 					//총 줄이 다섯개
			for(i=1; i<=5-k ; i+=1 ) {			//공백출력
				System.out.print(" ");		
			}
			for(i=1; i<=k; i+=1) {		
				System.out.print("*");		//별출력, i가 중요한 정보를 담고있는게아니고 앞에서 i이용 다 끝내서 반복횟수를 말하는 것 뿐이니까 초기화가능.
			} 
			
				System.out.println();			//엔터
		}
		
		
		
		
		
	}

}
