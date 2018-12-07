package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

  BoardDao boardDao;
  LessonDao lessonDao;

  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }

  @RequestMapping("add")
  public String add(
      HttpServletRequest request, HttpServletResponse response)
          throws Exception {
   

    Board board = new Board();
    board.setContents(request.getParameter("contents")); 
    //request를 이용해contents에서 불러온 값을 contents에 넣는다

    Member loginUser = 
        (Member) session.getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());

    board.setLessonNo(Integer.parseInt(
        request.getParameter("lessonNo")));

    boardDao.insert(board);

    return "redirect:list";
  }
  
  @RequestMapping("delete")
  public String delete(
      int no, Model model) throws Exception {
    model.setAttribute("count", boardDao.delete(no));
       return "board/delete";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
      
      Board board = boardDao.findByNo(no);
     model.Attribute("board", board);
      
      return "board/detail";
// model(빈그릇) 생성 후 여기에 담고 꺼내 쓰도록 한다 ->request,response 사용하지 않아도 됨
// model에 담는 이유 : jsp가 아닌 다를 것을 쓸 때도 꺼내서 사용할 수 있도록 하기 위해 (중간 바구니 역할)
  }
  
  @RequestMapping("form")
  public String form(
      HttpSession session, Model model) throws Exception {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    request.setAttribute("lessons", lessons);
    
    return "board/form";
  }
  
  @RequestMapping("list")
  public ModelAndView list() throws Exception {
    ModelAndView mv = new ModelAndView();
    
    List<Board> list = boardDao.findAll();
    mv.addObject("list", list);
    mv.setViewName("board/list");
    

    return "board/list";
  }
  
  @RequestMapping("update")
  public String update(Board board)throws Exception {

    boardDao.update(board);

    return "redirect:list";
  }
}








