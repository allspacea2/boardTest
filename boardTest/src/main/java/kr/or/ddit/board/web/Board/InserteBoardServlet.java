package kr.or.ddit.board.web.Board;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class BoardCreateServlet
 */
@WebServlet("/inserteBoard")
public class InserteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardServiceInf boardService = new BoardService();
		//board_no 	= 시퀀스 자동삽입
		//board_date = sysdate 자동삽입
		
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		
		//새로운 boardVo객체 생성
		BoardVo boardVo = new BoardVo();
		
		//std_num  	= 학생번호 Session에서 받기
		int std_num = studentVo.getStd_num();
		boardVo.setStd_num(std_num);
		
		//board_name requestParameter  -> insertBoardName
		String newName = request.getParameter("insertBoardName");
		boardVo.setBoard_name(newName);
		
		//board_ava = requestParameter -> insertBoardYN
		String yn = request.getParameter("insertBoardYN");
		boardVo.setBoard_ava(yn);
		
		//board_writer = 학생이름 Session에서 받기
		boardVo.setBoard_writer(studentVo.getName());
		
		
		int result = boardService.setBoardInsert(boardVo);
		if(result>0){
			List<BoardVo> boardvo = boardService.getAllBoard();
			List<BoardVo> avaBoardVo = boardService.getAvaBoard();
			ServletContext application = getServletConfig().getServletContext();
			application.setAttribute("board", boardvo);
			application.setAttribute("avaBoard", avaBoardVo);
			
//			request.setAttribute("board", boardvo);
//			request.setAttribute("avaBoard", avaBoardVo);
			request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp").forward(request, response);
		}
		
	}


}
