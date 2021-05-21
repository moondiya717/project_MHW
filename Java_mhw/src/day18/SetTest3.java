package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest3 {
	
	public static void main(String[] args) {
		/* 중복되지 않은 6개의 수를 랜덤으로 생성하여 저장한 후, 출력하는 코드를 작성하세요. 
		 * 단, 순자의 범위는 1~45 */
		
		//필요한
		int min=1, max=45;
		HashSet<Integer> set = new HashSet<Integer>();
	
		//랜덤으로 6개 생성 1~45 => 중복되면안되고 => 순서는 상관없는 듯 
		while(set.size()<6) {
			//Integer num = (int)(Math.random()*(max-min+1)+min);
			//set.add(num);
			set.add((int)(Math.random()*(max-min+1)+min));	//위에두줄하나로하면 이렇게됨
		}
		
		// 출력
		System.out.print("랜덤으로 생성된 6개의 숫자: ");
		Iterator<Integer> it = set.iterator();	
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}
}
