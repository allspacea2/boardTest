package kr.or.ddit.board.model.board;

import java.util.Date;

public class BoardVo {
	
	
	
	//BOARD
	private int board_no;			//(PK)	게시판번호	NUMBER	NOT NULL
	private int	std_num;		//(FK)	ID	학생번호(FK)NUMBER	NULL
	private String board_name;		//게시판이름	VARCHAR2(100)	NULL
	private String board_ava;		//사용여부	CHAR	NULL
	private String board_writer;	//작성자	VARCHAR2(50)	NULL
	private Date board_date;		//작성일시	DATE	NULL
	
	
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getStd_num() {
		return std_num;
	}
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_ava() {
		return board_ava;
	}
	public void setBoard_ava(String board_ava) {
		this.board_ava = board_ava;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", std_num=" + std_num
				+ ", board_name=" + board_name + ", board_ava=" + board_ava
				+ ", board_writer=" + board_writer + ", board_date="
				+ board_date + "]";
	}

	
	

}
