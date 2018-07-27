package kr.or.ddit.board.model.rep;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RepVo {
	
	private int rep_no;			//답글번호
	private int post_no;		//게시글번호
	private String rep_writer;	//작성자이름
	private Date rep_date;		//작성날짜
	private String rep_contents;//작성내용
	private int std_num;		//작성자고유넘버
	
	
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getRep_writer() {
		return rep_writer;
	}
	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}
	public String getRep_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(rep_date);
	}
	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}
	public String getRep_contents() {
		return rep_contents;
	}
	public void setRep_contents(String rep_contents) {
		this.rep_contents = rep_contents;
	}
	public int getStd_num() {
		return std_num;
	}
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}

	
	@Override
	public String toString() {
		return "RepVo [rep_no=" + rep_no + ", post_no=" + post_no
				+ ", rep_writer=" + rep_writer + ", rep_date=" + rep_date
				+ ", rep_contents=" + rep_contents + ", std_num=" + std_num
				+ "]";
	}
}
