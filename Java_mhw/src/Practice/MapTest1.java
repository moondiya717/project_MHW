package Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		//Map 예제
		//<>안에 두개써야돼. List랑 Set은 데이터1개만다루고 Map은 2개
		HashMap<String, String> map = new HashMap<String, String>();

		//.put(key, value) : key와 value의 값을 저장 => key라는 이름에 value라는 값을 저장 (얘는 add가 아님)
		//key의 값이 중복되지 않으면 null을 리턴하고, 중복되면 이전에 저장된 value값을 리턴
		System.out.println(map.put("과일", "사과"));	// 이전에 저장된게 없어서 중복이안됨=> null
		System.out.println(map.put("과일", "포도"));	// key가 중복되서 앞에있던 value값을 리턴 =>사과
		map.put("학용품", "연필");
		map.put("탈것", "자전거");
		map.put("전자기기", "스마트폰");
		map.put("그릇", "텀블러");
		

		//.containsKey(객체) : key값에 객체와 일치하는 정보가 있는지 없는지 알려줌
		System.out.println("Key에 과일이 있습니까? "+ map.containsKey("과일"));	//true
		System.out.println("Key에 포도가 있습니까? "+ map.containsKey("포도"));	//false =>"포도"는 Value값
		
		//containsValue(객체) : value값에 객체와 일치하는 정보가 있는지 없는지 알려줌
		System.out.println("Value에 과일이 있습니까? "+ map.containsValue("과일"));	//false =>과일은 Key값
		System.out.println("Value에 포도가 있습니까? "+ map.containsValue("포도"));	//true
		
		//get(객체) : key값이 객체와 일치하는 정보의 value값을 가져옴
		System.out.println("Key값이 과일인 객체의 value값은? "+ map.get("과일"));		//포도
		
		// 출력방법1: set을 이용하여 Iterator를 사용
		// Key값들을 Set으로 만든 후, Iterator사용 (만들어진 set을 이용하여 반복문을 사용)
		// keySet(): 맵의 key값들을 하나의 Set으로 만들어주는 메소드
		Set<String> keySet=map.keySet(); //keyset통해서 key값을 set으로 만듬
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();	//iterator통해서 key값가져와
			String value = map.get(key); 	//해당키와 일치하는 value값을 가져오기
			System.out.println(key + " : " + value);
		}
		
		System.out.println("----------------------------------------");
		// 출력방법2: set을 이용하여 Iterator를 사용
		// key값과 value값을 가지는 하나의 클래스인 Entry클래스를 이용하는 방법
		// entrySet() : Entry클래스를 이용한 Set을 변환
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key= tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " : " + value);
		}
	}
}
class Entry{  //하나의 클래스에 key와 value를 객체로 넣고 set으로 만들어
	String key;
	String value;
	
}