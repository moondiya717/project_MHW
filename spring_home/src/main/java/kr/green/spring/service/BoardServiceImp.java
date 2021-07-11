package kr.green.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;



@Service
public class BoardServiceImp implements BoardService {
    @Autowired
    BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getDetail(Integer num) {
		return boardDao.getDetail(num);
	}

	@Override
	public BoardVO boardDelete(Integer num) {
		BoardVO delete = boardDao.getBoard(num);
		if(delete ==null) {
			return 0;
		}
		delete.setValid("I");
		return boardDao.updateBoard(delete);
		
	}

    
}
