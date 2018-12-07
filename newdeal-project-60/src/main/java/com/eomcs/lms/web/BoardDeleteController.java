package com.eomcs.lms.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteController implements PageController {
 
  BoardDao boardDao;
  
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
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      request.setAttribute("count", boardDao.delete(no));
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/delete.jsp");
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}





