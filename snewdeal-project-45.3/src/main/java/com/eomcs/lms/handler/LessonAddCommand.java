package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command { // 자식클래스에서 정의하는 인터페이스
  
  Scanner keyboard;
  List<Lesson> list; //<Lesson>형식
  
  public LessonAddCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list;
  }
  
  public void execute() {
    Lesson lesson = new Lesson();
    
      System.out.print("번호? ");
      lesson.setNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("수업명? ");
      lesson.setTitle(keyboard.nextLine());

      System.out.print("설명? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("종료일? ");
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("총수업시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("일수업시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

      list.add(lesson);

      System.out.println("저장하였습니다.");
    }
  }

