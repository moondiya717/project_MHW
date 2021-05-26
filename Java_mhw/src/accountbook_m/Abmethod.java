package accountbook_m;

import java.util.ArrayList;

public class Abmethod {

	private ArrayList <newPost> list;	//가계부 배열
	private Integer total=0; //최종금액
	
	public ArrayList<newPost> getList() {
		return list;
	}
	public Integer getTotal() {
		return total;
	}

	/* 기능    : 내역(newPost)이 주어지면 주어진 내역을 가계부에 저장하는 메소드
	 * 매개변수 : 내역=> newPost 
	 * 리턴타입 : void 
	 * 메소드명 : add
	 * */	
	public <Abcontents> void add(Abcontents newPost) {
		Integer i=0;
		list.add(i++,(accountbook_m.newPost) newPost); 
	}
	
	/* 기능    : 게시글번호가 주어지면 주어진 내역을 가계부에 삭제하는 메소드
	 * 매개변수 : 게시글번호=번지
	 * 리턴타입 : void 
	 * 메소드명 : add
	 * */
	public <abcontents> void delete(Integer postNum) {
		Integer tmp=list.indexOf(postNum);
		list.remove(tmp);
	}
	
	/* 기능    : 내역 전체를 초기화하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void 
	 * 메소드명 : clear
	 * */
	public <abcontents> void clear() {
		list.clear();
	}
	
	/* 기능    : 내역 전체를 간소화하여 확인하도록 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void 
	 * 메소드명 : detailPost
	 * */
	public <abcontents> void simplePost() {
		System.out.println("번호|   타입   |   금액   |    메모  ");
		for(int i=0; i<list.size(); i++) {
			System.out.println());
		}
	}
	
	/* 기능    : 게시글 번호가 주어지면 해당 게시글 내역을 자세히 확인하도록 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : void 
	 * 메소드명 : detailPost
	 * */
	public <abcontents> void detailPost(Integer postNum) {
		Integer tmp=list.indexOf(postNum);
		list.get(tmp);
	}
	
	
}
