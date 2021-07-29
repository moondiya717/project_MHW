package kr.green.study.service;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.study.dao.MemberDAO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService{
	MemberDAO memberDao;
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO user) {
		if(user == null) {
			return false;
		}
		System.out.println(1);
		//아이디 유효성 검사
		String idRegex = "^[0-9a-z_-]{5,20}$";
		if(user.getId() == null || !Pattern.matches(idRegex, user.getId())){
			return false;
		}
		System.out.println(2);

		//비밀번호 유효성 검사
		String pwRegex = "^[a-zA-Z0-9!@#]{8,16}$";
		if(user.getPw() == null || !Pattern.matches(pwRegex, user.getPw())){
			return false;
		}
		System.out.println(3);

		//이메일 유효성 검사, xx@yy.zz or xx@yy.zz.cc
		String emailRegex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		if(user.getEmail() == null || !Pattern.matches(emailRegex, user.getEmail())){
			return false;
		}	
		System.out.println(4);

		//이름 유효성 검사
		if(user.getName()==null || user.getName().trim().length()==0) {
			return false;
		}
		System.out.println(5);

		//성별 유효성 검사
		if(user.getGender() == null) {
			return false;
		}
		System.out.println(6);

		//비밀번호 암호화 
		String encPw = passwordEncoder.encode(user.getPw());
		user.setPw(encPw);
		
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null) {
			return null;
		}
		MemberVO dbUser = memberDao.selectUser(user.getId());
		//잘못된 ID == 회원이 아닌 
		if(dbUser == null) {
			return null;
		}
		//잘못된 비번
		if(user.getPw() == null || !passwordEncoder.matches(user.getPw(), dbUser.getPw())){
			return null;
		}
		//자동 로그인 기능을 위해
		dbUser.setUseCookie(user.getUseCookie());
		return dbUser;
	}

	@Override
	public Object getMember(String id) {
		System.out.println(id);
		if(id == null) {
			return null;
		}
		MemberVO user = memberDao.selectUser(id);
		System.out.println(user);
		return user;
	}

	@Override
	public void signout(HttpServletRequest request) {
		if(request != null) {
			request.getSession().removeAttribute("user");
		}
	}
	
}
