package kr.or.ddit.board.service.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.student.StudentDao;
import kr.or.ddit.board.dao.student.StudentDaoInf;
import kr.or.ddit.board.model.student.StudentVo;

public class StudentService implements StudentServiceInf{
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @return
	* Method 설명 : 학생 정보 전체 조회
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		StudentDaoInf stdDao = new StudentDao();
		return stdDao.selectAllStudents();
	}

	
	
	@Override
	public StudentVo getStudentByStd_id(String id) {
		StudentDaoInf stdDao = new StudentDao();
		return stdDao.getStudentByStd_id(id);
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
		StudentDaoInf stdDao = new StudentDao();
		return stdDao.getStudent(id);
	}

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
	@Override
	public StudentVo getStudentTestByVo(StudentVo studentVo) {
		StudentDaoInf stdDao = new StudentDao();
		return stdDao.getStudentTestByVo(studentVo);
	}

	
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC10
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 정보를 페이징처리 해주는 단계
	*/
	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		StudentDaoInf stdDao =  new StudentDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//학생 페이지 리스트 조회
		List<StudentVo> pageList =  stdDao.getStudentPageList(map);
		resultMap.put("pageList",pageList);
		
		//학생 전체 건수 조회
		int totCnt = stdDao.getStudentTotCnt();
		resultMap.put("totCnt",totCnt);
		
		//페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		resultMap.put("pageNavi", makePageNavi(page,pageSize,totCnt));
		
		return resultMap;
	}
	
	
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC10
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){
		
		int cnt = totCnt / pageSize; //몫
		int mod = totCnt % pageSize; //나머지
		if(mod>0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		int prevPage = page  == 1? 1:page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/studentList?page="+prevPage+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
	    
		for(int i = 1 ; i<= cnt ; i++){
			///studentList?page=1&pageSize=10
			String activeClass = "";
			if( i == page)
				activeClass="class=\"active\"";
			pageNaviStr.append("<li "+activeClass+"><a href=\"/studentList?page="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>");
		}
		pageNaviStr.append("<li><a href=\"/studentList?page="+nextPage +"&pageSize="+pageSize+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNaviStr.toString();
	}

	@Override
	public int setStudentInsert(StudentVo studentVo) {
		StudentDaoInf stdDao =  new StudentDao();
		return stdDao.setStudentInsert(studentVo);
	}

	@Override
	public int setOneUpdate(StudentVo studentVo) {
		StudentDaoInf stdDao =  new StudentDao();
		return stdDao.setOneUpdate(studentVo);
	}


}
