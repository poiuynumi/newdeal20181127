
BoardaddCommend의 execute를 사용하려면 BoardDao의 인스턴스가 있어야함
- BoradaddCommand는 scanner와 BoardDao에 의존한다 -> Scanner, BoardDao : 의존객체
App의 작업을 Handler로 분산 -> Handler의 작업을 Dao에게 맡김 (객체 생성을 통한 작업 수행)
Handler의 작업을 분류 (add, delete, update ...)

Engine(해석 + 실행) / Parser(뭔가를 해석하는 일을 한다) / Container (생성, 소멸 관리) : 넓은 의미에서 같은 의미
Bean = instance = object . Bean Container : 인스턴스 생성 , 삭제 등 관리

Inversion Of Control 
-event listener
-DI (Dependence Injection)

DI(=IoC)사용의 장점
-의존객체의 대체가 쉽다 -> 유지보수 용이
-단위테스트가 쉽다
-가비지생성 최소화


jquery -> cross browser 기능 -크롬,사파리,등 알아서 해결 (첫번째 이유)
       -> 코드 간결


## 51 : Spring IoC Container 도입

-객체 생성과 소멸을 Spring IoC Container에게 맡겨라

Spring IoC Container 라이브러리 추가
-mvn-에서 Spring context 검색해서 추가

Spring IoC 설정 파일 추가 (Spring 자료 : github.com/eomjinyoung/java106/java106-spring-ioc/src/main/java/bitcamp/java106/)
-lms 안에 'AppConfig' class 생성
   -SqlSessionFactory 객체를 생성하는 메서드 추가
   -Spring Ioc 컨테이너가 자동으로 객채를 생성할 수 없는 경우 메서드를 정의하여 직접 객체를 생성한다.
   -DAO나 Command의 경우 내가 정의한 것이라서 Spring IoC 컨테이너를 통해 객체를 자동생성되게 설정할 수 있다.
   -그러나 Mybatis 관련 객체인 경우 내가 만든 클래스가 아니라 Spring IoC 컨테이너가 객체를 자동생성하게 설정할 수 없다.
   -따라서 Mybatis관련 클래스는 직접 인스턴스를 생성해야 한다
        =>('AppConfig' class 생성하는 이유)

-Dao클래스에 객체 자동생성하도록 설정
  - 클래스 선언부에 @Component를 붙인다.
-Command 클래스에 객체 자동생성하도록 설정
  - 클래스 선언부에 @Component를 붙인다.

(인터페이스는 객체생성X)

  ###Spring IoC 
    