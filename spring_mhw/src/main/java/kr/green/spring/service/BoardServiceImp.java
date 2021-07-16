package kr.green.spring.service;

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

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	private String uploadPath="D:\\JAVA_mhw\\uploadfiles";

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVO getBoard(Integer num) {
		//게시글 번호가 없으면 게시글이 없다고 전달 => num가 null인지 확인하여 null이면 null을 반환
		if(num == null) {
			return null;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//게시글 전달, 이 때 가져온 게시글은 없을 수도 있다(null이 들어갈 수도 있다- 번호가 잘못되어있거나, 게시글수<게시글번호 일때)
		return board;
		//return boardDao.getBoard(num); 이랑 같음 
	}

	@Override
	public void insertBoard(BoardVO board, MultipartFile[] file) {
		//다오에게 게시글 정보를 주면서 게시글 등록하라고 시킴
		boardDao.insertBoard(board);
		if(file == null) {
			return;
		}
		for(MultipartFile tmp:file) {
			insertFileVO(tmp, board.getNum());
		}

	}
	
	@Override
	public int updateViews(Integer num) {
		//다오에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		//가져온 게시글이 있으면 가져온 게시글의 조회수를 1증가
		if(board != null){
			board.setViews(board.getViews()+1);
			//다오에게 게시글을 주면서 게시글을 수정하라고 요청
			return boardDao.updateBoard(board);
		}
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board, MultipartFile[] file) {
		if(board == null || board.getNum() <= 0) {
			return 0;
		}
		if(board.getValid() == null) {
			board.setValid("I"); //기본값이 I, D=삭제됨 (실제로 삭제한게 아니라, 안보이도록 처리만하는 것)
		}
		/*
		FileVO fileVo = boardDao.getFileVO(board.getNum());  
		//첨부파일이 추가되는 경우
		if(fileVo == null && (file !=null && file.getOriginalFilename().length() !=0)) {
			insertFileVO(file,board.getNum());
		}
		//첨부파일이 삭제되는 경우
		else if(fileVo != null && (file != null && file.getOriginalFilename().length() == 0)) {
			//업로드되었던 파일을 삭제
			deleteFileVO(fileVo);
		}
		
		//첨부파일이 수정되는 경우
		else if(fileVo !=null && (file != null && file.getOriginalFilename().length() != 0)) {
			//업로드되었던 파일을 삭제
			File ftmp = new File(uploadPath+fileVo.getName()); //?쌤이거없나
			if(ftmp.exists()) {
				ftmp.delete();
			}
			boardDao.deleteFileVO(fileVo.getNum());
			insertFileVO(file,board.getNum());
		}
		*/	
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(Integer num, MemberVO user) {
		// 다오에게 게시글 번호를 주면서 가져오라고 시킴
		BoardVO board = boardDao.getBoard(num);
		if(board == null || user==null || !board.getWriter().equals(user.getId())) {
			return 0;
		}
		//가져온 게시글의  valid값을 D로 수정 
		board.setValid("D");
		//첨부파일 삭제
		
		//해당 게시글과 일치하는 첨부파일 정보들을 가져옴
		
		
		//반복문으로 하나씩 삭제처리
		ArrayList<FileVO> fileList = boardDao.getFileVOList(num);
		if(fileList!=null && fileList.size() !=0) {
			for(FileVO tmp : fileList) {
				deleteFileVO(tmp);
			}
		}
		
		//다오에게 게시글 정보를 주면서 수정하라고 시킨 후, 정수값을 리턴
		return boardDao.updateBoard(board);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public ArrayList<FileVO> getFileVOList(Integer num) {
		if(num == null) {
			return null;
		}
		return boardDao.getFileVOList(num);
	}

	@Override
	public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
		ResponseEntity<byte[]> entity = null;
	    InputStream in = null;
	    try{
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\""  
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); //header에 괄호안정보를 담아줌
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
		return entity;
	}

	//첨부파일을 서버에 업로드한 후 num게시글에 DB에 추가하는 메소드
	private void insertFileVO(MultipartFile file, int num){
		if(file != null && file.getOriginalFilename().length() != 0){
			try {
				String filename = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(num, filename, file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("첨부파일 업로드 중 예외 발생");	
			}
		}
	}
	
	//서버에 업로드된 첨부파일을 삭제 후, DB에서 삭제처리하는 메소드
	private void deleteFileVO(FileVO file) {
		File ftmp = new File(uploadPath+file.getName());
		if(ftmp.exists()) {
			ftmp.delete();
		}
		boardDao.deleteFileVO(file.getNum()); //첨부파일은 실제로 DB에서 삭제되도 상관없음
	}
	
}
