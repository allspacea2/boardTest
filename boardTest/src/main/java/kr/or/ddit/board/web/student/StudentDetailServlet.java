package kr.or.ddit.board.web.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.student.StudentVo;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		//학생 id를 파라미터확인
		int id = Integer.parseInt(studentVo.getStd_id());
		System.out.println("학생의 id는 : "+ id);
		//service 학생 정보를 조회
		
		//request 객체에 저장
		request.setAttribute("studentVo", studentVo);
		// student/studentDetail.jsp로 위임
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
	}

	
}
