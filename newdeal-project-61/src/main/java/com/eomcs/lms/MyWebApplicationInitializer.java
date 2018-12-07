package com.eomcs.lms;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//WebApplicationInitializer 구현체는 웹애플리케이션이 시작될 떄 실행되도록 프로그램이 짜여져 있다
public class MyWebApplicationInitializer implements WebApplicationInitializer { 



@Override
public void onStartup(ServletContext servletContext) throws ServletException {
 //이 메서드가 호출될 떄 할 일
  //1 프론트 컨트롤러가 사용할 Spring IoC 컨테이너를 준비한다
  AnnotationConfigWebApplicationContext iocContainer = 
      new AnnotationConfigWebApplicationContext();
  iocContainer.register(AppConfig.class);
  iocContainer.refresh();
  
  System.out.println(iocContainer.getBeanDefinitionCount());
  String[] names = iocContainer.getBeanDefinitionNames();
  for (String name : names) {
    System.out.printf("%s ===> %s\n", name, 
        iocContainer.getBean(name).getClass().getName());
  }
  
  
  //2 프론트 컨트롤러(DispatcherServlet)을 서블릿 컨테이너에 등록한다
  //=> 프론트 컨트롤러를 생성할 때 이 객체가 사용할 Spring IoC컨테이너를 알려준다
  DispatcherServlet servlet = new DispatcherServlet(iocContainer);
  
  // =>서블릿 컨테이너에 위에서 만든 프론트 컨트롤어 서블릿을 등록한다.
  ServletRegistration.Dynamic registration = 
      servletContext.addServlet("app", servlet);
  
  //=> 등록한 서블릿에 정보를 설정한다
  //웹 애플리케이션이 시작될 때 프론트컨트롤러를 생성하라고 지정한다.
  registration.setLoadOnStartup(1);
  //프론트 컨트롤러의 URL을 지정한다.
  registration.addMapping("/app/*");
}
}