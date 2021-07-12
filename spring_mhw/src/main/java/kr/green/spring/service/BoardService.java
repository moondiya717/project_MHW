package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO board);

	int updateViews(Integer num);

	int updateBoard(BoardVO board);
	//void로 떴는데, 혹시라도 return값을 받아서 처리할 일이 생길 수도 있으니까 int로 변경
	int deleteBoard(Integer numm, MemberVO user);

	int getTotalCount(Criteria cri); 

}
