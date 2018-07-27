package kr.or.ddit.board.service.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.board.BoardDao;
import kr.or.ddit.board.dao.board.BoardDaoInf;
import kr.or.ddit.board.dao.post.PostDao;
import kr.or.ddit.board.dao.post.PostDaoInf;
import kr.or.ddit.board.model.post.PostVo;

public class PostService implements PostServiceInf {

	
	
	@Override
	public List<PostVo> getAllPostList(int board_num) {
		PostDaoInf postDao =  new PostDao();
		return postDao.getAllPostList( board_num);
	}

	
	
	@Override
	public List<PostVo> getSelectPostByBoardNo(int board_num) {
		PostDaoInf postDao =  new PostDao();
		return postDao.getSelectPostByBoardNo(board_num);
	}



	@Override
	public int postAvaUpdate(int post_no) {
		PostDaoInf postDao = new PostDao();
		
		return postDao.postAvaUpdate(post_no);
		
	}



	@Override
	public PostVo getPostByPost_no(int post_no) {
		PostDaoInf postDao = new PostDao();
		
		return postDao.getPostByPost_no(post_no);
	}



	@Override
	public int InsertPost(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.InsertPost(postVo);
	}

	@Override
	public int InsertNewPost(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.InsertNewPost(postVo);
	}



	@Override
	public int MaxPost_no() {
		PostDaoInf postDao = new PostDao();
		return postDao.MaxPost_no();
	}



	@Override
	public int postUpdate(PostVo postVo) {
		PostDaoInf postDao = new PostDao();
		return postDao.postUpdate(postVo);
	}



	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {
		PostDaoInf postDao = new PostDao();
		BoardDaoInf boardDao =  new BoardDao();
		
		//Map 객체 생성
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//게시물 페이지 리스트 조회 -> pageSize와 pageNumber에 따라서 나뉘어 출력되는 쿼리
		//ex -> 게시물이 30개이고, pageSize가 10이면 page가 3개 생긴다. 
		List<PostVo> pageList = postDao.getPostPageList(map);
		
		//List로 만들어 페이지 넣기
		resultMap.put("pageList", pageList);
		
		int board_no = map.get("board_no");
		
		
		//게시물 전체 건수 조회
		int totCnt = boardDao.getPostByBoardId(board_no);
		//resultMap 객체에 put해준다. 
		resultMap.put("totCnt", totCnt);
		
		
		
		//페이지 네이션 html을 생성해준다. 
		//페이지 번호
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		resultMap.put("pageNavi",makePageNavi(page,pageSize,totCnt,board_no));
		
		
		
		return resultMap;
	}
	
	
	private String makePageNavi(int page, int pageSize, int totCnt, int board_no){
		
		int cnt = totCnt / pageSize;  //전체 게시물수를 pageSize로 나눈 몫;
		int mod = totCnt % pageSize;  //나머지; 1이라도 나머지가 있을 경우 1개 추가해줘야한다. 
		if(mod>0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		int prevPage = page ==  1  ?   1  : page-1; //1페이지면 그대로 있고 아니면 1페이지 전으로 돌아가기
		int nextPage = page == cnt ? page : page+1; //마지막 페이지인지 확인하고 다음 페이지로 넘어가기
		
		int firstPage = page == 1 ? 1 : 1 ; //1페이지면 그대로, 아니어도 1페이지로
		int LastPage  = page == cnt ? page : page;
		
		//한칸 뒤로가는 화살표 추가하기  << = &laquo;  < == 	&lt;;
		pageNaviStr.append("<li><a href=\"/makePost?id=" + board_no  +"&page="+firstPage+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/makePost?id=" + board_no  +"&page="+prevPage+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&lt;</span></a></li>");
		
		//html 그려주기 
		for(int i = 1 ; i<= cnt ; i++){
			String activeClass = "";
			if(i == page)
				activeClass="class=\"active\"";
			pageNaviStr.append("<li "+activeClass+"><a href=\"/makePost?id=" + board_no  + "&page="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>");
		}
		//한 페이지 앞으로 가는 화살표 추가하기  >> = &raquo; > == &gt;
		pageNaviStr.append("<li><a href=\"/makePost?id=" + board_no  + "&page="+LastPage +"&pageSize="+pageSize+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&gt;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/makePost?id=" + board_no  + "&page="+nextPage +"&pageSize="+pageSize+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNaviStr.toString();
	}
}













