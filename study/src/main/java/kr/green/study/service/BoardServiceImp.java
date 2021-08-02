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
		//System.out.println(board.getNum()); //게시글번호가 찍히는 것 확인했음
		if(fileList == null) { //첨부파일기능이용하려면 게시글번호를 알아야함
			return ;
		}
		
		
	}

	@Override
	public void insertReplyBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null) {
			return ;			
		}
		board.setWriter(user.getId());
		//문의에답변해줄때 게시글 이름을 그대로 가져오려면, 입력하지 않고 // replyregister에서 제목구간을 삭제해
//		BoardVO dbBoard = BoardDao.selectBoard(board.getOriNo());
//		if(dbBoard==null) {
//			return;
//		}
//		board.setTitle(dbBoard.getTitle);
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(user == null || board == null) {
			return ;
		}
		BoardVO dbBoard = boardDao.selectBoard(board.getNum());
		if(dbBoard== null || !user.getId().equals(dbBoard.getWriter())) { //예외처리를 습관화하는게 좋음
			return ;
		}
		dbBoard.setTitle(board.getTitle());
		dbBoard.setContents(board.getContents());
		boardDao.updateBoard(dbBoard);
	}

	@Override
	public void deleteBoard(Integer num, MemberVO user) {
		//이번에는 좀 다르게 한대, updateBoard하나를 이용하지않고 각각 이용해서 처리한다고 함
		if(num==null || user==null) {
			return;
		}
		BoardVO board = boardDao.selectBoard(num);
		if(board == null || !board.getWriter().equals(user.getId())) {
			return ;
		}
		boardDao.deleteBoard(num);
		boardDao.deleteReplyBoard(num); //게시글이삭제되면, 달렸던 답변글도삭제될수있게 처리함
	}
}
