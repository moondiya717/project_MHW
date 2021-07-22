package kr.home.practice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private Date registered;
	private String views;
	private String valid;
}
