package kr.or.ddit.board.service.board;

import java.util.List;

import kr.or.ddit.board.dao.board.BoardDao;
import kr.or.ddit.board.dao.board.BoardDaoInf;
import kr.or.ddit.board.model.board.BoardVo;

public class BoardService implements BoardServiceInf{

	/**
	* Method : getBoardByStudentID
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC10
	* 변경이력 :
	* @param std_id
	* @return
	* Method 설명 :로그인한 학생의 고유식별번호(std_num)을 이용해서 그 학생이 만들 게시판을 모두 불러온다. 
	*/
	@Override
	public List<BoardVo> getBoardByStudentID(int std_id) {
		
		BoardDaoInf boardDao = new BoardDao();
		
		return boardDao.getBoardByStudentID(std_id);
	}

	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보 가져오기
	*/
	@Override
	public List<BoardVo> getAllBoard() {
		BoardDaoInf boardDao = new BoardDao();
		
		return boardDao.getAllBoard();
	}

	@Override
	public int setBoardInsert(BoardVo boardVo) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.setBoardInsert(boardVo);
	}

	/**
	* Method : getAvaBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 사용 가능한 게시판만 가져오는 메서드
	*/
	@Override
	public List<BoardVo> getAvaBoard() {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getAvaBoard();
	}

	@Override
	public int oneBoardUpdate(BoardVo boardVo) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.oneBoardUpdate(boardVo);
	}

	@Override
	public String getBoardName(int board_no) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getBoardName(board_no);
	}

	@Override
	public int getPostByBoardId(int board_no) {
		BoardDaoInf boardDao = new BoardDao();
		return boardDao.getPostByBoardId(board_no);
	}

}
