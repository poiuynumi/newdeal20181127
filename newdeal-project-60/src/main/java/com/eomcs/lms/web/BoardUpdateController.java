package com.eomcs.lms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/update")
public class BoardUpdateController implements PageController {

  BoardDao boardDao;
  
  public BoardUpdateController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
 @Override
public String execute(
    HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
  // TODO Auto-generated method stub
  return null;
}

  
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
                                 .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setContents(request.getParameter("contents"));
      
      boardDao.update(board);
      
      // 데이터를 변경한 후 
      // 웹브라우저에게 목록 URL을 다시 요청하라고 응답한다.
      response.sendRedirect("list");
    
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}
