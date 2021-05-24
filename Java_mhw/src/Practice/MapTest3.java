package Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest3 {

	public static void main(String[] args) {
		
		HashMap<String,Integer> mapTest =new HashMap<String,Integer>();
		
		for(int i=0; i<10; i++) {
			mapTest.put("사과"+(i+1), 10*i);	//출력하면 랜덤 순으로 나와 => 순서가 없기때문에
		}
		
		// map출력 방법1
		//keySet(): 맵의 key값들을 하나의 Set으로 만들어주는 메소드
		Set<String> keyName = mapTest.keySet();
		Iterator<String> key = keyName.iterator();
		while(key.hasNext()) {
			String key1 = key.next();
			Integer value1= mapTest.get(key1);
			System.out.println(key1 + ", " + value1);
		}
		
		//map출력 방법2
		// entrySet() : Entry클래스를 이용한 Set을 변환
		Set<Map.Entry<String, Integer>> alSet= mapTest.entrySet();
		Iterator<Map.Entry<String, Integer>> it = alSet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> tmp = it.next();
			String appleName = tmp.getKey();
			Integer price = tmp.getValue();
			System.out.println(appleName+", "+price);
		}
	}
}
class appleList{
	String name;
	Integer price;
}