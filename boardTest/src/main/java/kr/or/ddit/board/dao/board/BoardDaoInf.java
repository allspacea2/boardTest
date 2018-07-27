package kr.or.ddit.board.dao.board;

import java.util.List;

import kr.or.ddit.board.model.board.BoardVo;

public interface BoardDaoInf {

	
	/**
	* Method : getBoardByStudentID
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC10
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 : 로그인한 학생의 고유식별번호(std_num)을 이용해서 
	* 			    그 학생이 만들 게시판을 모두 불러온다. 
	*/
	List<BoardVo> getBoardByStudentID(int std_id);
	
	
	/**
	* Method : getAvaBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 사용 가능한 게시판만 불러오는 메서드
	*/
	List<BoardVo> getAvaBoard();
	
	
	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보 가져오기
	*/
	List<BoardVo> getAllBoard();
	
	/**
	* Method : setBoardInsert
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : boardVo객체를통해 새로운 게시판을 insert
	*/
	int setBoardInsert(BoardVo boardVo);
	
	/**
	* Method : oneBoardUpdate
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 :board_no(PK)를 받아 게시판 이름과, ava를 수정하는 메서드
	*/
	int oneBoardUpdate(BoardVo boardVo);
	
	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : board_no로 이름불러오기
	*/
	String getBoardName(int board_no);
	
	
	/**
	* Method : getPostByBoardId
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : board_no 로 해당 게시판의 모든 게시글 수 가져오기
	*/
	int getPostByBoardId(int board_no);
}
