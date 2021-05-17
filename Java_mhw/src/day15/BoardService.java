package day15;

public interface BoardService {

	/* 기능    : 게시글 등록하는 메소드
	 * 			(=게시글 제목, 내용, 작성자, 작성일이 주어지면 게시글을 등록하는 메소드)
	 * 매개변수 : 등록할 게시글(게시글번호, 제목, 내용, 날짜, 작성자) =>  게시글 정보 =>  Board board;
	 * 리턴타입 : void
	 * 메소드명 : addPost
	 * */
	public void addPost(Board board);		//interface에서는 접근제한자를 안써도 기본으로 public으로 사용됨
	
	/* 기능    : 게시글 삭제하는 메소드
	 * 			게시글 번호가 주어지면 해당 게시글 번호를 삭제한 후, 삭제 여부(url을 통해서 삭제하다보면 삭제가 잘못될 수도 있음 따라서 여부를 알려줘야함)를 알려주는 메소드
	 * 매개변수 : 삭제할 글번호
	 * 리턴타입 : 삭제여부=> boolean
	 * 메소드명 : deletePost
	 * */
	public boolean deletePost(int postNum);
	
	/* 기능    : 게시글 수정하는 메소드
	 * 			게시글 번호와 수정할 게시글 정보(제목, 내용)가 주어지면 해당 게시글의 내용을 수정하는 메소드
	 * 매개변수 : 게시글 번호와 수정할 게시글 정보 => Board board
	 * 리턴타입 : 없음=> void
	 * 메소드명 : editPost
	 * */
	public void editPost(Board board);
	
	/* 기능    : 게시글번호가 주어지면 게시글을 전달(=알려주는) 하는 메소드  //게시글을 눌러서 들어갔을 때 필요
	 * 			게시글 번호가 주어지면 주어진 게시글에 대한 게시글 정보(제목, 내용, 작성자, 작성일)을 알려주는 메소드
	 * 매개변수 : 게시글번호 
	 * 리턴타입 : 게시글 정보 => Board
	 * 메소드명 : getPost
	 * */
	public Board getPost(int postNum);
	
	/* 기능    : 게시글 리스트를 가져오는 메소드	//홈화면에서 게시글 리스트가 뜰 때 필요
	 * 			게시글의 정보(제목, 내용, 작성자, 작성일)들을 가져오는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 게시글 정보들 => Board []     //게시글정보 하나 Board, 게시글정보들은 Board []배열로 나타냄
	 * 메소드명 : listPost
	 * */
	public Board[] listPost();
	
	/* 기능    : 검색어가 들어간 게시글 리스트를 가져오는 메소드
	 * 매개변수 : 검색어 => String words
	 * 리턴타입 : 검색된 게시글 정보들 => Board[]
	 * 메소드명 : listPost
	 * */
	public Board[] listPost(String words);	
	//검색어가 들어가긴 했지만, 결국은 게시글 정보를 가져오는 것이기때문에 메소드오버로딩으로 메소드명을 똑같이 사용(매개변수가 다름) 할 수 있음.
	
	
	
	
	
}
class Board{
	int postNum;
	String title;
	String writer;
	String contents;
	String registerDate;
}