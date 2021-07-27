package kr.green.spring.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String email;
	private String name;
	private String authority;
	//대문자 Boolean(클래스의객체-null값을 포함할 수 있음) != boolean(일반자료형) =>null값을 포함할수있는지없는지 차이 (int와 Integer 같은 것) 
	private Boolean useCookie;
	
}
