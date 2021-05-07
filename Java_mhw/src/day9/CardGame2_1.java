package day9;

public class CardGame2_1 {  //2개씩나와

	public static void main(String[] args) {	// boolean 안쓸순없나?ㅠㅠ
		/* 1-13까지의 숫자가 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 트리플인 숫자를 알려주는 코드를 작성하세요.
		 * 
		 * */

		int []arr=new int[]{1,1,1,2,2,2,5};
		int count=1;
		int res = 0;
		int []triple=new int[2];
		int num=0;
		
		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
				num=arr[i];
			}else {
				if(count==3) {
					triple[res] = num;
					res+=1;
				}
				count=1;
			}
		}
		if(count==3) {
			triple[res] = num;
			res+=1;
		}
		if(res==0) {
			System.out.println("트리플 없음");
		}else {
			for(int i=0 ; i<res ; i+=1) {
				System.out.println(triple[i]+" ");
			}
			System.out.print(res);
		}
	}

}
