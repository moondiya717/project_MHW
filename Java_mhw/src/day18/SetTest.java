package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/* Set 메소드 예제*/
		HashSet<Integer> set = new HashSet<Integer>();	//Set은 중복ㄴㄴ => int는 equals로 중복체크가 안돼서 int아니고 Integer
		
		// add(객체) : set에 객체를 추가 => list는 add(객체), add(번지,객체)두개였는데 Set은 순서보장을 안해서 (객체) 1개밖에없음
		//*Set은 순서가 없으니까 번지로 접근하는 메소드들은 전부 없다고 생각하면 돼
		set.add(10);	//10이라는 객체를 저장
		set.add(10);

		//size() : set의 크기
		System.out.println("set의 크기 :" + set.size()); //값:1 => 중복을 허용하지않아서 두번넣어도 1번으로 침
		
		//contains(객체) : 객체가 있는지 없는지 확인
		//indexOf()없음 => 번지가 없으니깐 ㅋ
		System.out.println("set에 10이 있습니까? " + set.contains(10));	//true	=>아까 10넣었음
		System.out.println("set에 11이 있습니까? " + set.contains(11));	//false

		//isEmpty() : set이 비었는지 아닌지 확인
		System.out.println("set이 비어있습니까? " + set.isEmpty()); 		//false
		 
		
		//Iterator를 확인하려고 객체저장을 좀 많이 하겠음
		set.add(11);	set.add(100);
		set.add(3);		set.add(4);
		set.add(8);		set.add(31);
		set.add(33);	set.add(29);

		
		Iterator<Integer> it = set.iterator();	//List랑 Set쓸 때, 공식처럼 쓴대 ...
		while(it.hasNext()) {	//다음선택할 객체가있는지 알려주는 메소드=>true/false
			//Iterator의<>클래스 안에 Integer가 있으면 (Integer)를 생략가능, <>클래스명에 Integer없으면 꼭 써야돼 (Integer)	
			Integer tmp = /*(Integer)*/ it.next();	//it.next()는 set에 있는 값 하나를 가져오는 것, scan.next()랑은 다른것
			System.out.print(tmp+ " ");	//한줄로 저장되어있는거 다 나왔음
		}								//저장한 순서대로 나오지 않고, 랜덤순으로 나옴
		System.out.println();
		
		
		//remove.()	:객체를 삭제하고 삭제 성공 여부를 알림 => 삭제하려는 객체가 없으면 실패할 수 있음. 리턴타입 boolean (true/false)
		System.out.println("set에 10의 값이 삭제 되었습니까? "+set.remove(10));
		System.out.println("set에 10의 값이 삭제 되었습니까? "+set.remove(100));

	
		//clear() : 비움
		set.clear();
		System.out.println("set의 크기: "+ set.size());
		
	}
}
