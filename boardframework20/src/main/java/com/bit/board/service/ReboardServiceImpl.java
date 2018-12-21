package com.bit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.bit.board.common.dao.CommonDao;
import com.bit.board.dao.ReboardDao;
import com.bit.board.model.ReboardDto;
import com.bit.util.BoardConstance;
@Service
public class ReboardServiceImpl implements ReboardService {
	private SqlSession sqlSession;

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int seq = sqlSession.getMapper(CommonDao.class).getNextSeq();
		reboardDto.setSeq(seq);	//�깉湲��씪�븣�뒗 湲�踰덊샇�� 洹몃９踰덊샇媛� 媛숇떎
		reboardDto.setRef(seq);
		int cnt = sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
		return cnt != 0 ? seq : 0;	//0�씠硫� �떎�뙣, 湲�踰덊샇媛� �엳�쑝硫� �꽦怨�
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> param) {
		int pg = Integer.parseInt(param.get("pg"));
		int end = pg * BoardConstance.LIST_COUNT;
		int start = end - BoardConstance.LIST_COUNT;
		param.put("start", start + "");
		param.put("end", end + "");
		return sqlSession.getMapper(ReboardDao.class).listArticle(param);
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		ReboardDto reboardDto = sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
		if (reboardDto != null) {
			
			//sqlSession.getMapper(CommonDao.class).updateHit();
		}
		return null;
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
