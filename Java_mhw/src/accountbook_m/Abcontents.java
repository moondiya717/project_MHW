package accountbook_m;

import java.text.SimpleDateFormat;
import java.util.Date;


class newPost{
	private Integer postNum; 	//게시글번호
	private String moneyType;	//수입, 지출
	private Integer amount;		//금액
	private String note;		//내용
	private Date date = new Date();		
	private SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String today=form.format(date);		//날짜


	public newPost (Integer postNum, String moneyType, Integer amount, String note, String today) {
		super();
		this.postNum=postNum;
		this.moneyType=moneyType;
		this.amount=amount;
		this.note=note;
		this.today=today;
	}

	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public String getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public SimpleDateFormat getForm() {
		return form;
	}
	public void setForm(SimpleDateFormat form) {
		this.form = form;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	
	/* 기능    : 게시글 번호가 주어지면, 해당 게시글의 일부 내용을 수정하는 기능 
	 * 매개변수 : 	Integer postNum, String moneyType, Integer amount, String note, String today
	 * 리턴타입 : 없음 => void (리턴타입을 수정하는 것들은 보통 리턴타입 없는 경우가 많음)
	 * 메소드명 : edit*/
	public void edit(Integer postNum, String moneyType, Integer amount, String note) {
		if(postNum != null) {
			if(moneyType != null) {
				this.moneyType=moneyType;}
			if(amount != null) {
				this.amount=amount;}
			if(note != null) {
				this.note=note;}
		}
	}
	
}

