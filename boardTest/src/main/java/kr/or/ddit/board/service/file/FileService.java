package kr.or.ddit.board.service.file;

import java.util.List;

import kr.or.ddit.board.dao.file.FileDao;
import kr.or.ddit.board.dao.file.FileDaoInf;
import kr.or.ddit.board.model.file.FileVo;

public class FileService implements FileServiceInf{

	@Override
	public List<FileVo> getFilePost_no(int post_no) {
		FileDaoInf fileDao =  new FileDao();
		return fileDao.getFilePost_no(post_no);
	}


	@Override
	public int insertfile(FileVo fileVo) {
		FileDaoInf fileDao =  new FileDao();
		
		 return fileDao.insertfile(fileVo);
	}
	
	
	
		

}
