package kr.or.ddit.board.dao.rep;

import java.util.List;

import kr.or.ddit.board.model.rep.RepVo;

public interface RepDaoInf {
	
	/**
	* Method : getRepByPost_no
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시물 번호로 해당 게시물의 모든 댓글가져오기
	*/
	List<RepVo> getRepByPost_no(int post_no);

	
	
	/**
	* Method : insertRep
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param repVo
	* @return
	* Method 설명 : 답글 입력메서드
	*/
	int insertRep(RepVo repVo);
}
