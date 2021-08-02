package kr.green.study.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.study.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	BoardVO selectBoard(Integer num);

	void insertBoard(@Param("board")BoardVO board); //mapper에서 if를 쓰기위해 Param넣어줌

	void updateBoard(BoardVO dbBoard);

}
