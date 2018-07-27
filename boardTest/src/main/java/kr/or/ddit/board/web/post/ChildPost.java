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
 * Servlet implementation class ChildPost
 */
@WebServlet("/childPost")
public class ChildPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("childPost의 doGet");
		//insert 할 ChildPostVo 객체를 만들어서 세팅할 수 있는 값들 저장.
		
		PostVo postVo = new PostVo();
		int std_num = Integer.parseInt(request.getParameter("std_num"));
		postVo.setStd_num(std_num);
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		postVo.setBoard_no(board_no);
		int post_gno = Integer.parseInt(request.getParameter("post_gno"));
		postVo.setPost_gno(post_gno);
		int post_pno = Integer.parseInt(request.getParameter("post_pno"));
		postVo.setPost_pno(post_pno);
		
		//request.setParameter로 저장
		request.setAttribute("childPost", postVo);
		
		//index로 뷰 위임
		request.getRequestDispatcher("/SE2/index.jsp").forward(request, response);
		;
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("childPost의 doPost");
		//새로운 글 insert 위해 postVo객체 생성
		
//		<input type="hidden" name="childPost" value="${childPost.std_num}">
//		<input type="hidden" name="childPost" value="${childPost.board_no}">
//		<input type="hidden" name="childPost" value="${childPost.post_gno}">
//		<input type="hidden" name="childPost" value="${childPost.post_pno}">
//		<input type="button" id="savebutton" value="서버전송" />
		PostVo postVo = new PostVo();
		
		//게시판 번호 입력1
		System.out.println(request.getParameter("board_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		postVo.setBoard_no(board_no);
		
		//post_pno ->  부모의 번호2
		int post_pno = Integer.parseInt(request.getParameter("post_pno"));
		System.out.println(request.getParameter("post_pno"));
		postVo.setPost_pno(post_pno);
		
		//post_gno -> 부모것 그대로 33
		int post_gno = Integer.parseInt(request.getParameter("post_gno"));
		System.out.println(request.getParameter("post_gno"));
		postVo.setPost_gno(post_gno);
		
		
		//게시글제목4
		String title = request.getParameter("title");
		postVo.setTitle(title);
				
		
		//contents5
		String post_contents = request.getParameter("smarteditor");
		System.out.println(request.getParameter("smarteditor"));
		postVo.setPost_contents(post_contents);
		
		HttpSession session = request.getSession();
		StudentVo stdVo = (StudentVo)session.getAttribute("studentVo");
		
		
		//학생 고유넘버 입력6
		int std_num = stdVo.getStd_num();
		System.out.println(request.getParameter("std_num"));
		postVo.setStd_num(std_num);
		
		//게시글 사용여부 입력7
		postVo.setPost_ava("y");
		
		
		
		//서비스 객체 소환
		PostServiceInf ps = new PostService();
		int result = ps.InsertPost(postVo);
		if(result <= 0 ){
			System.out.println("insert 실패");
		}else{
			System.out.println("insert 성공");
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
