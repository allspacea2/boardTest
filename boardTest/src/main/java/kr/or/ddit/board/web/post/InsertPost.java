package kr.or.ddit.board.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.post.PostVo;
import kr.or.ddit.board.model.rep.RepVo;
import kr.or.ddit.board.model.student.StudentVo;
import kr.or.ddit.board.service.post.PostService;
import kr.or.ddit.board.service.post.PostServiceInf;
import kr.or.ddit.board.service.rep.RepService;
import kr.or.ddit.board.service.rep.RepServiceInf;

/**
 * Servlet implementation class InsertPost
 */
@WebServlet("/insertPost")
public class InsertPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doPost");
		//새로운 글 insert 위해 postVo객체 생성
		PostVo postVo = new PostVo();
		
		//게시판 번호 
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		//해당글 사용여부
		
		//해당글 내용
		String post_contents = request.getParameter("smarteditor");
		//postVo.setPost_contents(post_contents);
		
		//session으로 뽑아서 넣어주기
		HttpSession session = request.getSession();
		StudentVo sVo = (StudentVo)session.getAttribute("studentVo");
		//학생고유넘버 저장
		int std_num = sVo.getStd_num();
		String title = request.getParameter("title");
		postVo.setBoard_no(board_no);
		postVo.setTitle(title);
		postVo.setPost_ava("y");
		postVo.setPost_contents(post_contents);
		postVo.setStd_num(std_num);
		
		
		PostServiceInf ps = new PostService();
		
		int result = ps.InsertNewPost(postVo);
		
		if(result ==0 ){
			System.out.println("글 입력 실패");
		}else{
			int id = ps.MaxPost_no();
			
			// 게시판 번호를 통해서 해당게시판의 모든 post글을 가져온다.
			// post_no로 postVo를 반환하는 메서드를 이용
			RepServiceInf rs = new RepService();
			PostVo postVo1 = ps.getPostByPost_no(id);
			request.setAttribute("post", postVo1);
			
			// post_no로 댓글들들을 가져오기
			List<RepVo> repVo = (List<RepVo>)rs.getRepByPost_no(id);
			
			request.setAttribute("repVo", repVo);
			request.getRequestDispatcher("/jsp/board/postDetail.jsp").forward(
					request, response);
		}
		
	}

}
