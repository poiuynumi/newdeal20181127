package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      Lesson lesson = lessonDao.findByNo(no);           
      lessonDao.update(lesson);      
      System.out.println("변경했습니다!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
