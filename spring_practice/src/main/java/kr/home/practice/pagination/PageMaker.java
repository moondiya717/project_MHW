package kr.home.practice.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria criteria;
	
	public void calcData() {
		endPage = (int)(Math.ceil(criteria.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
	
		int tempEndPage = (int)(Math.ceil(totalCount / (double)criteria.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage ==1? false : true; //false숨김, true보임
		//페이지에 게시글 갯수가 모자르게있는 마지막페이지면 숨김, 아니면 보임
		next = endPage * criteria.getPerPageNum()>= totalCount ? false : true; 
	}	
}
