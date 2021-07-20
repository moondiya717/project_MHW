package kr.green.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.RecommendVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO board, MultipartFile[] file);

	int updateViews(Integer num);

	int updateBoard(BoardVO board, MultipartFile[]file, Integer[] fileNum);
	//void로 떴는데, 혹시라도 return값을 받아서 처리할 일이 생길 수도 있으니까 int로 변경
	int deleteBoard(Integer num, MemberVO user);

	int getTotalCount(Criteria cri);

	ArrayList<FileVO> getFileVOList(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName) throws IOException;

	int updateRecommend(MemberVO user, int board, int state);

	RecommendVO getRecommend(MemberVO user, Integer num); 

}
