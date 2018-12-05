##52 Spring IoC컨테이너와 Mybatis 연동하기



mybatis-Spring 연동라이브러리 추가
-mvn-


DataSource 구현체(DB)


//Spring IoC 컨테이너가 로딩한 프로퍼티 정보를 가져오기
// => 야 스프링 IoC컨테이너. 

@Value("${jdbc.driver}")
String jdbcDriver;

@Value("${jdbc.driver}")
String jdbcUrl;

@Value("${jdbc.driver}")
String jdbcUsername;

@Value("${jdbc.driver}")
String jdbcPassword;

@Bean
 public DataSource dataSource() {
BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(this.jdbcDriver);
      dataSource.setUrl(this.jdbcUrl);
      dataSource.setUsername(this.jdbcUsername);
      dataSource.setPassword(this.jdbcPassword);

Mybatis config 파일
- 필요없는 거 지움

public PlatformTransactionManager

//트랜젝션 객체를 생성할 때 기본 이름으로 transactionManager라고 설정하라 
//다른이름으로 설정하면 트랜젝션 관련하여 다른 객체를 생성할 때
//그 객체가 트랜젝션 관리자를 자동으로 찾지 못한다.


#AppConfig
public PlatformTransactionManager transactionManager(
    DataSource dataSource) {
        return new 
    }

//도메인클레스의 별명 자동 생성하기
factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");

//SQL 메퍼 파일 로딩
//=> SQL매퍼 파일의 위치 정보를 Resource객체에 담아서 넘겨야 한다.
//=> Resource객체는 Spring Ioc컨테이너를 통해 만들 수 있다
//ioc컨테이너 객체는 이 메서드의 파라미터에 달라고 요청하라 
factoryBean.setMapperLocation(iocContainer.getREsources(
    "classpath:/com/eomcs/lms/mapper/Mapper

public SqlSessionFactory sqlSessionFactory(

    App-(iocContainer.getResources)

mybatisConfig파일 더이상 필요없음 - 삭제

javaConfig
-xml로 설정하지 않고

지금까지 만들어 놓은 것을 그대로 들어다 웹어플리케이션으로 옮겨와 사용가능