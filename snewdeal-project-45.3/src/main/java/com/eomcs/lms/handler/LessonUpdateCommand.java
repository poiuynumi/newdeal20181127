package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {
  
  Scanner keyboard;
  List<Lesson> list;
  
  public LessonUpdateCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list;
  }
  
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    Lesson lesson = list.get(index);
    
    try {
      // 기존 값 복제
      Lesson temp = lesson.clone();
      
      System.out.printf("수업명? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);
      
      list.set(index, temp);
      
      System.out.println("게시글을 변경했습니다.");
      
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
  
  private int indexOfLesson(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no)
        return i;
    }
    return -1;
  }
}