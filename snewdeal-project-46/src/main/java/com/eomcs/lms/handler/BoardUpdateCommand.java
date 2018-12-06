package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;
import impm.BoardDao;

public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }
  
  public void execute() {

    try {
      
     
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      Board board = boardDao.findByNo();
      
      System.out.printf("내용(%s)? ", board.getContents());
     board.setContents(keyboard.nextLine());
     
     boardDao.update(board);
      
     System.out.println("변경했습니다!");
    
    
    }
    catch (Exception e) {
      e.printStackTrace();
}
}
}