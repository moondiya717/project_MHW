package kr.green.test.pagination;

public class Criteria {

	private int page;
	private int perPageNum;
	private int type;
	private String search;
	
	
	//getter satter로 select all해서 진행하고, 세부 조건(setPage, setPerPageNum)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
		
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else			
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum=10;
		}
		else
			this.perPageNum = perPageNum;
	}
	
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.type = 0;
		this.search = "";
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", type=" + type + ", search=" + search + "]";
	}
	
	//쿼리문 limit(시작페이지번호, 페이지당포함컨텐츠갯수)에 사용되는 인덱스를 계산하는 getter
	//시작페이지번호-1인 이유는 : limit이 0부터 1페이지임
	public int getPageStart() {
		return (this.page -1)* perPageNum;
	}
	

		
	
}
