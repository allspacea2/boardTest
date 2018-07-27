package kr.or.ddit.board.web.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.board.BoardVo;
import kr.or.ddit.board.model.post.PostVo;
import kr.or.ddit.board.service.board.BoardService;
import kr.or.ddit.board.service.board.BoardServiceInf;
import kr.or.ddit.board.service.post.PostService;
import kr.or.ddit.board.service.post.PostServiceInf;

/**
 * Servlet implementation class MakePostServlet
 */
@WebServlet("/makePost")
public class MakePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardVo = boardService.getAllBoard();
		ServletContext application = getServletConfig().getServletContext();
		application.setAttribute("board", boardVo);
		// request.setAttribute("board", boardVo);
		// board_no 를 통해서 해당 POST 정보를 다 가져온다.

		PostServiceInf postService = new PostService();
		// 클릭한 게시판 이름 세팅
		int board_num = Integer.parseInt(request.getParameter("id"));
		String boardName = boardService.getBoardName(board_num);
		request.setAttribute("boardName", boardName);

		request.setAttribute("board_num", board_num);

		List<PostVo> postVo = postService.getAllPostList(board_num);
		request.setAttribute("postVo", postVo);
		// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────
		// 링크를 통해서 오기 때문에 doGet 메서드를 사용한다.
		// PostService 객체를 생성, 전체 게시물 리스트를 조회한다.
		// 전체 게시물 리스트를 request 객체에 속성으로 설정한다.
		// postList.jsp로 forward 한다.

		// page, pageSize 파라미터
		// parameter -> 이용자가 넘기는 값
		// Attribute -> 개랍자가 임시적으로 저장해놓는 값

		// parameter로 전달된 "page"를 받는다.
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");

		// parameter 값이 넘어오지 않을 경우를 대비해 기본적으로 page:1 pageSize:10을 설정해놓는다.
		int page = (pageStr == null ? 1 : Integer.parseInt(request
				.getParameter("page")));
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(request
				.getParameter("pageSize"));

		System.out.println("page 는 : " + page);
		System.out.println("pageSize는 : " + pageSize);
		System.out.println("parameter id 는 : " + request.getParameter("id"));

		// 가져온 값을 Map으로 저장하기
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);

		int board_no = Integer.parseInt(request.getParameter("id"));
		// 게시물 전체 건수 조회 -> 안되. 해당 게시판의 게시물 수를 가져와야되.
		paramMap.put("board_no", board_no);
		Map<String, Object> resultMap = postService.getPostPageList(paramMap);

		// 페이지 리스트 가져오기
		List<PostVo> postList = (List<PostVo>) resultMap.get("pageList");
		// 페이지 리스트가져오기
		request.setAttribute("postVo", postList);

		// 전체 게시물 수 가져오기
		int totCnt = (int) resultMap.get("totCnt");
		request.setAttribute("post_num", totCnt);

		// PageNation 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);

		request.getRequestDispatcher("/jsp/board/postmake.jsp").forward(
				request, response);

		// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
