package day8;

import java.util.Scanner;

public class day7_Lotto {

	public static void main(String[] args) {
		/* 사용자 번호를 랜덤으로 생성하고, 당첨 번호를 입력하면 당첨 당첨 등수를 출력하는 코드를 작성하세요.
		 * - 사용자 번호 : 1~45 사이의 수, 중복되지 않음, 6개
		 * - 당첨 번호 : 1~45사이의 수, 중복되지 않음, 6개 + 1개(보너스 번호)
		 * - 1등 : 당첨번호 6개 일치
		 * - 2등 : 당첨번호 5개 + 보너스 번호 일치
		 * - 3등 : 당첨번호 5개 일치
		 * - 4등 : 당첨번호 4개 일치
		 * - 5등 : 당첨번호 3개 일치
		 * - 꽝 : 당첨번호 2개 이하 
		 * */

		// 자동생성 번호를 만듬
		int []user = new int[6];
		int min=1, max=45;
		init(user, min, max);	//자동으로 번호 생성하는 메소드 
		for(int tmp : user) {
			System.out.print(tmp + " ");	//당첨번호 확인하기위해서 출력중
		}
		System.out.println();
		
		// 당첨 번호를 입력
		int []lotto = new int[6];
		int bonus;
		Scanner scan= new Scanner(System.in);
		System.out.print("당첨번호 6개를 입력하세요: ");	//안내문구
		for(int i=0 ; i<lotto.length; i+=1) {
			lotto[i]=scan.nextInt();			//로또 번호 입력
		}
		System.out.print("보너스 번호를 입력하세요: ");
		bonus = scan.nextInt();					//보너스 번호 입력
		
		scan.close();
		//당첨 등수 확인 - 메소드 만들어
		printRank(user, lotto, bonus);
		
		
	}
	public static boolean contains(int[]arr, int count, int num) {
		for(int i=0; i<count; i+=1) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	/* 기능 : 배열 arr가 주어지며 주어진 배열에 min~max사이의 랜덤한 수를 생성하여 중복되지 않게 저장하는 메소드
	 * 매개변수 : 배열arr, 랜덤 범위(min~ max)=> int[]arr, int min, int max  
	 * 리턴타입 : 없음 => void
	 * 메소드명 : init 
	 * */
	public static void init(int []arr, int min, int max) {
		int cnt=0;
		while(cnt < arr.length) { 
			int r = (int)(Math.random()*(max-min+1)+min);  
			if(!contains(arr,cnt,r)) {
				arr[cnt] = r;
				cnt+=1;
			}
		}
	}
	/* 기능    : 두 배열이 주어지면 두 배열에서 같은 숫자가 몇개인지 알려주는 메소드
	 * 매개변수 : 두 배열 => int []arr1, int []arr2
	 * 리턴타입 : 같은 숫자의 개수 => 정수 => int
	 * 메소드명 : getSameCount
	 * */
	public static int getSameCount(int []arr1, int []arr2) {	//arr1에있는 숫자 꺼내서 arr2에 있는지 없는지 확인할 예정
		//같은 숫자 몇개있는지 확인하기 위한 메소드 만들기
		int cnt = 0;
		for(int tmp:arr1) { //arr1에있는 걸 tmp에 저장
			if(contains(arr2, arr2.length, tmp)) {
				cnt+=1;
			}
		}
		return cnt;
	}
	/* 기능    : 자동생성번호와 당첨번호, 보너스번호가 주어지면 몇등인지 알려주는 메소드
	 * 			단, 꽝은 0등으로 표현
	 * 매개변수 : 자동생성번호, 당첨번호, 보너스 번호
	 * 			=>int []user, int []lotto, int bonus
	 * 리턴타입 : 당첨 등수 => 정수 => int 
	 * 메소드명 : rank
	 * */
	public static int rank (int []user, int []lotto, int bonus) {
		int res=0;
		int count=getSameCount(user, lotto); //switch안에 getSameCount들어가도돼는데 변수에 담아서 표현하겠다고 이렇게 함.
		switch(count) { //같은 숫자의 갯수를 알려주는 게 와야함. switch 괄호 안에 값이나, 식이 와야 돼.
		case 6: res=1;	break;
		case 5: //보너스번호 맞았는지 아닌지에 따라서 2등 3등이 나눠짐
			if(contains(user, user.length, bonus)) {
				res=2;
			}else {
				res=3;
			}
			//res = contains(user, user.length, bonus)? 2:3; //조건선택연산자가 조건문이 간단한 경우에 이렇게 사용할수 있음 if, else를 한줄로 이렇게 넣을 수 있음.
			break;
		case 4: res =4;	break;
		case 3: res =5; break;
		//case 2,1는 기본 0으로 들어간대. int res 선언할때 0으로 초기값을 넣어놔서
		}
		
		return res;  
	}
	/* 기능    : 자동생성 번호와 당첨번호, 보너스번호가 주어지면 당첨등수를 출력하는 메소드
	 * 매개변수 : 자동생성 번호, 당첨번호, 보너스번호 
	 * 			=> int []user, int []lotto, int bonus
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int []user, int []lotto, int bonus) {
		int rank = rank(user, lotto, bonus);
		switch(rank) {
		case 1,2,3,4,5:
			System.out.println(rank + "등 입니다.");
			break;
		default:	//따로 출력해야하니까 하나 만들어줘야 돼.
			System.out.println("꽝입니다.");
		}
	}
}
