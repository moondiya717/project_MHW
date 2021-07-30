package kr.home.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.practice.dao.BoardDAO;
import kr.home.practice.pagination.Criteria;
import kr.home.practice.vo.BoardVO;
 
@Service
public class BoardServiceImp implements BoardService {
    @Autowired
    BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVO getBoardDetail(Integer num) {
		if(num == null) {
			return null;
		}
		BoardVO board = boardDao.getBoardDetail(num); 
		return board;
	}

	@Override
	public void registerBoard(BoardVO board) {
		if(board == null) {
			return;
		}
		boardDao.registerBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board) {
		if(board == null) {
			return 0;
		}else if(board.getValid() == null){ //이거없어도된다?근데, 그냥 안전하게 하려고 넣은듯
			board.setValid("I");
		}
		return boardDao.updateBoard(board);		
	}

	@Override
	public int deleteBoard(Integer num) {
		BoardVO board = boardDao.getBoardDetail(num);
		if(board == null) {
			return 0;
		}
		board.setValid("D");
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}


    
 
}