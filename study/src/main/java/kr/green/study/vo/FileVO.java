package kr.green.study.vo;

import lombok.Data;

@Data
public class FileVO {
	private int num;
	private int board;
	private String name;
	private String ori_name;
	private String state;
	private String thumbnail;
	
	public FileVO() {}
	
	//편하게 객체를 만들기 위해서 생성자를 만듬
	public FileVO(int board, String name, String ori_name) {
		this.board = board;
		this.name = name;
		this.ori_name = ori_name;
	}
}
