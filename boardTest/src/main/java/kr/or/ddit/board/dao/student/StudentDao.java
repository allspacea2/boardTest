package kr.or.ddit.board.dao.student;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.student.StudentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class StudentDao implements StudentDaoInf{

	
	//private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		return studentList;
	}
	@Override
	public StudentVo getStudentByStd_id(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentByStd_id", id);
		session.close();
		
		return studentVo;
	}
	

	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(int id) {
		StudentVo studentVo= null;
		SqlSession session = sqlSessionFactory.openSession();
		studentVo = session.selectOne("student.getStudentById", id);
		session.close();
		return studentVo;
	}

	@Override
	public StudentVo getStudentTestByVo(StudentVo studentVo) {
		StudentVo studentVO= null;
		SqlSession session = sqlSessionFactory.openSession();//트렌젝션이 제어됨
		studentVO = session.selectOne("student.getStudentByVo", studentVo);
		session.close();
		return studentVO;
	}

	/**
	 * 
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList",map);
		session.close();
		
		return studentList ;
	}

	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int call =0;
		int studentTotCnt = session.selectOne("student.getStudentTotCnt",call);
		session.close();
		return studentTotCnt;
	}

	@Override
	public int setOneUpdate(StudentVo studentVo) {

		SqlSession session = sqlSessionFactory.openSession();
		try{
			int count = session.update("student.setOneUpdate", studentVo);
			
			session.commit();
			session.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int setStudentInsert(StudentVo studentVo) {
		System.out.println(studentVo);
		SqlSession session = sqlSessionFactory.openSession();
		try{
			int count = session.insert("student.setStudentInsert", studentVo);
			
			session.commit();
			
			session.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	
	
}
