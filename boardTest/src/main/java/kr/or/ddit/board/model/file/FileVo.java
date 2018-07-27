package kr.or.ddit.board.model.file;

public class FileVo {
	
	private int file_no; 			//file 번호
	private int post_no;			//file이 속한 게시물 번호
	private String file_realname;	//file의 실제 이름 
	private String file_path;		//file의 경로
	private String file_name;		//file이 db에 저장되는 경로 
	
	
	
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getFile_realname() {
		return file_realname;
	}
	public void setFile_realname(String file_realname) {
		this.file_realname = file_realname;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	
	@Override
	public String toString() {
		return "FilesVo [file_no=" + file_no + ", post_no=" + post_no
				+ ", file_realname=" + file_realname + ", file_path="
				+ file_path + ", file_name=" + file_name + "]";
	}
	
	
	

}
