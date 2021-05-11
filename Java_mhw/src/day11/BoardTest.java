package day11;

public class BoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board(1, "제목입니다", "내용입니다", "문혜원", "2021-05-11", "공지");
		board.print();
		
		/* =(대입연산자)는 오른쪽에 있는 값을 왼쪽에 저장하는데, 타입이 같거나 변환이 가능해야한다. 
		 * 예1) 	String str = "1"; 
		 * 		int num = str; (은 문자열 1을 int에 저장하려고 해서 오류)
		 * 
		 * 예2) double dnum = 1; (은 정수 1이 자동타입변환이 되어서 실수double dnum에 저장될 수 있음)
		 * 예3) int num = (int) 1.0; (은 실수 1.0이 강제타입변환(앞에다가 타입을 강제로 씀)이 되어서 가능) */
		
		Board board1 = new Board(2, "2번인가", "내용입니다", "문혜원", "2021-05-11", "공지");
		board1.print();
		
	}

}
