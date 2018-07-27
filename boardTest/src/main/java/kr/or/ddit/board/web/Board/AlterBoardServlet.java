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
 * Servlet implementation class AlterBoardServlet
 */
@WebServlet("/alterBoard")
public class AlterBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
//		System.out.println("가져온  board_no는? : " + request.getParameter("board_no"));
//		System.out.println("사용 가능 여부는 ? : " + request.getParameter("boardYN"));
//		System.out.println("변경게시판이름은 : " + request.getParameter("updateBoardName"));
//		System.out.println("변경전게시판 이름은 :  "+ request.getParameter("oldBoardName"));
		//insertBoardmain.jsp 에서 수정한 값 받아오기
		//boardNum -> 선택한 게시판 번호 가져오기
		
		//boardYN -> 게시판 사용여부 문자 가져오기 
		
		BoardServiceInf boardService = new BoardService();
		
		//변경될 값 넣은 Vo객체 생성
		BoardVo board_Vo = new BoardVo();
		
		//변경된 ava 값
		String ava = request.getParameter("boardYN");
		board_Vo.setBoard_ava(ava);
		//변경된 게시판제목내용
		String newBoardName = request.getParameter("updateBoardName");
		board_Vo.setBoard_name(newBoardName);
		//게시판 번호는 원래것 그대로
		int num = Integer.parseInt(request.getParameter("board_no"));
		board_Vo.setBoard_no(num);
		//게시판만든놈
		String writer = studentVo.getName();
		board_Vo.setBoard_writer(writer);
		//만든놈넘버
		int std_num = studentVo.getStd_num();
		board_Vo.setStd_num(std_num);
		
		int success = boardService.oneBoardUpdate(board_Vo);
		if(success > 0){
			
			List<BoardVo> boardVo = boardService.getAllBoard();
			List<BoardVo> avaBoardVo = boardService.getAvaBoard();
			ServletContext application = getServletConfig().getServletContext();
			application.setAttribute("board", boardVo);
			application.setAttribute("avaBoard", avaBoardVo);
			
			
//			request.setAttribute("board", boardvo);
//			request.setAttribute("avaBoard", avaBoardVo);
			request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp").forward(request, response);

		}
		
		//session 객체로 가져온 Vo리스트에서 해당 게시판 가져와서 값 변경해주고 그 값을 DB에 저장해야하는데,,, 
		//request.getRequestDispatcher("/jsp/board/insertBoardmain.jsp").forward(request, response);
	}


}

