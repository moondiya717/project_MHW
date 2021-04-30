package day5;

public class Test5_2 {

	public static void main(String[] args) {
		//교쟈 170-172를 설명하기 위한 예제
		//참조변수는 값(리터럴=코드에서 실제로 사용하는 값)을 저장하는 변수가 아니라 주소를 저장하는 변수. 
		
		String str1="ab";		//String저장하는 공간에다가 ab라는 리터럴을 저장함. 
		String str2="ab";		//그리고 그 공간에서는 같은 값을 같이 주소를 통해서 공유해서 씀. 
		if(str1==str2) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
		
		
		String str3= new String("ab"); //new는 String을 저장하는 공간에 있었던 값들에서 있는지 없는지 확인한 뒤 없으면 만드는게 아니라 
		String str4= new String("ab");  //String 저장하는 공간 밖에 리터럴을 새로 만들어서 값을 저장하고 String str3에 만들어진 값(리터럴)의 주소를 통해서 이어준다는 거임
		if(str3==str4){
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
	
		
		
		
		
		

	}

}
