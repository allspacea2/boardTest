package kr.or.ddit.board.dao.post;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.post.PostVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PostDao implements PostDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	
	@Override
	public List<PostVo> getAllPostList(int board_num) {
		SqlSession session = sqlSessionFactory.openSession();		
		List<PostVo> postList = session.selectList("post.getAllPostList",board_num);
		session.close();
		
		return postList;
	}


	@Override
	public List<PostVo> getSelectPostByBoardNo(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getSelectPostByBoardNo", board_no);
		session.close();
		return postList;
	}


	@Override
	public int postAvaUpdate(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("post.postAvaUpdate", post_no);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public PostVo getPostByPost_no(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo postVo = session.selectOne("post.getPostByPost_no", post_no);
		session.close();
		return postVo;
	}


	@Override
	public int InsertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("post.InsertPost", postVo);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int InsertNewPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("post.InsertNewPost", postVo);
		session.commit();
		session.close();
		return result;
	}


	@Override
	public int MaxPost_no() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("post.MaxPost_no");
		session.close();
		return result;
	}


	@Override
	public int postUpdate(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int result = session.update("post.postUpdate", postVo);
			session.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC10
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 차례대로 다 뽑아내는 메서드
	*/
	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getPostPageList",map);
		session.close();
		return postList;
	}


	@Override
	public int getPostTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int call = 0 ; 
		int postTotCnt = session.selectOne("post.getPostTotCnt",call);
		session.close();
		return postTotCnt;
	}


}
