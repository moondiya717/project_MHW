package Practice;

public class cardcame {

	public static void main(String[] args) {
		/*배열에 같은 숫자 3개가 있는지 없는지 알려주는 코드를 작성하세요.
		 * */

		int arr[]=new int [] {1,1,3,3,3,4,5};
		int count=1;
		boolean res = false;

		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				count+=1;
			}else{
				if(count==3) {
					res=true;
				}
				count=1;
			}
		}	
			
		if(count==3) {
			res=true;
		}
		
	
		if(res==true) {
			System.out.print("트리플 있음");
		}else {
			System.out.print("트리플 없음");
		}
		
System.out.println("-------------");		
		/* 1-13까지의 숫자가 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 트리플인 숫자를 알려주는 코드를 작성하세요.
		 * 
		 * */
		int num=0;
		int triple[]=new int[2];
		int res1=0;
		int cnt=1;
		
		for(int i=0; i<arr.length-1; i+=1) {
			if(arr[i]==arr[i+1]) {
				cnt+=1;
				num=arr[i];
			}else{
				if(cnt==3){
					triple[res1]=num;
					res1+=1;
				}
				cnt=1;
			}
		}	
			
		if(cnt==3) {
			triple[res1]=num;
			res1+=1;
		}
		if(res1==0) {
			System.out.print("트리플 없음");	
		}else {
			for(int i=0; i<res1; i+=1) {
				System.out.print(triple[i]+" ");
			}
		}
	}
}
