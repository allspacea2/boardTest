package kr.or.ddit.board.web.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.board.BoardVo;
import kr.or.ddit.board.model.student.StudentVo;
import kr.or.ddit.board.service.board.BoardService;
import kr.or.ddit.board.service.board.BoardServiceInf;
import kr.or.ddit.board.service.student.StudentService;
import kr.or.ddit.board.service.student.StudentServiceInf;
import kr.or.ddit.encrypt.kisa.seed.KISA_SEED_CBC;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String std_id = request.getParameter("std_id");
		String pw = request.getParameter("pw");
		String encryptPw = KISA_SEED_CBC.Encrypt(pw);
		//로그인 프로세스 
		StudentServiceInf studentService = new StudentService();
		BoardServiceInf boardService = new BoardService();
		//login id를 받아서 std_id로 해당 학생 vo를 가져오기.
		StudentVo studentVo = studentService.getStudentByStd_id(std_id);
		
		
		//학생의 고유넘버로 그에 해당하는 boardVo를 리스트로 뽑아오기
		List<BoardVo> boardVo = boardService.getAllBoard();
		List<BoardVo> avaBoardVo = boardService.getAvaBoard();
		
		//userService에서 받아온 userVo의 정보와 사용자가 입력한 정보가 동일할경우
		//[로그인 성공] 메세지를 화면에 출력
		//정보가 틀릴경우
		//[로그인 실패] 메세지를 화면에 출력 
		
		//로그인 성공시 : forward/main.jsp  : main.jsp 
		//로그인 실패시 : redirect/login.jsp 
		
		//로그인 성공시 userVo 객체를 저장하여 (적당한 영역에)
		//main.jsp에서 사용자 아이디를 화면에 출력
		//단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야 한다. 
		//-> ssesionScope 사용
		if(studentVo.validateUser(std_id, encryptPw)){
			HttpSession session = request.getSession();
			session.setAttribute("studentVo", studentVo);
			
			//로그인 성공시 해당id/num을 통해 가져온 값 session속성으로 세팅해주기
			//studentVo -> 학생정보를 갖고 있는 Vo List
			//boardVo 	-> 학생에대한 게시판 정보를 갖고 있는 Vo List
			ServletContext application = getServletConfig().getServletContext();
			application.setAttribute("board", boardVo);
			application.setAttribute("avaBoard", avaBoardVo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp");
			rd.forward(request, response);
			
		} else {
			//response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response); 
		}
	
	
	}
}
