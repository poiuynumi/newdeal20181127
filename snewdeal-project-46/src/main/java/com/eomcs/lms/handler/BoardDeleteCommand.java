package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  BoardDao boardDao;
  
  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
    this.boardDao = boardDao; 
  }
  
  public void execute() {
   
    
    try {
 
      System.out.print("번호? ");
      String no = keyboard.nextLine();
      
      if (boardDao.delete(no) > 0)
        System.out.println("삭제했습니다!");
      
      else {
      boardDao.delete(no);
      System.out.println(" 해당 번호의 게시물을 삭제했습니다!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } 
    }
  }

