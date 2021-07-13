package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
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
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null || board.getTitle().trim().length() ==0) { //null처리할때 객체를 생성하는거라서 실제 내용이 null인걸 잡아내는 거랑은 무관함 
			return; //메세지좀 띄워야겠다. 글은 안올라가는데 걍 아무렇지않게 리스트로 넘어가버리네
		}
		if(user == null || user.getId()==null || user.getId().trim().length() == 0) {
			return;
		}
		board.setWriter(user.getId());
		boardDao.insertBoard(board, user);
	}

	@Override
	public int updateBoard(BoardVO board) {
		if(board == null || board.getTitle().trim().length() ==0) {
			return 0;
		}
		BoardVO dbBoard = boardDao.getBoard(board.getNum());	
		dbBoard.setContents(board.getContents());
		dbBoard.setTitle(board.getTitle());		
		return boardDao.updateBoard(dbBoard);
	}

	@Override
	public int deleteBoard(Integer num) {
		if(num == null) {
			return 0;
		}
		BoardVO board = boardDao.getBoard(num);
		board.setValid("D");
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {		
		return boardDao.getTotalCount(cri);
	}




}
