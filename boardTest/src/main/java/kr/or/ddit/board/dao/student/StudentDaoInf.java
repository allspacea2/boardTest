package kr.or.ddit.board.dao.student;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.student.StudentVo;

public interface StudentDaoInf {

	List<StudentVo> selectAllStudents();
	
	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : id로 한명의 정보 얻어오기
	 */
	StudentVo getStudent(int id);
	
	
	
	
	/**
	* Method : getStudentByStd_id
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC10
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 :std_id 로 해당 학생의 studentVo 가져오기
	*/
	StudentVo getStudentByStd_id(String id);
	
	/**
	 * 
	* Method : getStudentTestByVo
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생 정보 조회
	 */
	StudentVo getStudentTestByVo(StudentVo studentVo);

	/**
	 * 
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 페이징 처리
	 */
	List<StudentVo>getStudentPageList(Map<String, Integer> map);
	
	
	/**
	* Method : getStudentTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 모든 학생의 수를 가져오는 메서드
	*/
	int getStudentTotCnt();

	/**
	 * Method : setStudentInsert
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 테이블에 insert 
	 */
	int setStudentInsert(StudentVo studentVo);
	

	/**
	 * Method : setOneUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 정보 업데이트
	 */
	int setOneUpdate(StudentVo studentVo);
}

