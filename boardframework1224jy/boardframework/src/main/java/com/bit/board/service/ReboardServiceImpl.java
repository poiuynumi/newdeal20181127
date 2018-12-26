package com.bit.board.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.board.dao.ReboardDao;
import com.bit.board.model.ReboardDto;
import com.bit.common.dao.CommonDao;
import com.bit.util.BoardConstance;

@Service
public class ReboardServiceImpl implements ReboardService {

  @Autowired
  private SqlSession sqlSesson;
  
  @Override
  public int writeArticle(ReboardDto reboardDto) {
    int seq = sqlSesson.getMapper(CommonDao.class).getNextSeq();
    reboardDto.setSeq(seq);
    reboardDto.setRef(seq);
    int cnt = sqlSesson.getMapper(ReboardDao.class).writeArticle(reboardDto);
    return cnt != 0 ? seq : 0;
  }

  @Override
  public List<ReboardDto> listArticle(Map<String, String> param) {
    int pg = Integer.parseInt(param.get("pg"));
    int end = pg * BoardConstance.LIST_COUNT;
    int start = end - BoardConstance.LIST_COUNT;
    param.put("start", Integer.toString(start));
    param.put("end", Integer.toString(end));
    return sqlSesson.getMapper(ReboardDao.class).listArticle(param);
  }

  @Override
  public ReboardDto viewArticle(int seq) {
    ReboardDto reboardDto = sqlSesson.getMapper(ReboardDao.class).viewArticle(seq);
    if(reboardDto != null) {
      sqlSesson.getMapper(CommonDao.class).updateHit(seq);
      reboardDto.setContent(reboardDto.getContent().replace("\n", "<br>"));
    }
    return reboardDto;
  }
  
  @Override
  public ReboardDto getArticle(int seq) {
   return sqlSesson.getMapper(ReboardDao.class).viewArticle(seq);
    
  }
  

  @Override
  @Transactional
  public int replyArticle(ReboardDto reboardDto) {
	  int seq = sqlSesson.getMapper(CommonDao.class).getNextSeq();
	    reboardDto.setSeq(seq);
//	    ReboardDao reboardDao = sqlSesson.getMapper(ReboardDao);
//	    ReboardDao.updateStep(reboardDto);
	    
	    int cnt = sqlSesson.getMapper(ReboardDao.class).writeArticle(reboardDto);
	    return cnt != 0 ? seq : 0;
  
  }

  @Override
  public void modifyArticle(ReboardDto reboardDto) {

  }

  @Override
  public void deleteArticle(int seq) {

  }

}
