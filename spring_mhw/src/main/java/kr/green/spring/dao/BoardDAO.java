package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.RecommendVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoard(@Param("num")Integer num); //DAO에는 항상 Param을 쓰기로 함

	void insertBoard(@Param("board")BoardVO board);

	int updateBoard(@Param("board")BoardVO board);

	int getTotalCount(@Param("cri")Criteria cri);

	void insertFile(@Param("file")FileVO fileVo);

	ArrayList<FileVO> getFileVOList(@Param("num")Integer num);

	void deleteFileVO(@Param("num")int num);

	RecommendVO getRecommend(@Param("id")String id, @Param("board")int board);

	void insertRecommend(@Param("id")String id, @Param("board")int board, @Param("state")int state);

	void updateRecommend(@Param("rvo")RecommendVO rvo);

}
