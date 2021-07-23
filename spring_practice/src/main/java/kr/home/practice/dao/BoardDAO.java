package kr.home.practice.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.home.practice.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoardDetail(@Param("num")Integer num);

	void registerBoard(@Param("board")BoardVO board);
    
}
