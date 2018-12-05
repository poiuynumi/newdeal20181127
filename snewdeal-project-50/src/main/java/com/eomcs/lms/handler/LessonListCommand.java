package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonListCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {
      List<Lesson> list = lessonDao.findAll();

      for (Lesson lesson : list) {

        System.out.printf("%s, %s, %s ~ %s, %d, %d\n",
            lesson.getTitle(),
            lesson.getContents(),
            lesson.getStartDate(), 
            lesson.getEndDate(),
            lesson.getTotalHours(),
            lesson.getDayHours());

       
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}



