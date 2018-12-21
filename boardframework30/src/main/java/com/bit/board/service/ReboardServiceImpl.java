package com.bit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.board.common.dao.CommonDao;
import com.bit.board.dao.ReboardDao;
import com.bit.board.model.ReboardDto;
@Service
public class ReboardServiceImpl implements ReboardService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		System.out.println(reboardDto +"??????");
		int seq = sqlSession.getMapper(CommonDao.class).getNextSeq();
		
		System.out.println("seq : "  + seq);
		
		reboardDto.setSeq(seq);	//새글일때는 글번호와 그룹번호가 같다
		reboardDto.setRef(seq);
		int cnt = sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
		return cnt != 0 ? seq : 0;	//0이면 실패, 글번호가 있으면 성공
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> param) {
		return null;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
	}

	@Override
	public ReboardDto replyArticle(int seq) {
		return null;
	}

	@Override
	public void modifyArticle(ReboardDto reboardDto) {
	}

	@Override
	public void deleteArticle(int seq) {
	}

}
