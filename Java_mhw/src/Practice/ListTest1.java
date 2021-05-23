package Practice;

import java.util.ArrayList;

public class ListTest1 {

	public static void main(String[] args) {
		/* 문자열을 저장할 ArrayList를 생성
		 <> 가 들어간 클래스는 제네릭 클래스
		 제네릭클래스 : 멤버변수/메소드의 타입이 객체를 생성할 때 결정되는 클래스, 타입을 클래스로 해야 한다. 일반 변수X =>Wrapper class 사용하기
		 => <>안에있는 클래스에 따라서 ArrayList저거의 타입이 결정되는 클래스 종류를 제네릭 클래스라고 함 
		  */
		ArrayList<String> list = new ArrayList<String>(10);	//10개짜리 ArrayList에 list를 만듬
		
		//.add() : 리스트에 추가
		for(int i=0; i<10; i++) {
			list.add("간식");
		}
		list.add("아이스크림");		//위에서 10개짜릴 만들었는데, 11번째도 추가가 가능=> 자동으로 크기를 늘림

		
		//.get(번지): 번지에 있는 값을 가져옴
		System.out.println(list.get(10));	//아이스크림 출력 //0~9번지가 10개, 10번지는 11개째
		
		
		//.size() : 현재의 사이즈(지금까지 값이 얼마나 들어가있는지)를 알 수 있음 => size로 쓰고 length아님, 소괄호()있음
		System.out.println(list.size());   //현재 list의 크기 11
		list.add("애플민트에이드");
		System.out.println(list.size());   //list크기 12
		
		list.add(10,"체리에이드");							//10번지에 추가함
		System.out.println("리스트 크기: " + list.size());	//길이가 +1 늘었음 =>13
		//위에서 10번지에 체리에이드 추가 => 10번지 값 : 체리에이드가되고, 원래있던 10번지 값은 11번지로 밀린거임 => 중간에 껴넣기같은 것
		System.out.println(list.get(10));				
				
		//set(번지,값) : 번지에 값을 설정(덮어쓰기)
		list.set(10, "과자");					//체리에이드를 덮어쓰고 => 과자 가 됨.
		System.out.println(list.get(10));	//과자
		System.out.println(list.size());	//그대로 13유지
		
		//indexOf(값) : 값이 리스트에 있는지 없는지 확인하여 있으면 번지를 없으면-1을 반환
		// 해당 클래스의 equals를 호출하여 같은지를 확인
		//String클래스서 있었던 메소드 여기도 있는데, 완전 똑같지는 않아
		System.out.println("리스트에 체리에이드는 "+ list.indexOf("체리에이드") + "번지");			//-1 => 없다
		System.out.println("리스트에 애플민트에이드는 "+ list.indexOf("애플민트에이드") + "번지");	//12
		System.out.println("리스트에 간식이 "+ list.indexOf("간식") + "번지");                 //0번지(제일앞에있는것만나오는듯)
		
		//contains(값) : 값이 리스트에 있는지 없는지 확인하여 알려주는 메소드, equals()를 이용
		System.out.println("리스트에 애플민트에이드가 있다? "+ list.contains("애플민트에이드"));		//true
		System.out.println("리스트에 체리에이드가 있다? "+ list.contains("체리에이드"));			//false

		
		//remove(번지)  : 해당 번지의 값을 제거
		//remove(값)   : 값과 일치하는 내용을 제거
		System.out.println("리스트 10 번지: " + list.get(10));	//과자
		list.remove(10);									//번지 값 삭제		
		System.out.println("리스트 10 번지: " + list.get(10));	//아이스크림
		list.remove(10);									//번지값 삭제		
		System.out.println("리스트 10 번지: " + list.get(10));	//애플민트에이드
		
		list.remove("애플민트에이드");							//값 삭제
		System.out.println(list.contains("애플민트에이드")); //false =>삭제되서 없음
		
		
		
		//clear() : 리스트를 (전체) 비움
		list.clear();
		System.out.println("리스트 크기: " + list.size());		//비워서 0됨
		
							
		//isEmpty() : 리스트가 비어있는지 알려주는 코드
		System.out.println("리스트가 비어있습니까? " + list.isEmpty());	//위에서 비워서 없어서 true나옴
	
	}

}
