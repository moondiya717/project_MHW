package day13;

import java.util.Scanner;

public class FigureTest {	//클래스의 형변환이 왜 필요한가를 이해하기 위한 예제

	public static void main(String[] args) {	//클래스형변환을 통해, 하나의 클래스로 관리를 해야하는 이유를 알아볼 예정

	// Rect이랑 Circle파일 출력할라고 불러온 값들인데 딴거한다고 숨겼음	
	//	Rect r = new Rect (167, 255, 278, 391);
	//		r.print();
			
	//	Circle c = new Circle (5,10,5);
	//		c.print();

		
		Figure []arr = new Figure[10];	//간단하게 하려고 배열10개짜리 넣은거임, 원랜 제한이 없게해야한대	
		int maxCount = 0;				//최대로 그린 도형의 갯수
		int pos = 0;					//현재 도형의 번호(되돌리기나 뒤로가기하면 갯수가 줄어드니까)
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("----------------------");
			System.out.println("1. 도형 그리기");
			System.out.println("2. 실행 취소");
			System.out.println("3. 다시 실행");
			System.out.println("4. 확인 하기");
			System.out.println("5. 종료 하기");
			System.out.println("----------------------");
			System.out.println("메뉴 선택 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:	
				System.out.println("그릴 도형을 선택하세요. (1.원, 2.사각형)");
				int selectFigure = scan.nextInt();
				switch(selectFigure) {
					case 1:
						System.out.println("중심점을 입력하세요(예: 10 10) : ");
						int x = scan.nextInt();
						int y = scan.nextInt();
						System.out.println("반지름을 입력하세요 : ");
						int r = scan.nextInt();
						arr[pos++] = new Circle(x,y,r); //다입력받고 객체만들기
						maxCount = pos;	//되돌리기하면 이전에 했던 작업을 날려야되니까 이 작업을 해줘야함
						break;
					case 2:
						System.out.println("좌상점을 입력하세요(예: 10 10) : ");
						int left = scan.nextInt();
						int up = scan.nextInt();
						System.out.println("우하점을 입력하세요(예: 10 10) : ");
						int right = scan.nextInt();
						int down = scan.nextInt();
						arr[pos++] = new Rect(left, up, right, down);		//후의? 증감연산자 덕분에 pos+=1; 또는 pos++ 대신에 
						maxCount = pos; 									//배열생성의 번지번호에 ++넣어서 반복할때 하나씩 자동으로 올릴 수 있음
						break;
					default:
						System.out.println("없는 도형입니다.");
				}
				break;
			case 2: 
				if(pos != 0) {	//없는데 뺄 순 없으니까 0아닌거 확인하기
					pos--;	
				}
				break;
			case 3: 
				if (pos < maxCount) {
					pos++;
				}
				break;
			case 4: 
				for(int i = 0; i<pos; i++) {
					arr[i].print();
				}
				break;
			case 5: 
				break;
			}
		}while(menu != 5);
		scan.close();
		//배열하나에 한번에 원, 사각형 묶어서 넣어두면 실행취소 상황에 어느것이 이전 단계였는지 기억을 하는 코드를 추가작업하거나 관리하기 어렵기때문에 
		//한번에 클래스의 형변환으로 동시관리를 한다면 값을 다루기가 수월하다.
	}
}
