package Practice;

import java.util.Scanner;

public class baseball {

	public static void main(String[] args) {
		
		int []com = new int[3];//컴퓨터가 랜덤으로 생성한 숫자를 저장하는 배열
		int []user = new int[3];//사용자가 입력한 숫자를 저장하는 배열
		int strike=0;//스트라이크 갯수
		int ball;//볼의 갯수
		int cnt = 0;//컴퓨터가 랜덤으로 생성한(중복되지 않은) 숫자를 배열에 저장한 갯수
		int min = 1, max = 9;//랜덤 숫자 범위
		int r;//랜덤으로 생성한 숫자를 저장할 변수
		int i, k; //반복문에서 사용할 변수
		boolean isDuplicated; //배열에 중복된 값 있는지 확인
		
		
		//컴퓨터가 랜덤으로 중복되지 않은 세 수를 생성(랜덤으로 만들고 숫자가 중복안되야해서 횟수가 정해진 것이 아님)
		//배열에 3개 저장될 때까지 반복
		while(cnt<3) {
			//min~max 사이의 랜덤한 숫자를 생성
			r = (int)(Math.random()*(max-min+1)+min);
			isDuplicated = false; //이자리 또는 for문 초기화 부분에 ,하고 넣어서 초기화를 해야한다. 밑에있는 for문 실행문에 넣으면 운나쁘면 숫자가 중복될때 무한루프에 빠짐.
			
			// 배열의 0번지부터 cnt(저장된 랜덤숫자)개 비교해서=>처음만들어지면 비교할 대상이 없으니 0개를 비교한다고 저장하는것. + 중복여부를 확인
			for(i=0; i<cnt; i+=1) {
				//중복체크하여 중복되면 중복했다고 저장
				//랜덤한 숫자와 배열의 i번지의 값이 같으면 isDuplicaed를 true로
				if(r == com[i]) {
					isDuplicated=true; //true는 계속 반복문을 반복하게 만들어. false는 중지
				}
			}
			
			//중복되지 않으면 배열에 저장 후, 저장한 갯수(cnt)를 1개 증가
			if(!isDuplicated) {
				com[cnt]= r;
				cnt+=1;
			}
		}
		
		//컴퓨터가 생성한 숫자를 출력(테스트용)
		for(i=0; i<cnt; i+=1) {
			System.out.print(com[i]+ " ");
		}
			System.out.println();
			
		Scanner scan = new Scanner(System.in);	//사용자가 세 수를 입력해야하니까 
		//게임을 시작해서 3스트라이크 나올때까지 반복
		do {
			//사용자가 3개 숫자를 입력(중복되지 않는다고 가정)
			System.out.print("입력하세요: ");
			for(i=0 ; i<3/*또는 user.length*/; i+=1) {
				user[i] = scan.nextInt();
			}
			
			//볼과 스트라이크 갯수를 셈.
			ball = 0;		
			strike = 0;
			//com배열과 user배열에서 같은 번지를 비교하여 같은 숫자가 있으면 strike를 증가
			for(i=0 ; i<cnt /*user.length라해도되고 숫자로 넣어도 되고*/ ; i+=1) {
				if(com[i] == user [i]) {
					strike +=1;
				}
			}
			//come배열과 user배열에서 다른 번지를 비교하여 같은 숫자가 있으면 ball증가
			//com[0]과 user[1], user[2]와 비교,
			//com[0]과 user[0], user[2]를 비교,
			//com[2]와 user[0], user[1]를 비교
			for(i=0; i<com.length; i+=1) {
				for(k=0; k<user.length; k+=1) {
					if(i==k) {
						continue; //같은 위치에 숫자가 있으면 S가 위에서 이미 걸러냈으니까 이건 할 필요가 없어. 다른위치에 같은숫자만 비교하면 됨.
					}
					if(com[i]==user[k]) {
						ball+=1;
					}
				}
			}
			
			//볼과 스트라이크와 아웃을 판별하여 출력
			//스트라이크는 0스트라이크가 아닐때 ?S출력
			if(strike!=0) {
				System.out.print(strike + "S");
			}
			//볼은 0볼이 아니면 ?B를 출력
			if(ball!=0) {
				System.out.print(ball + "B");
			}
			//볼이 0이고 스트라이크가 0이면 O를 출력
			if(ball==0 && strike ==0) {
				System.out.print("O");
			}
			//엔터
			System.out.println();
		}while(strike!=3);
		System.out.println("정답입니다.");
		
		
		
		
		scan.close();
	}

}
