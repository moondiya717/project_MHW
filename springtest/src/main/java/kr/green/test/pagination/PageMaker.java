package kr.green.test.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount; //콘텐츠 수
	private int startPage; //시작할 페이지네이션 번호
	private int endPage; //페이지네이션끝번호
	private boolean prev; //이전
	private boolean next; //다움
	private int displayPageNum; //페이지네이션에보여줄 이전<사이에 페이지갯수>다음
	//페이지내이션 1.페이지 2.페이지당 콘텐츠 수 3.현재페이지번호
	private Criteria criteria; 
	
	
	public void calcData() {
		endPage = //getPage()는 criteria의 총 페이지 수를 가져옴
			(int)(Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);

//보여줄displayPageNum마지막이 endPage라서 남은수에+1하면 1~10일때1, 21~30일때 21이 시작숫자
		startPage = (endPage - displayPageNum)+1;
		
		//endPage는 총 페이지네이션단위 예를들면 1-100쪽, 
		//tmpEndPage는 현재 클릭된 페이지 기준의 끝페이지 100쪽중 40쪽이라던지..
		int tmpEndPage = 
			(int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		if(endPage > tmpEndPage) {
			endPage= tmpEndPage;
		}
		prev= startPage ==1? false:true;
		next= endPage * criteria.getPerPageNum() >= totalCount? false:true;
		
	}
}
