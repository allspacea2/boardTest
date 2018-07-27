package kr.or.ddit.board.model.post;

import java.util.Date;

public class PostVo {
	
	
	private int 	post_no; 	  //1 게시글 번호
	private int 	board_no;	  //2 게시판 번호
	private int 	post_pno;	  //3 게시글 부모번호
	private int 	post_gno;	  //4 게시글 그룹번호
	private String 	title;		  //5 글제목
	private String  post_contents;//6 글 내용
	private int 	std_num;	  //7 작성한 학생번호
	private Date 	post_date;	  //8 작성일시
	private String  post_ava; 	  //9 글삭제구분자
	private String  std_name;
	private int 	rn;
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getPost_contents() {
		return post_contents;
	}
	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}
	public String getPost_ava() {
		return post_ava;
	}
	public void setPost_ava(String post_ava) {
		this.post_ava = post_ava;
	}
	public int getStd_num() {
		return std_num;
	}
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}
	public int getPost_pno() {
		return post_pno;
	}
	public void setPost_pno(int post_pno) {
		this.post_pno = post_pno;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getPost_gno() {
		return post_gno;
	}
	public void setPost_gno(int post_gno) {
		this.post_gno = post_gno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", board_no=" + board_no
				+ ", post_pno=" + post_pno + ", post_gno=" + post_gno
				+ ", title=" + title + ", post_contents=" + post_contents
				+ ", std_num=" + std_num + ", post_date=" + post_date
				+ ", post_ava=" + post_ava + "]";
	}
	
	
	

	
	
	
}
