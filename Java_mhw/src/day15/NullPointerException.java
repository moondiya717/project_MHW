package day15;

public class NullPointerException {

	public static void main(String[] args) {
		String name = null;
		//객체를 생성하지 않아 예외 발생
		//System.out.println(name.toString());
		
		int []arr = null;
		//배열을 생성하지 않아 예외 발생 => 조건문을 이용하여 예외를 처리해서 실행하면 아무것도 출력되지 않는 것을 발견
		if(arr !=null) {	//=배열이 생성되면이라는 뜻
			System.out.println(arr.length);	//만들어져있지 않은 상황이라서 예외발생(빨갛다) =>해결: 조건문으로 
		}
		
	}

}
