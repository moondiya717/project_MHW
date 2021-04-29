package day4;

public class Continue {

	public static void main(String[] args) {
		//
		
		int i;
		for( i = 1; i<=5; i+=1) {
			if(i==2) {
				continue; //continue는 실행으로 넘어가지않고 증감식으로 넘어가버림.
			}
			System.out.println(i);
			
		
			
			//이거 continue사용안하고 하는거라던데 나중에 확인해야지
			for( i = 1; i<=5; i+=1) {
				if(i!=2) {
				System.out.print(i);
				}

			}
			
		}

			
		}
		
		

	}


