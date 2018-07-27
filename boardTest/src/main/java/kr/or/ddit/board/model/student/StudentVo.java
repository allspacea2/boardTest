package kr.or.ddit.board.model.student;

import java.util.Date;

public class StudentVo {

	// STUDENT VO
	private int std_num; // ID 학생번호(PK)
	private String std_id; // 아이디 학생아이디
	private String pass; // 비밀번호 비밀번호
	private String name; // 이름 학생이름
	private int CALL_CNT; // 호출횟수
	private String addr1; // 주소
	private String addr2; // 상세주소
	private String zipcd; // 우편번호
	private String pic; // 파일이름
	private String picpath; // 파일경로
	private String picname; // 파일이름
	private Date REG_DT; // 생성날짜

	public int getStd_num() {
		return std_num;
	}

	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCALL_CNT() {
		return CALL_CNT;
	}

	public void setCALL_CNT(int cALL_CNT) {
		CALL_CNT = cALL_CNT;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public Date getREG_DT() {
		return REG_DT;
	}

	public void setREG_DT(Date rEG_DT) {
		REG_DT = rEG_DT;
	}

	public boolean validateUser(String std_id, String pass) {

		if (this.getPass().equals(pass))
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "StudentVo [std_num=" + std_num + ", std_id=" + std_id
				+ ", pass=" + pass + ", name=" + name+ ", CALL_CNT="
				+ CALL_CNT + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", zipcd=" + zipcd + ", pic=" + pic + ", picpath=" + picpath
				+ ", picname=" + picname + ", REG_DT=" + REG_DT + "]";
	}

}
