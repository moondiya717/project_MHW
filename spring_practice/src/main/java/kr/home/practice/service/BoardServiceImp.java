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
    
 
}