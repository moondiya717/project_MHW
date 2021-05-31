package board;

public class Board {
	/* 게시글에 필요한 멤버변수를 선언하세요. 
	 * 멤버 변수 : 제목, 내용, 작성자, 등록시간, 조회수, 좋아요수, 게시글 번호, 게시글 타입
	 * */
	
	private int num;
	private String title = ""; 					//참조변수(객체가 안만들어져 있음, 만들어야 함) 	//멤버변수이기도 하지만 객체이다. String이라는 클래스로 만들어진 객체임
	private String contents = new String(); 	//다른건 new를 사용해야하는데 String은 빈 문자열도 new String();도 가능함
	private String writer ="";
	private String registerDate = ""; 			//원래 날짜라는 클래스가 있는데, 아직 안배워서 문자열로 취급
	private int views;
	private int like;
	private String type = "";
	
	//this.xx은 멤버변수와 메소드를 호출할 수 있다.
	//this()생성자를 부를 수 있다
	
	
	//생성자를 만들어보세요. (이런경우는 기본생성자가 필요가 없음 => 사람이 직접 다 입력해야하기 때문이래)
	public Board(int num, String title, String contents, String writer, String registerDate, String type) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
	}

	/* 기능    : 게시글 정보 출력하는 메소드
	 * 매개변수 : 필요없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : print */
	public void print() {
		views +=1;
		System.out.println("번호 : " 	+ num);
		System.out.println("제목 : " 	+ title );
		System.out.println("작성자 : " 	+ writer);
		System.out.println("조회수 : " 	+ views);
		System.out.println("좋아요 : " 	+ like);
		//타입은 출력을 안할거임, 실제로는 있지만 보통 따로 공지사항은 공지사항끼리 뭐 이런식으로 모아둔다고...그러는데?
		System.out.println("작성일 : " 	+ registerDate);
		System.out.println("내용 : " 	+ contents);
	}
	/* 기능    : 게시글 정보를 요약(번호, 제목, 작성자, 작성일)해서 출력하는 기능
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 =>void
	 * 메소드명 : summaryPrint
	 * */
	public void summaryPrint() {
		System.out.print(num + " " );
		System.out.print(title + " " );
		System.out.print(writer + " " );
		System.out.print(registerDate + " " );
		System.out.print(views + " " );
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
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
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

 	
	
	
}
