package com.eomcs.lms;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.impl.MariaDBBoardDao;
import com.eomcs.lms.dao.impl.MariaDBMemberDao;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LoginCommand;

public class App {

  static Scanner keyboard; //여기서 선언하는 것이 아니라 IoC컨데이너에서 꺼냄 (48)
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  
  public static void main(String[] args) throws Exception {
    
    
    
    //AppConfig 클래스가 메모리에 로딩되어 있지 않다면 지금 즉시 로딩한 후 그 로딩 된 클래스 정보를 리턴하라
   // Class<?> clazz = Class.forName("com.eomcs.lms.AppConfig"); //?: 어떤 클래스라도 가리키겟다
    //클래스의 정보를 알고 싶을때 사용
    // = Class<?> clazz2 = AppConfig.class; 와 같다
    
    AnnotationConfigApplicationContext iocContainer =
        new AnnotationConfigApplicationContext(AppConfig.class);
    
   
    
 
    
     
     keyboard = (Scanner) iocContainer.getBean("keyboard"); //IoC컨테이너에서 꺼냄
     
     
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      
      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      
     
      
          
          try {
            Command commandHandler = (Command) iocContainer.getBean(command);
            try {
              commandHandler.execute();
          
        } catch (Exception e) {
          System.out.println("명령어 처리 중 오류 발생!");
        }
            
            
      } catch (Exception e) {
        if (command.equals("quit")) {
          System.out.println("안녕!");
          break;
         
        
        } else if (command.equals("history")) {
          printCommandHistory();
        } else if (command.equals("history2")) {
          printCommandHistory2();
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
        
      System.out.println(); 
    }

keyboard.close();
iocContainer.close();
    }
  }
  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  
  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
