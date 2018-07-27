package kr.or.ddit.board.service.rep;

import java.util.List;

import kr.or.ddit.board.dao.rep.RepDao;
import kr.or.ddit.board.dao.rep.RepDaoInf;
import kr.or.ddit.board.model.rep.RepVo;

public class RepService implements RepServiceInf {

	@Override
	public List<RepVo> getRepByPost_no(int post_no) {
		RepDaoInf repDao = new RepDao();
		return repDao.getRepByPost_no(post_no);
	}

	@Override
	public int insertRep(RepVo repVo) {
		RepDaoInf repDao = new RepDao();
		
		return repDao.insertRep(repVo);
	}

}
