package impm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;

public class BoardDao {
  
  
  public List<Board> findAll() throws Exception {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    DriverManager.registerDriver(new Driver());
    
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", 
          "study", "1111");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "select bno, cont, cdt, view from board");
      
 ArrayList<Board> list = new ArrayList<>();
      
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        
        list.add(board);
      }
      
      return list;
      
    }  finally { 
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  
  public Board findByNo(int no) throws Exception {
    
    Scanner keyboard;
    
    public BoardDetailCommand(Scanner keyboard) {
      this.keyboard = keyboard; 
      DriverManager.registerDriver(new Driver());
    }
    
    public void execute() {
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
     /*
      * try (
      *  Connection con = DriverManager.getConnection(
      *  "jdbc:mariadb://localhost:3306/studydb", 
            "study", "1111");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
             "select bno, cont, cdt, view, mno, lno"
            + " from board"
            + " where bno=" + no);) {
      * 
      * */
      try (
            Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb", 
                "study", "1111");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(
                 "select bno, cont, cdt, view, mno, lno"
                + " from board"
                + " where bno=" + no);) {
        
        // dbms에서 한 개의 레코드를 가져온다.
        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("bno"));
          board.setContents(rs.getString("cont"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("view"));
          board.setWriterNo(rs.getInt("mno"));
          board.setLessonNo(rs.getInt("lno"));
        } else {
          System.out.println("해당 번호의 게시물이 없습니다!");
        }
      
      } finally {
        try {rs.close();} catch (Exception e) {}
        try {stmt.close();} catch (Exception e) {}
        try {con.close();} catch (Exception e) {}
      }
    }
    
  }
  
  public void insert(Board board) throw Excoption {
    Connection con = null;
    Statement stmt = null;
    
    try {
      System.out.print("내용? ");
      String content = keyboard.nextLine();
      
      System.out.print("작성자번호? ");
      String writerNo = keyboard.nextLine();
      
      System.out.print("수업번호? ");
      String lessonNo = keyboard.nextLine();
      
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
  
public void update(Board board) throws Exception {
  Connection con = null;
  Statement stmt = null;
  
  try {
    DriverManager.registerDriver(new Driver());
    con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", 
        "study", "1111");
    stmt = con.createStatement();
      
    stmt.executeUpdate(
    "update board set cont='" +
    board.getContents() +
    "' where bno=" + board.getNo());
   
  } finally {
    try {stmt.close();} catch (Exception e) {}
    try {con.close();} catch (Exception e) {}
  }
}
public int delet(Board board) throws Exception {
Connection con = null;
Statement stmt = null;

try {
  DriverManager.registerDriver(new Driver());
  con = DriverManager.getConnection(
      "jdbc:mariadb://localhost:3306/studydb", 
      "study", "1111");
  stmt = con.createStatement();

  System.out.print("번호? ");
  String no = keyboard.nextLine();
  
   return stmt.executeUpdate("delete from board where bno=" + no);
  
  System.out.println("삭제했습니다!");

} catch (Exception e) {
  e.printStackTrace();
} finally {
  try {stmt.close();} catch (Exception e) {}
  try {con.close();} catch (Exception e) {}
}
}
}