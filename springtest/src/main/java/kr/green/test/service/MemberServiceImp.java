package kr.green.test.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
			dbUser.setUseCookie(user.getUseCookie());
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
		if(id == null) {
			return null;
		}
		return memberDao.getMember(id);
	}

	@Override
	public MemberVO getMember(HttpServletRequest r) {
		if(r==null || r.getSession() ==null) {
			return null;
		}
		return (MemberVO) r.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO user, MemberVO sUser) {
		if(user == null || sUser == null || !user.getId().equals(sUser.getId())|| user.getId() ==null) {
			return null;
		}
		if(user.getPw() !=null && user.getPw().trim().length() !=0) {
			String ePw = passwordEncoder.encode(user.getPw());
			sUser.setPw(ePw);
		}
		sUser.setEmail(user.getEmail());
		sUser.setGender(user.getGender());
		sUser.setName(user.getName());
		memberDao.updateMember(sUser);
		return sUser;
	}

	@Override
	public boolean idCheck(String id) {
		if(id == null || id.length() == 0 )
			return false;
		return memberDao.getMember(id) == null ? true : false;
	}

	@Override
	public void keepLogin(String id, String session_id, Date session_limit) {
		if(id == null || session_id == null || session_limit ==null) {
			return ;
		}
		memberDao.keepLogin(id, session_id, session_limit);
	}
}