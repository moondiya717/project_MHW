package kr.home.practice.pagination;

public class Criteria {

	private int page;
	private int perPageNum;
	
	public Criteria(){ //기본생성자로 매개변수 다 없앴음
		this.page = 1; //현재 페이지를 1로
		this.perPageNum = 10; //한 페이지의 컨텐츠를 10개로
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <=0) { //페이지를 0으로 설정하려고 시도해도 1로 초기화시키도록
			this.page = 1;
		}else {
			this.page = page;			
		}
		
	}


	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum = 10; //사용자가 조작해서 설정을하더라도 막아주려고			
		}else {
			this.perPageNum= perPageNum;
		}
	}


	@Override
	public String toString() { //toString이라는 이름을 가진 메소드를 Override재정의 
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

	public int getPageStart() { //쿼리문의 limit에 사용되는 인덱스
		return (this.page-1)*perPageNum;
	}
	
	
}
