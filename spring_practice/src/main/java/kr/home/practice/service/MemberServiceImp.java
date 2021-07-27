package kr.home.practice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.practice.dao.MemberDAO;
import kr.home.practice.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    
    @Override
    public String getEmail(String id) {
        return memberDao.getEmail(id);
    }

	@Override
	public boolean signup(MemberVO user) {
		if(user == null || memberDao.getMember(user.getId())!= null) {
			return false;
		}
		memberDao.signup(user);
		return true;
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null) {
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null || !dbUser.getPw().equals(user.getPw())) {
			return null;
		}		
		return dbUser;
	}
	@Override
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public MemberVO getMember(HttpServletRequest request) {
		if(request==null) {
			return null;
		}
		return (MemberVO)request.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user) {
		// TODO Auto-generated method stub
		return null;
	}



}