package boardList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {

	private int num;
	private String title = ""; //초기값을 넣어줬네
	private String contents = new String(); //객체생성?
	private String writer = "";
	private Date registerDate; //Date 클래스
	private int view;
	private int like;
	private String type="";
	
	public Board(int num) { //게시물번호 가져갈 수 있게 한건가?
		this.num=num;
	}

	public Board(int num, String title, String contents, String writer, 
			String type) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = new Date();
		this.type = type;
	} //view랑 like지우고, registerDate는 new Date로 바로 생성하게 하고 매개변수지우기
	
	public void print() {
		view +=1;
		System.out.println("번호 :"+num);
		System.out.println("제목 :"+title);
		System.out.println("작성자 :"+writer);
		System.out.println("좋아요 :"+like);
		System.out.println("작성일 :"+getRegisterDate());
		System.out.println("내용 :"+contents);
	}

	public void summaryPrint() {
		System.out.print(num+ " ");
		System.out.print(title+ " ");
		System.out.print(writer+ " ");
		System.out.print(getRegisterDate()+ " ");
		System.out.print(view+" ");
		System.out.println();
	}
	
	public void modify(String title, String contents) {
		this.title=title;
		this.contents=contents;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegisterDate() { //숫자형식을 문자열로 바꿔주기
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return form.format(registerDate);
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Override //오버라이드누르면 이렇게 안뜨고 한줄짜리 뜨던데.. 이거다써야하는건가
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() !=obj.getClass()) {
			return false;
		}
		Board other = (Board) obj;
		if(num !=other.num)
			return false;
		return true;
	}


	
	
	
	
	
}
