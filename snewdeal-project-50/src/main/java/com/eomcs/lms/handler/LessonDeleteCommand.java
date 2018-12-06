package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteCommand implements Command {
  
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonDeleteCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }
  
  public void execute() {
    try {
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      if (lessonDao.delete(no) > 0) // 입력받은 번호에 대한 Dao.delete작업 수행
      System.out.print("삭제했습니다!");
      
      else
        System.out.println("해당 수업을 찾을 수 없습니다.");
          
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
