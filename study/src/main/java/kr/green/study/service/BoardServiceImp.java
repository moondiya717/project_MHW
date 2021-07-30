package kr.green.study.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.study.dao.BoardDAO;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
//dao에서 autowired 안하고싶으면 추가하면 됨
@AllArgsConstructor
public class BoardServiceImp implements BoardService{
	private BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {		
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.selectBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) {
		if(board == null || user == null) {
			return ;			
		}
		board.setWriter(user.getId());
		board.setGroupOrd(0); //혹시나 잘못된접근으로 user가 답변하는 것을 막기위해, 없어도 잘 작동되긴하지만 
		boardDao.insertBoard(board);
		
		
	}
}
