package com.eomcs.lms.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Component("/board/add")
public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  BoardDao boardDao;
  
  
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
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    
    request.setAttribute("lessons", lessons);
    
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/form.jsp");
    rd.forward(request, response);
  }
  
 
    
    try {
      
      Board board = new Board();
      board.setContents(request.getParameter("contents"));
      
      Member loginUser = 
          (Member) request.getSession().getAttribute("loginUser");
      board.setWriterNo(loginUser.getNo());
      
      board.setLessonNo(Integer.parseInt(
          request.getParameter("lessonNo")));
      
      boardDao.insert(board);
      
     
    
    } 
}








