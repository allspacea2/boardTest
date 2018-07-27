package kr.or.ddit.board.dao.file;

import java.util.List;

import kr.or.ddit.board.model.file.FileVo;

public interface FileDaoInf {
	
	/**
	* Method : getFilePost_no
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 게시글 번호로 해당 게시글에 포함되어있는 파일을 불러온다. 
	*/
	List<FileVo> getFilePost_no(int post_no);
	
	
	
	
	/**
	* Method : insertfile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 업로드 메서드
	*/
	int insertfile(FileVo fileVo);

}
