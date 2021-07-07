package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String valid; //게시글을 실제로 삭제는 안하고 DB에 남겨두려고 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registered;
	private int views;	
	public String getRegisteredDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(registered);
				
	}
}
