package kr.or.ddit.board.web.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.student.StudentVo;
import kr.or.ddit.board.service.student.StudentService;
import kr.or.ddit.board.service.student.StudentServiceInf;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentServiceInf studentService = new StudentService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//link를 통해서 오기때문에 doGet 메서드를 활용
		//StudentService 객체를 생성, 학생 전체 리스트를 조회
		// 학생 전체 리스트를request 객체에 속성으로 설정 
		//studentList.jsp로 forward
		
		//──────────────────────────────────────────────────────────────────────────────────────────────────
		
		//page, pageSize 파라미터
		//parameter, attribute 
		//parameter - 이용자가 넘기는 값
		//attribute - 개발자가 임시적으로 저장해놓는 값
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		
		
		//──────────────────────────────────────────────────────────────────────────────────────────────────
		
		//parameter 값이 안넘어올 경우를 대비해서 기본 값으로 page:1, pageSize:10 을 기본값으로 세팅해놓기
		int page = pageStr == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(request.getParameter("pageSize"));
		
		//──────────────────────────────────────────────────────────────────────────────────────────────────
		
		//가져온 값을 map으로 저장하기
		Map<String, Integer> parmaMap = new HashMap<String, Integer>();
		parmaMap.put("page", page);
		parmaMap.put("pageSize", pageSize);
		
		//──────────────────────────────────────────────────────────────────────────────────────────────────
		
		//학생 페이지 리스트, 전체 건수 조회
		Map<String, Object> resultMap = studentService.getStudentPageList(parmaMap);
		
		//페이지리스트가져오기
		List<StudentVo> studentList = (List<StudentVo>)resultMap.get("pageList"); 
		
		//전체 학생 수 가져오기
		int totCnt = (int)resultMap.get("totCnt");
		request.setAttribute("studentList", studentList);
		
		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		
		//기존 List<StudentVo> stdVo = studentService.selectAllStudents();
		//request.setAttribute("stdVoList", stdVo);
		//RequestDispatcher 객체 만들고 포워드 request 객체를 이용해서 포워드 위치 정하기
		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		rd.forward(request, response);
		
	}


}
