package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		// throws는 메소드를 하나 만들어야 돼. 메인에서 작업하는게 아니래
		try {
		test();			//메인에서 메소드 호출했으니까 try로 해결해
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void test() throws Exception{		//이 메소드를 호출한 메인에서 해결한다 	//throws Exception, , , , 예외명을 ,로 이어적기 가능
		throw new Exception("test 메소드에서 예외 발생");	//Throws Exception은 생략가능 .
	}            //에러발생=>Exception은 일반예외+실행예외라서 일반예외포함때문에=> 실행예외인 RuntimeException를 쓰면 에러발생 안함
}

