package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {
 
    try {
      Board board = new Board();
      
      System.out.print("내용? ");
      board.setContents(keyboard.nextLine());
      
      System.out.print("작성자번호? ");
      board.setNo(Integer.parseInt(keyboard.nextLine()));
      
      System.out.print("수업번호? ");
      board.setLessonNo(Integer.parseInt(keyboard.nextLine()));
      
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();
      
      // SQL을 서버에 전송 
      stmt.executeUpdate("insert into board(cont,mno,lno)"
          + " values('" + content + "',"
          + writerNo + ","
          + lessonNo + ")");
      
      System.out.println("입력했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}








