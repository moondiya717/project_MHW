package day10;

public class D {
	private int num; //private 접근 제한자

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	/* 수업중 D에서 오려낸 부분)
	public int getNum() {	//접근제한자가 public이니깐 밖에서 접속 가능.
			return num;			//num의 값이 private int num랑 같은데, 같은 클래스안에 있으니깐 값을 가져올 수 있고. 이 getNum안에 있는 num은 public이라 다른데로 가지고 나가질 수 있음.
		}
		public void setNum(int n) {
			num=n; //같은 클래스 안에 있으니까 num을 사용할 수 있는거임
		} */
	//우클릭 => source => getter setter
}
