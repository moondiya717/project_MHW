package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
    @Autowired
    MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() ==null || 
				user.getId().trim().length() == 0 || user.getPw() == null ||
				user.getPw().trim().length() == 0){
			return null;
		} 
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null) {
			return null;
		}
		if(passwordEncoder.matches(user.getPw(), dbUser.getPw())) {
			return dbUser;
		}
		return null;
	}

	@Override
	public void signup(MemberVO user) {
		if(user == null) 
			return ;
		 //user.getId().equals("") 는 공백입력했을 때, 회원가입 못하도록하기
		if(user.getId() == null || user.getId().trim().length() ==0 || //nullpointException발생때문에 예외처리해주기
		   user.getPw() == null || user.getPw().trim().length() == 0 ||
		   user.getName() == null || user.getName().trim().length() == 0 ||
		   user.getEmail() == null || user.getEmail().trim().length() == 0)
			return ;
		//정규표현식
		
		//암호화
		String ePw=passwordEncoder.encode(user.getPw());
		user.setPw(ePw);
		//회원가입
		memberDao.insertMember(user);
		}
	
	@Override
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}
	
}