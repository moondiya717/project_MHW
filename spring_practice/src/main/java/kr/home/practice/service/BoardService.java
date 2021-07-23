package kr.home.practice.service;

import java.util.ArrayList;

import kr.home.practice.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoardDetail(Integer num);

	void registerBoard(BoardVO board);

	
}