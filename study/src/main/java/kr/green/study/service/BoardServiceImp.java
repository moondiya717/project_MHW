package kr.green.study.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import kr.green.study.vo.BoardVO;
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
}
