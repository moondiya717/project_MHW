package kr.green.spring.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    
	@Override
	public MemberVO signin(MemberVO user) {
		//예외처리 : 회원 정보가 없거나 아이디가 없으면 null을 반환(빈문자열=문자열, null=데이터가 아예 없음) 
		if(user == null || user.getId() == null) {
			return null; 
		}
		//다오에게 아이디를 알려주면서 회원 정보를 가져오라고 시킴
		MemberVO dbUser = memberDao.getMember(user.getId());
		//가져온 회원 정보와 비밀번호를 확인하여 일치하면 회원정보를 반환하고
		//일치하지 않으면 null을 반환
		if(dbUser == null || !dbUser.getPw().equals(user.getPw())) { //나중에pw는 암호화처리해야해서 DB에서 직접 처리할 수 없음
			return null;
		}
		return dbUser;
	}
	
	@Override
	public boolean signup(MemberVO user) {
		//이미 가입된 아이디가 있으면(정보가 null이 아니면) false를 리턴
		if(user == null || memberDao.getMember(user.getId())!=null) { //memberDao.getMember DB에서 정보가져와서 확인해
			return false;
		}
		//없으면 다오에게 회원 정보를 주면서 회원가입 하라고 시킨 후, true를 리턴
		memberDao.signup(user);
		return true;
	}

	@Override
	public MemberVO getMember(String id) {
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		//가져온 회원 정보를 전달		
		return memberDao.getMember(id); //이미로그인을 했다는 가정이라서, null값 처리를 할 필요가 없음
	}
	@Override
	public int updateMember(MemberVO user) { //user에는 화면에서 넘겨주는 정보라서 DB에서 가져오긴했지만 해당 정보 누락이거든
		//user : 화면에서 입력한 회원정보, dbUser : DB에서 가져온 회원 정보
		//다오에게 아이디를 주면서 기존 회원 정보를 가져옴
		if(user == null) { //항상 넘겨주는 정보가 제대로 된 정보인지 확인해주는 게 좋음
			return 0;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		//일치하는 회원 정보가 없으면 0을 반환
		if(dbUser == null) {
			return 0;
		}
		//기존 회원 정보 중 수정할 회원 정보의 성별, 이메일을  수정할 회원 정보의 성별, 이메일로 변경
		dbUser.setGender(user.getGender()); //user.setGender(db.getGender());이 될 수없는 이유=> authority가 비어있음
		dbUser.setEmail(user.getEmail());
		
		//수정할 회원 정보에 비밀번호가 있으면, 기존 회원 정보의 비밀번호를 변경
		if(user.getPw() != null && !user.getPw().equals("")) { //화면에서 입력한 비밀번호 확인
			dbUser.setPw(user.getPw());
		}
		
		//다오에게 수정할 회원 정보를 주면서 변경하라고 시킴
		
		return memberDao.updateMember(dbUser);
	}

}
