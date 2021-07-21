package kr.home.practice.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private char gender;
	private String email;
	private String name;
	private String authority;
}
