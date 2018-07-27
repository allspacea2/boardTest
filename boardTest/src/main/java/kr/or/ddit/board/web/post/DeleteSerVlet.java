package kr.or.ddit.board.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.post.PostVo;
import kr.or.ddit.board.service.board.BoardService;
import kr.or.ddit.board.service.board.BoardServiceInf;
import kr.or.ddit.board.service.post.PostService;
import kr.or.ddit.board.service.post.PostServiceInf;

@WebServlet("/postDelete")
public class DeleteSerVlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PostServiceInf postService = new PostService();
		BoardServiceInf boardService = new BoardService();
		//게시글 번호 받아오기
		int post_no = Integer.parseInt(request.getParameter("delPost_num"));
		int board_no = Integer.parseInt(request.getParameter("delBoard_no"));
		int result = postService.postAvaUpdate(post_no);
		if(result >0){
			List<PostVo> postVo = (List<PostVo>)postService.getAllPostList(board_no);
			String board_name =  boardService.getBoardName(board_no);
			
			//게시판 이름 세팅
			request.setAttribute("boardName", board_name);
			//게시판 번호세팅
			request.setAttribute("board_num", board_no);
			//게시물 세팅
			request.setAttribute("postVo", postVo);
			request.getRequestDispatcher("/jsp/board/postmake.jsp").forward(request, response);
		}
		
		System.out.println("doPost");
		System.out.println("delPost_num : " +request.getParameter("delPost_num"));
		System.out.println("delpostVo : " + request.getParameter("delpostVo"));
		
	}

}
