package kr.green.study.pagination;

import lombok.Data;

@Data
public class Criteria {
		//현재 페이지
		private int page; 
		//한 페이지 당 컨텐츠 갯수
		private int perPageNum;
		private String type; //검색타입이 아니라, 게시글 타입
		private String sortType; //id, authority 정렬
		private String sort; //desc, asc
		
		//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
		public Criteria() {
			this.page = 1;
			this.perPageNum = 10;
			this.sortType ="id";
			this.sort = "asc";
			this.type = "NORMAL";
		}
		public String getNotSort() {
	         if(sort.equals("asc"))
	            return "desc";
	         else
	            return "asc";
	      }
		/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
		public int getPageStart() {
			return (this.page -1) * perPageNum;
		}
		
	}