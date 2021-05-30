package Practice;

public class TvTest {
	public static void main (String args[]){
	 Tv test1 = new Tv();
	 Tv test2 = new Tv();
	 
	 System.out.println("test1 채널 :"+test1.channel);
	 System.out.println("test2 채널 :"+test2.channel);
	 
	 test1.channel=5;
	 System.out.println("test1의 채널을 "+ test1.channel+"로 변경했습니다.");
	 
	 // 같은 클래스를 이용해서 만들었지만, 하나의 값을 저장한다고해서 다른 하나도 바뀌지 않음. 
	 //바로가기가 아니라, 복사한 파일 같은 개념 (=서로다른 주소값을 가지고있는 상태)
	 System.out.println("test1 채널 :"+test1.channel);
	 System.out.println("test2 채널 :"+test2.channel);

	 

	 test2=test1; //(주소값을 붙여너은 상태라, 복사한 파일이 => 바로가기파일 로 바뀐 느낌)
	 
	 test1.channel=8;
	 System.out.println("test1의 채널을 "+ test1.channel+"로 변경했습니다.");
	 
	 System.out.println("test1의 채널 :"+test1.channel);
	 System.out.println("test2의 채널 :"+test2.channel);
	 
	 
	 Tv []tvArr = new Tv[3]; //Tv클래스를 통해 3칸짜리 배열tvArr를 만들었음
	 
	 for(int i = 0; i<tvArr.length; i++) {
		 tvArr[i] = new Tv(); //tvArr의 배열 안에 Tv클래스를 넣는중?????
		 tvArr[i].channel = i+10;
	 }
	 
	 for(int i=0; i<tvArr.length; i++) {
		 tvArr[i].channelUp(); 
		 System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		 
	 }
	 
	}
}
class Tv{ //클래스는 항상 대문자로 시작
	String color;
	boolean power;
	int channel;
	
	//TvTest test = new TvTest();
	//test.num=3; //에러 클래스 객체멤버는 main에서만 불러와서 쓸 수 있음
	
	
	public void power() {
		power = !power;
	}
	
	public void channelUp() {
		++channel;
	}
	
	public void channelDown() {
		--channel;
	}
}