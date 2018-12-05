package com.eomcs.lms;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.eomcs.lms.dao.impl.MariaDBBoardDao;
import com.eomcs.lms.dao.BoardDao;


//Spring IoC 컨테이너에게 패키지 이름을 알려주면 그 패키지를 뒤져서 @Component가 붙은 클래스에 대해 인스턴스를 자동으로 생성해준다
@ComponentScan("com.eomcs.lms") // ()안의 패키지를 뒤져서 @Component가 붙은 걸 찾아내라
public class AppConfig {
  
  // Spring IoC 컨테이너에게 이 메서드를 호출하여
  @Bean
  public SqlSessionFactory sqlSessionFactoty() throws Exception { 
    //메소드 이름을 돈사로 하지 않고 객체이름인 명사형채로 -> 리턴값을 저장할 때 사용할 이름을 지정하지 않으면 메서드 이름으로 하기때문
    String resource = "com/eomcs/lms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
          
  }
  
  @Bean //붙여야 스프링프레임워크가 알아들음
  public Scanner keyboard() {
    return new Scanner(System.in);
  }

  public BoardDao boardDao(SqlSessionFactory sqlSessionFactory) {
   
    return new MariaDBBoardDao(sqlSessionFactory);
    
    
  }
}
