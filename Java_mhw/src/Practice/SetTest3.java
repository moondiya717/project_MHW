package Practice;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest3 {

	public static void main(String[] args) {
		/* 중복되지 않은 6개의 수를 랜덤으로 생성하여 저장한 후, 출력하는 코드를 작성하세요. 
		 * 단, 순자의 범위는 1~45 */

		Integer min=1, max=45;
		HashSet<Integer> randomNum= new HashSet<Integer>();
		
		while(randomNum.size()<6) {
			randomNum.add((int)(Math.random()*(max-min+1)+min));
		}
		System.out.print("랜덤으로 생성된 6개의 숫자: ");
		Iterator<Integer> num = randomNum.iterator();
		while(num.hasNext()) {
			System.out.print(num.next()+" ");
		}
	}
}
