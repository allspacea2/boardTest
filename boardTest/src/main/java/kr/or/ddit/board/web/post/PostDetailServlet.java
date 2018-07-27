package kr.or.ddit.board.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.file.FileVo;
import kr.or.ddit.board.model.post.PostVo;
import kr.or.ddit.board.model.rep.RepVo;
import kr.or.ddit.board.service.file.FileService;
import kr.or.ddit.board.service.file.FileServiceInf;
import kr.or.ddit.board.service.post.PostService;
import kr.or.ddit.board.service.post.PostServiceInf;
import kr.or.ddit.board.service.rep.RepService;
import kr.or.ddit.board.service.rep.RepServiceInf;

/**
 * Servlet implementation class PostDetail
 */
@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet");
		// 클릭한 게시글번호 넘겨받기
		int id = Integer.parseInt(request.getParameter("id"));
		FileServiceInf fileService = new FileService();
		// 클릭한 게시글 번호로 해당 포스트에 있는 첨부파일 가져오기 
		List<FileVo> fileVo = fileService.getFilePost_no(id);
		// post_no 번호를 통해서 해당 PostVo를 가져온다. 
		PostServiceInf ps = new PostService();
		RepServiceInf rs = new RepService();
		
		// post_no로 postVo를 반환하는 메서드를 이용
		PostVo postVo = ps.getPostByPost_no(id);
		
		String modiContents = request.getParameter("modiContents");
		String modiTitle = request.getParameter("modiTitle");
		System.out.println("modiContents 는 : " + modiContents);
		System.out.println("modiTitle 는 : "+ modiTitle);
		int result = 0;
		if(modiContents != null && modiTitle !=  null){
			postVo.setPost_contents(modiContents);
			postVo.setTitle(modiTitle);
			result = ps.postUpdate(postVo);
		}
		
		System.out.println("request.getAttribute(\"result\")" + request.getAttribute("result"));
		System.out.println("업데이트 결과값은 : "+ result);
		request.setAttribute("post", postVo);
		
		// post_no로 댓글들들을 가져오기
		List<RepVo> repVo = (List<RepVo>)rs.getRepByPost_no(id);
		
		request.setAttribute("repVo", repVo);
		request.getRequestDispatcher("/jsp/board/postDetail.jsp").forward(
				request, response);
	}

	
	
	protected void doPost(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//int id = Integer.parseInt(request.getParameter("post_no"));
		
		System.out.println(request.getParameter("board_no"));
		//게시물번호
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		PostServiceInf ps = new PostService();
		
		//게시물 번호로 해당 게시물Vo 가져오기
		PostVo postVo = ps.getPostByPost_no(post_no);
		//contents 내용을 <p> 단락 빼고 수정해주기
		String s = postVo.getPost_contents();
		if(s.startsWith("<p>")){
			postVo.setPost_contents(parser(postVo.getPost_contents()));
		}
		request.setAttribute("post", postVo);
		
		request.getRequestDispatcher("/jsp/board/postModify.jsp").forward(request, response);
		

	}
	
	private String parser(String contents){
		String content = contents.substring(3, contents.length()-4);
		return content;
	}

}
