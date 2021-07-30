package kr.home.practice.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.home.practice.pagination.Criteria;
import kr.home.practice.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoardDetail(@Param("num")Integer num);

	void registerBoard(@Param("board")BoardVO board);

	int updateBoard(@Param("board")BoardVO board);

	BoardVO getBoard(@Param("num")Integer num);

	int getTotalCount(@Param("cri")Criteria cri);

}
