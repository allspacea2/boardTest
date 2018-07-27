package kr.or.ddit.board.web.Reply;

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
 * Servlet implementation class InputReply
 */
@WebServlet("/inputReply")
public class InputReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		RepVo repVO = new RepVo();
		
		PostServiceInf bs = new PostService();
		
		PostVo postVo= bs.getPostByPost_no(post_no);
		request.setAttribute("post", postVo);
		
		//게시글 번호
		repVO.setPost_no(post_no);			
		
		//댓글내용
		String rep_contents = request.getParameter("insertBoardName");
		repVO.setRep_contents(rep_contents);
		
		//작성자
		HttpSession session = request.getSession();
		StudentVo studentVo = (StudentVo)session.getAttribute("studentVo");
		String rep_writer = studentVo.getName();
		repVO.setRep_writer(rep_writer);	

		//작성자
		int std_num = studentVo.getStd_num();
		repVO.setStd_num(std_num);			//작성자 고유넘버
		
		
		//댓글입력
		RepServiceInf reps = new RepService();
		int result = reps.insertRep(repVO);
		
		if(result==0){
			response.sendRedirect("/jsp/board/postDetail.jsp");
			System.out.println("입력실패");
		}else{
			// post_no로 댓글들들을 가져오기
			RepServiceInf rs = new RepService();
			List<RepVo> repVo = (List<RepVo>)rs.getRepByPost_no(post_no);
			request.setAttribute("repVo", repVo);
			request.getRequestDispatcher("/jsp/board/postDetail.jsp").forward(request, response);
		}
		
		
	}


}
