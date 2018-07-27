package kr.or.ddit.board.dao.file;

import java.util.List;

import kr.or.ddit.board.model.file.FileVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FileDao implements FileDaoInf{

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<FileVo> getFilePost_no(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();	
		List<FileVo> fileVo = session.selectList("file.getFilePost_no", post_no);
		session.close();
		return fileVo;
	}
	
	
	@Override
	public int insertfile(FileVo fileVo) {
		SqlSession session = sqlSessionFactory.openSession();	
		int result = session.selectOne("file.insertfile", fileVo);
		session.commit();
		session.close();
		return result;
	}

}
