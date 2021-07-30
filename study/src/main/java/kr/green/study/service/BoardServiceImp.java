package kr.green.study.service;

import org.springframework.stereotype.Service;

import kr.green.study.dao.BoardDAO;
import lombok.AllArgsConstructor;

@Service
//dao에서 autowired 안하고싶으면 추가하면 됨
@AllArgsConstructor
public class BoardServiceImp implements BoardService{
	private BoardDAO boardDao;
}
