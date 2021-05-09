package Practice;

public class cardgame1_4 {

	public static void main(String[] args) {
		/* 카드 게임: 실제 포커 게임은 모양과 숫자를 다 고려해야하지만 
		 * 			여기에선 숫자만 고려, 카드는 7장
		 * 			카드는 1~13이 4개씩(하트, 다이아, 세잎, 스페이스)
		 * 센 순서대로, 숫자 확정되면 밑에껀 확인할 필요없음.
		 * 1 포커		: 같은 숫자가 4개 
		 * 2 풀하우스 	: 트리플1 + 페어1(투페어) 또는 트리플2
		 * 3 스트레이트	: 연속된 숫자가 5개이상
		 * 4 트리플		: 같은 숫자가 3개
		 * 5 투 페어		: 같은 숫자가 2개씩 2개=> 페어가 2개
		 * 6 페어		: 같은 숫자가 2개
		 * 7 탑			: 위의 모든 조건이 없는 가장 큰 수
		 * */
		int []arr=new int[]{1,2,3,4,5,7,8};
		
		System.out.println("포커인 숫자: " + poker(arr));

//		int tmp[] = tripleList(arr);
//		System.out.print("트리플리스트: ");
//		for(int t: tmp) {
//			System.out.print(t+" ");
//		}
		
		System.out.println("트리플인 숫자: "+ triple(arr));
		
		
		int tmp[] = pairList(arr);
		System.out.print("페어인 숫자: ");
		if(tmp!=null) {
			for(int i=0; i<tmp.length; i+=1){
				System.out.print(tmp[i]+ " ");
			}
		}else{
			System.out.print("없음");
		}
	
}
	/* 포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능    : 주어진 배열에서 포커(같은 숫자가 4개)인 수를 찾아 수를 출력하고 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 => int card[]
	 * 리턴타입 : 정수 => int 
	 * 메소드명 : poker
	 * */
	public static int poker(int []card) {
		
		int count=1;
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {
				count+=1;
				if(count==4){
					return card[i];
				}
			}else {
				count=1;
			}
		} return 0;
	}	

	/* 트리플을 확인할 수 있는 메소드를 정리해보세요. 
	 * 트리플이 있다면 해당 트리플의 숫자를 확인할 수 있는 메소드를 만들어야 합니다.
	 * 
	 * 기능    : 배열에 트리플이 있으면 해당 트리플의 숫자를 확인할 수 있는 메소드, 없으면 null을 알려줌.
	 * 매개변수 : int []card
	 * 리턴타입 : int[] => 7개 카드에 트리플 가능 2개니까 배열로 알려줘야 함
	 * 메소드명 : tripleList
	 * */
	public static int[] tripleList(int []card){
		int triple[]= new int[2];
		int res=0;
		int num=0;
		int count=1;
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {
				count+=1;
				num=card[i];
			}else{
				if(count==3){
					triple[res]=num;
					res+=1;
				}
				count=1;
			}
		}	
		if(count==3) {
			triple[res]=num;
			res+=1;
		}
		if(res==0) {
			return null;	
		}else if(res==2){
			return triple;
		}else {
			int []tmp = new int[1];
			tmp[0]=triple[0];
			return tmp; //트리플이 1개만 있을때 배열2개짜릴 보내는게 아니라 1개짜리를 만들어서 전달(1개라고해서 변수로 전달하면 안돼)
		}

	}
	
	/* 트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능    : 배열에 트리플이 있으면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드, 트리플이 2개인 경우=> 트리플X
	 * 매개변수 : int []card
	 * 리턴타입 : int
	 * 메소드명 : triple
	 * */
	public static int triple(int []card) {
		int[] res = tripleList(card);
		
		if(res==null || res.length==2) {
			return 0;
		}else {
			return res[0];			
		}
	}
	
	/* 페어를 확인할 수 있는 메소드를 정리해보세요. 페어가 있다면, 해당 페어의 숫자들을 알려주고 
	 * 없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 * 
	 * 기능    : 주어진 배열에서 같은 숫자가 두개(페어)이면, 숫자를 알려주고 없으면 null을 알려줌. 
	 * 매개변수 : 배열 => int []card
	 * 리턴타입 : 페어인 숫자들(최대3개 가능) => int[] 
	 * 메소드명 : pairList
	 * */
	public static int[] pairList(int []card) {
		int count=1;
		int num=0;
		int res = 0;
		int pair[] = new int[3];
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {
				count+=1;
				num=card[i];
				
			}else{
				if(count==2) {
					pair[res]=num;
					res+=1;
				}
				count=1;
			}
		}
		if(count==2) {	//마지막 끝에 두 숫자가 pair인 경우
			pair[res]=num;
			res+=1;
		}
		//null
		//[1,0,0]페어가 1개일때 => [0]
		//[1,2,0]페어 2개일때 => [0,0] => 뒤에 0들이 보기가 어려우니까 밑에서 뗀 작업을 함
		//[1,2,3]페어가 3개일때  => 그냥 나와도됨.
		if(res==0) {	//0개짜리
			return null;
		}else if(res<3) {	//1,2개짜리
			int []tmpArr = new int[res]; //페어(res)갯수만큼
			for(int i=0; i<tmpArr.length; i+=1) {
				tmpArr[i]=pair[i];
			}
			return tmpArr;
		}
		return pair;	//3개짜리 
	}
	
	/* 원페어를 확인할 수 있는 메소드를 정리해보세요
	 * 기능    : 주어진 배열에서 1 페어만을 찾아서 그 숫자를 보여주는 메소드
	 * 매개변수 : 배열
	 * 리턴타입 : 페어인 숫자 => 정수=> int
	 * 메소드명 : onePair
	 */
	
}