package kr.home.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.practice.dao.BoardDAO;
import kr.home.practice.vo.BoardVO;
 
@Service
public class BoardServiceImp implements BoardService {
    @Autowired
    BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.getBoardList();
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
		}
		return boardDao.updateBoard(board);		
	}
    
 
}