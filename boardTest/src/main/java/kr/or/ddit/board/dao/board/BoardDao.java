package kr.or.ddit.board.dao.board;

import java.util.List;

import kr.or.ddit.board.model.board.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf{
	
	//sqlSessionFactory 객체 얻어오기
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<BoardVo> getBoardByStudentID(int std_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getBoardByStudentID", std_id);
		session.close();
		return boardList;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllBoard");
		session.close();
		return boardList;
	}

	@Override
	public List<BoardVo> getAvaBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAvaBoard");
		session.close();
		return boardList;
	}
	
	@Override
	public int setBoardInsert(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int result = session.insert("board.setBoardInsert", boardVo);
			session.commit();
			session.close();
			return result;
			
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int oneBoardUpdate(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int result = session.update("board.oneBoardUpdate", boardVo);
			session.commit();
			session.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String getBoardName(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		String result = session.selectOne("board.getBoardName", board_no);
		session.close();
		return result;
		
	}

	@Override
	public int getPostByBoardId(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("post.getPostByBoardId", board_no);
		session.close();
		return result;
	}


}
