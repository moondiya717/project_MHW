package Practice;

public class test2 {

	public static void main(String[] args) {
		//참조변수는 값(리터럴=코드에서 실제로 사용하는 값)을 저장하는 변수가 아니라 주소를 저장하는 변수. 
		//2개의 문자열변수타입의 배열에 값ab를 각각 저장하고, 값이 같은지 다른지 확인하기
		
		String str1="ab";		//String저장하는 공간에다가 ab라는 리터럴을 저장함. 
		String str2="ab";		//그리고 그 공간에서는 같은 값을 같이 주소를 통해서 공유해서 씀. 
		
		if(str1==str2) {
			System.out.println("문자열이 같습니다.");
		}else {
			System.out.println("문자열이 다릅니다");
		}
		
		//새로운 두개의 문자열변수에 ab라는 값을 각각 새로 저장하고 값이 같은지 다른지 확인하기
		String str3=new String ("ab");
		String str4=new String ("ab");
		
		if(str3==str4) {
			System.out.println("문자열이 같습니다");
		}else if(str3!=str4) {
			System.out.println("문자열이 다릅니다");
		}

		
		
		
		

	}

}
