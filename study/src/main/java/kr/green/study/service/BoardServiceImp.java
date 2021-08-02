package kr.green.study.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.study.dao.BoardDAO;
import kr.green.study.pagination.Criteria;
import kr.green.study.utils.UploadFileUtils;
import kr.green.study.vo.BoardVO;
import kr.green.study.vo.FileVO;
import kr.green.study.vo.MemberVO;

@Service
//dao에서 autowired 안하고싶으면 추가하면 됨
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDAO boardDao;
	private String uploadPath = "D:\\JAVA_mhw\\uploadfiles_study";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria  cri) {		
		return boardDao.selectBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.selectBoard(num);
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] fileList, MemberVO user) throws Exception {
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
		int size  = fileList.length < 3 ? fileList.length : 3;
		for(int i = 0; i<size ; i++) {			
			insertFile(fileList[i], board.getNum());
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
	public void updateBoard(BoardVO board, MemberVO user, MultipartFile[] fileList, Integer[] fileNumList) throws Exception {
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
		
		ArrayList<Integer> dbFileNumList = boardDao.selectFileNumList(board.getNum());
		int dbSize=0;
		if(dbFileNumList != null) {
			dbSize = dbFileNumList.size();
		//fList에서 첨부파일 번호들만 ArryList로 변환
			ArrayList<Integer> inputFileNumList = new ArrayList<Integer>();
			if(fileNumList != null) {
				for(Integer tmp : fileNumList) {
					inputFileNumList.add(tmp);
					dbSize--;
				}
			}
			//dbFileNumList에 있는 첨부파일 번호들 중에서 inputFileNumList에 없는 첨부파일을 삭제
			for(Integer tmp : dbFileNumList) {
				if(!inputFileNumList.contains(tmp)) { //없을 때 삭제
					deleteFile(boardDao.selectFile(tmp));
				}
			}
		}
		//fileList에 있는 첨부파일 추가
		if(fileList == null) { 
			return ;
		}
		int size = fileList.length > 3 - dbSize ? 3- dbSize : fileList.length;
		for(int i = 0; i<size ; i++) {			
			insertFile(fileList[i], board.getNum());
		}
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
		
		//게시글이 삭제될 때, 첨부파일도 삭제해주기
		ArrayList<FileVO> fList = boardDao.selectFileList(num);
		if(fList == null || fList.size() == 0) {
			return ;
		}
		for(FileVO tmp : fList) {
			deleteFile(tmp);
		}
	}

	@Override
	public void updateViews(Integer num) {
		boardDao.updateViews(num);
		
	}

	@Override
	public ArrayList<FileVO> getFileList(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.selectFileList(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	private void insertFile(MultipartFile tmp, int num) throws Exception {		
		if(tmp == null || tmp.getOriginalFilename().length() == 0) {
			return ;
		}
		//UUID가 포함된 파일의 이름 계산( 파일이 저장될 경로, 파일이름, 파일용량) + exception 예외처리
		String name = UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
		FileVO file = new FileVO(num, name, tmp.getOriginalFilename());
		boardDao.insertFile(file);
	}
	private void deleteFile(FileVO tmp) {
		File file = new File(uploadPath+tmp.getName());
		if(file.exists()) {
			file.delete(); //파일을 실제로 삭제
		}
		boardDao.deleteFile(tmp.getNum()); //DB에서 파일 삭제 취급
	}

	@Override
	public int getTotalCount(Criteria cri) {		
		return boardDao.getTotalCount(cri);
	}
}
