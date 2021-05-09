package day9;

public class CardGame1_1 {

	public static void main(String[] args) {	// boolean 안쓸순없나?ㅠㅠ
		/*배열에 같은 숫자 3개가 있는지 없는지 알려주는 코드를 작성하세요.
		 * */

		int arr[]=new int [] {1,1,1,1,3,4,5};
		int count=1;
		boolean res = false;
		
		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;

			}else {
				if(count==3) {
					res=true;
				}
				count=1;
			}
		}
		if(count==3) {
			res=true;
		}if(res) { //res가  if문이니깐 true인 상태에서 작동하는거임
			System.out.print("트리플 있음");
		}else {
			System.out.print("트리플 없음");
		}
		

		
	}

}
