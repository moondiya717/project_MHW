package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDAO;
import kr.green.test.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		return num ==null? null : boardDao.getBoard(num);
	}

	@Override
	public int updateViews(Integer num) {		
		//다오에게 게시글 정보를 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		board.setViews(board.getViews()+1);	
		return boardDao.updateBoard(board);
	}

	@Override
	public void insertBoard(BoardVO board) {
		if(board == null) {
			return;
		}
		boardDao.insertBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board) {
		if(board == null) {
			return 0;
		}
		if(board.getValid()==null) {			
			board.setValid("I");
		}
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num) {
		BoardVO board = boardDao.getBoard(num);
		if(board == null) {
			return 0;
		}
		board.setValid("D");
		return boardDao.updateBoard(board);
	}


}