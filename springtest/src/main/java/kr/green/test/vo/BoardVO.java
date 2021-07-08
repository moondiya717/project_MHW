package kr.green.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data //getter,setter의 toString을 만들어주는 어노테이션임
public class BoardVO {

	private int num;
	private String title;
	private String contents;
	private String writer;
	private Date registered;
	private int views;
	private String valid;
	
	//등록한 날짜를 년월일까지만 문자열로 보여주는 getter
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(registered);
	}
	
	//등록한 날짜를 년월일 시분초까지 문자열로 보여주는 getter
	public String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(registered);
	}
}
