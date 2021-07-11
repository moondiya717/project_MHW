package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getDetail(Integer num);

	BoardVO boardDelete(Integer num);

}
