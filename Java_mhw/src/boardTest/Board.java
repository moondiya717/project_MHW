package boardTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	/* 게시글에 필요한 멤버변수를 선언하세요. 
	 * 멤버 변수 : 제목, 내용, 작성자, 등록시간, 조회수, 좋아요수, 게시글 번호, 게시글 타입
	 * */
	
	private int postNum;
	private String title;
	private String contents;
	private int views;
	private Date date;
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return form.format(date);
	}




	public Board(int postNum, String title, String contents) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.contents = contents;
		this.date = new Date();
	}
	public Board(int postNum) {
		this.postNum = postNum;
	}
	

	/* 기능    : 게시글 정보 출력하는 메소드
	 * 매개변수 : 필요없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print */
	public void print() {
		views +=1;
		System.out.println("번호 : " 	+ postNum);
		System.out.println("제목 : " 	+ title );
		System.out.println("내용 : " 	+ contents);
		System.out.println("조회수 : " + views);
		System.out.println("날짜 : " + date);
	}
	
	/* 기능    : 게시글 정보를 요약(번호, 제목, 작성자, 작성일)해서 출력하는 기능
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : summaryPrint
	 * */
	public void summaryPrint() {
		System.out.print(postNum+ " ");
		System.out.print(title+ " ");
		System.out.print(views+ " ");
		System.out.print(date+ " ");
		System.out.println();
	}
	
	/* 기능    : 제목과 내용을 수정하는 메소드
	 * 매개변수 : 수정할 제목, 내용 => String title, String contents
	 * 리턴타입 : 없음=> void //출력을하거나 변경을하는 메소드들은 거의 리턴타입이 없음
	 * 메소드명 : modify
	 * */
	public void modify(String title, String contents) {
		this.title=title;
		this.contents=contents;
	}

	@Override
	/* equals를 오버라이딩하면 ArrayList에서 제공하는 contains 또는 indexOf를 이용하기 쉽다*/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(obj instanceof Integer) {
				if((Integer)obj == this.postNum) {
					return true;
				}
				return false;
			}
		}
			
		Board other = (Board) obj;
		if (postNum != other.postNum)
			return false;
		return true;
	}
	
	
	
}
