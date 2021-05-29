package Practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMethod {

	public static void main(String[] args) {

		
	}
	public static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 확인");
		System.out.println("4. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴를 선택하세요 :");
	}
	public static void printviewList() {
		System.out.println("=====메뉴를 선택하세요=====");
		System.out.println("1. 게시글 목록 보기");
		System.out.println("2. 게시글 자세히보기");
		System.out.println("======================");
		System.out.print("메뉴를 선택하세요 :");
	}
	//게시글을 작성하는 메소드
	public static Contents writePost() {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("======게시글을 작성하세요=====");
		System.out.print("제목 :");
		String title = scan.next();
		System.out.print("내용 :");
		String text = scan.next();
		System.out.println("=====게시글이 등록되었습니다=====");
		
		//저장도해야하는데
		int i = 1;
		Contents tmp = new Contents(i, title, text, Contents.now());
		i++;
		return tmp;
		
	}
	public static ArrayList<Contents> savePost() {	//wirtePost 메소드까지 포함하고있어서, 메인호출은 얘만하면 writePost까지 진행됨
		ArrayList <Contents> tmp = new ArrayList <Contents>();
		tmp.add(writePost());
		return tmp;
	}
	
	//게시글 확인하는 메소드
	public static void showPost() {
		for(String tmp : list) { //위에저장된 애들을 어떻게 불러와서 출력시킬수있는걸까?
			System.out.println(tmp);
		}
		
	}
	
	
	
}
class Contents{
	int postNum;
	String title;
	String text;
	String now=now();
	

	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}


	public static String now(){
		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now=form.format(date);
		return now;
	}
	//생성자를 만들어서 Contents라는 클래스와 같은 이름의 생성자 이름으로 해당 클래스가 가진 모든 메소드를 사용할 수 있게함.
	//더불어, 클래스를 이용해서 다른 객체를 만드는 것 까지 허용해줌
	public Contents(int postNum, String title, String text, String now) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.text = text;
		this.now = now;
	}
	
	

	

	
	
	
}


