package day9;

public class CardGame2_2 {

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
		
		/*<day9 주말숙제>
		 * 카드가 주어지면 해당 카드의 가장 큰 등급을 출력하는 코드를 작성하세요.
		 * 아래와 같이 풀하우스, 트리플, 페어로 판별 가능한 경우, 풀하우스 하나만 출력
		 * 1 1 1 2 2 7 8 일때 => "1풀하우스 입니다"라고 출력
		 * */
		

		int []arr=new int[]{1,1,1,2,2,7,8};
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
				System.out.print(triple[i]+" ");
			}
			System.out.println();
		}
		
		
		
		
		System.out.println("포커인 숫자: " + poker(arr));
		
//		int []tmp = tripleList(arr);
//		System.out.print("트리플리스트: " );
//		for(int t: tmp) {
//			System.out.println(t + " ");
//		}
		
		System.out.println("트리플인 숫자: "+ triple(arr));
		
		System.out.print("페어인 숫자: ");
		int []tmp = pairList(arr);
		if(tmp!=null) {
			for(int i = 0; i< tmp. length; i+=1) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
		}else {
			System.out.println("페어없음");
		}
		
		
		
		System.out.println("원페어: " + onePair(arr));
		
		System.out.print("투페어: ");
		int []res2 = twoPair(arr);
		if(res2==null) {
			System.out.println(0);
		}else {
			for(int tmp2:res2) {
				System.out.print(tmp2 + " ");
			}
		}
		System.out.println("풀하우스: " + fullHouse(arr));
		
		System.out.println("스트레이트: " + straight(arr));
		
		
		
	}
	
	/* 포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능	  : 배열이 주어지면 배열에 포커(7장 카드 중 같은 숫자 4개)가 있는지 확인하여 있으면 해당 숫자를, 없으면 0을 알려주는 메소드
	 * 매개변수 : 숫자가 나열된 배열 => int []card
	 * 리턴타입 : 같은 카드가 4장인 숫자=>정수=> int 
	 * 메소드명 : poker
	 *  {1,2,3,7,7,7,7}*/
	public static int poker(int []card) {
		
		int count=1;
		int num=0;
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i] == card[i+1]) {
				count+=1;
				if(count ==4) {
					return card [i];
				}
			}else {
				count=1;
			}
		}
		
		return 0;
	}
	
		
	/* 트리플을 확인할 수 있는 메소드를 정리해보세요. 
	 * 트리플이 있다면 해당 트리플의 숫자를 확인할 수 있는 메소드를 만들어야 합니다.
	 * 
	 * 기능    : 배열에 트리플이 있으면 해당 트리플의 숫자를 확인할 수 있는 메소드, 없으면 null을 알려줌.
	 * 매개변수 : 트리플을 확인할 배열 int []card
	 * 리턴타입 : 트리플의 숫자들 => 정수 배열 => int[] //정수로할순있지만 작업이 복잡
	 * 메소드명 : tripleList
	 * */
	public static int[] tripleList(int []card) {
	
		int count=1;
		int res = 0;
		int []triple=new int[2];
		int num=0;	
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {
				count+=1;
				num=card[i];
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
		if(res==0) {	//트리플이 없으면
			return null;
		}else if(res ==2){
			return triple;
		} else {
			int []tmp = new int[1];
			tmp [0] = triple [0];
			return tmp;	//트리플이 1개만 있을때 배열2개짜릴 보내는게 아니라 1개짜리를 만들어서 전달(1개라고해서 변수로 전달하면 안돼)

		}

	}
	
	
	/* 트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능    : 배열에 트리플이 있으면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드, 트리플이 2개인 경우=> 트리플X
	 * 매개변수 : 배열 => int []card
	 * 리턴타입 : 트리플인 숫자 => 정수 => int
	 * 메소드명 : triple
	 * 
	 * */
	public static int triple (int []card) {
		int [] res = tripleList(card);
		
		//트리플이 아닌 경우
		if(res == null || res.length ==2) {
			return 0;
		}
		return res[0];
	}

	/* 페어를 확인할 수 있는 메소드를 정리해보세요. 페어가 있다면, 해당 페어의 숫자들을 알려주고 
	 * 없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 * 
	 * 기능    : 주어진 배열에서 같은 숫자가 두개(페어)이면, 숫자를 알려주고 없으면 null을 알려줌. 
	 * 매개변수 : 배열 => int []card
	 * 리턴타입 : 페어인 숫자들 => int[] 
	 * 메소드명 : pairList
	 * */
	public static int[] pairList (int []card) {
		int []pair=new int[3]; //페어의 숫자
		int count=1;
		int num=0;
		int res=0; //페어의 갯수
		
		for(int i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {
				count+=1;
				num=card[i];
			}else {
				//페어이면
				if(count==2) {
					pair[res]=num;
					res +=1;
				}
				count=1;
			}
		}
		if(count==2) {	//마지막 끝에 두 숫자가 pair인 경우
			pair[res] = num;
			res+=1;
		}
		if(res==0) {
			return null;
		}else if(res<3) {	//배열 갯수에 맞춰 새로 만들어줌 
			int []tmpArr = new int[res];
			for(int i=0 ; i<res; i+=1) {	//트리플이랑 다름, 페어는 2개를 같이보내줘야 해서
				tmpArr[i] = pair[i];
			}
			return tmpArr;
		}
		return pair;
		
	}

	/* 원페어를 확인할 수 있는 메소드를 정리해보세요
	 * 기능    : 주어진 배열에서 1 페어만을 찾아서 그 숫자를 보여주는 메소드
	 * 매개변수 : 배열
	 * 리턴타입 : 페어인 숫자 => 정수=> int
	 * 메소드명 : onePair
	 */
	public static int onePair(int []card) {

		int [] res=pairList(card);
		if(res !=null && res.length ==1) {
			return res [0];
		}
		return 0;
	}
	
	/* 투페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능    : 배열에 투페어가 있으면 해당 페어 숫자들을, 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 => int []card
	 * 리턴타입 : 페어 숫자들 => 정수 배열 => int[]
	 * 메소드명 : twoPair
	 * */
	public static int[] twoPair(int []card) {
		int []res = pairList(card);
		
		if(res==null || res.length ==1){
			return null;
		}
		return res;
	}
	
	/* 풀하우스를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능    : 풀하우스가 있으면 풀하우스 숫자를 없으면 0을 알려주는 메소드 (트리플1 + 페어1(투페어) 또는 트리플2이 있으면 해당 숫자를 알려주고 없으면 null)
	 * 			2 2 2 3 3 4 5 => 2풀하우스
	 * 			2 2 2 9 9 9 10 => 9풀하우스
	 * 매개변수 : 주어진 배열 => int[]card
	 * 리턴타입 : 풀하우스 숫자 => 정수 => int 
	 * 메소드명 : fullHouse
	 *  */
	public static int fullHouse(int []card) {
		
		int [] triple = tripleList(card);
		//트리플이 없으면 풀하우스가 될 수 없기 때문에 0을 리턴

		if(triple == null) {
			return 0;	//메소드 종료( 여길 지나서 밑으로 내려가면, null이 아니라는 뜻)
		}
		//트리플이 2개이면 풀하우스
		//tripleList를 이용
		//1,1,1,2,2,3,3,
		if(triple.length == 2) {	
			if(triple[0] > triple[1]) {			//더큰수를 보내?뭘보내?
				return triple[0];
			}
			return triple[1];
			
		}
		
		//트리플이 아닌 경우
		//트리플이 2개가 아니면
		//트리플이 1개, 페어가 1개이상이면 풀하우스 
		//triple과 pairList를 이용 (onepair 쓸수도있찌만 숫자가 11112233일때 2233을 인식못함 =>슬라면 onepair+twopair해야돼)
		int []pair = pairList(card);
		if(pair != null) {	//없지않으면 = 하나라도 있으면
			return triple[0];	//트리플 값을알려주고
		}
		
		//아니면 풀하우스가 아님
		return 0;		//종료
		
	}
		
	/* 스트레이트를 확인할 수 있는 메소드를 정리해보세요.
	 * (원래는 마운틴이라고해서 10, 11, 12, 13, A(14)가 있는데, 여기에서는 제외),
	 * (백스트레이트라고해서 1,2,3,4,5가 있는데 여기서는 5스트레이트로 판단)
	 *
	 * 기능    : 배열에 스트레이트(연속된 숫자)가 있으면 스트레이트 중 가장 큰 수를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 => int []card
	 * 리턴타입 : 스트레이트 중 가장 큰 수 => 정수=> int
	 * 메소드명 : straight
	 * */
	public static int straight(int []card) {
		int count=0;
		int tmp =0;
		int i;
		int num=0;
		//배열에서 연속된 숫자가 있는지 확인하기 4번 이상이면 됨
/*		for(i=0; i<card.length-1; i+=1) {	//2개의 수씩 비교해서 card.length-1 인데 (현재1,2,3,4,5,6,7 배열은 7개짜리라ㅓ -1인데 <작아서 5까지가 i의 최대임
			if(card[i]+1==card[i+1]) {		//i의 수는 5까지가 최대지만, 0부터 시작했기때문에 최고 갯수가 6개
				count+=1;					//카운트 늘리고나서 if안에다가 tmp=card[i]를 저장하라고 하면 연달아 숫자가 올라가다가
											// 마지막에 하나 다를때 조건이false라 else로 가서 count를 초기화 시켜버리기때문에 else 밑에다가 if카운트 tmp저장을 씀
			}else {
				if(count>=4) {
					tmp=card[i];
				}
				count=1;
			}
		}
		if(count>=4) {						//else로 내려가지않고 연달아 숫자가 올라가다가 끝난경우는 tmp로 저장이 되지 않았기때문에 for문이 끝난 뒤에 한번 더 체크해줘야 함.
			tmp=card[i];
		}
		return tmp;
	} */
		
		for(i=0; i<card.length-1; i+=1) {
			if(card[i]==card[i+1]) {	//1 2 2 3 4 5 6 인경우, 앞에 22때문에 판별이안될까봐 숫자같은 경우를 건너뜀.
				continue;
			}
			if(card[i] +1 == card[i+1]) {
				count +=1;
				num = card[i+1];
			}else {
				if(count >=5) {
					return num;	//이미 앞에 5개가 연속이고, 그 뒤는 연속이아니라 else로 왔기때문에 7장 중에 더이상 스트레이트가 없음
				}
				count =1;
			}
		}
		if(count >=5) {	// 마지막까지 연속으로 끝난 경우는 위에서 return 없이 끝나버리기때문에 밑에서 체크해서 값을 알림.
			return num;
		}
		return 0;
	}
}
