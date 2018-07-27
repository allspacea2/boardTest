package kr.or.ddit.board.dao.post;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.post.PostVo;

public interface PostDaoInf {
	
	/**
	* Method : post_contents
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 모든 글 리스트를 반환하는 메서드 
	*/
	List<PostVo> getAllPostList(int board_num);
	
	
	/**
	* Method : getPostByPost_no
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : post_no로 해당 postVo객체를 반환하는 메서드
	*/
	PostVo getPostByPost_no(int post_no);
	
	/**
	* Method : getSelectPostByBoardNo
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : board번호로 해당 글을 다 긁어오기
	*/
	List<PostVo> getSelectPostByBoardNo(int board_no);
	
	/**
	* Method : postAvaUpdate
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 번호를 받아서 해당 게시물에 대해서 사용구분을 정해준다. 
	*/
	int postAvaUpdate(int post_no);
	
	
	/**
	* Method : InsertPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : PostVo객체로 새로운 글 생성 메서드
	*/
	int InsertPost(PostVo postVo);
	
	
	/**
	 * Method : InsertPost
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : PC10
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : PostVo객체로 새로운 글 생성 메서드
	 */
	int InsertNewPost(PostVo postVo);
	
	
	/**
	* Method : MaxPost_no
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 가장 큰 post_no 가져오는 메서드
	*/
	int MaxPost_no();
	
	
	/**
	* Method : postUpdate
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : PostVo의 post_no를 받아서 해당 title과 contents를 update 
	*/
	int postUpdate(PostVo postVo);
	
	
	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이징 처리하기
	*/
	List<PostVo>getPostPageList(Map<String, Integer> map);
	
	
	
	/**
	* Method : getPostTotCnt
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시물 수를 반환하는 메서드
	*/
	int getPostTotCnt();

}
