package kr.or.ddit.board.dao.rep;

import java.util.List;

import kr.or.ddit.board.model.rep.RepVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class RepDao implements RepDaoInf{

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	
	@Override
	public List<RepVo> getRepByPost_no(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<RepVo> repVo = session.selectList("rep.getRepByPost_no", post_no);
		session.close();
		
		return repVo;
		
	}


	/**
	* Method : insertRep
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC10
	* 변경이력 :
	* @param repVo
	* @return
	* Method 설명 : RepVo객체를 넘겨받아 입력을 하고, 결과값을 int형으로 반환한다. 
	*/
	@Override
	public int insertRep(RepVo repVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("rep.insertRep", repVo);
		session.commit();
		session.close();
		return result;
	}

}
