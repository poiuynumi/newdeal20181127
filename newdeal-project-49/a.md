##49 MyBatis 도입
자바소스에서 SQL코드를 분리하라
JDBC코드를 캡슐화한 MyBatis로 대체하라

작업
MyBatis 라이브러리 추가
-mvnrepository.com에서 mybatis를 검색하여 라이브러리 정보를 알아낸다.
-build.gradle파일에 등록
-$ gradle eclipse 실행하여 이클립스 설정파일을 갱신
-이클립스에서 프로젝트 리프레시

MyBatis 설정 파일 추가
-mybatis.org 사이트의 문서를 참고하여 mybatis-config.xml 파일을 작성한다. : 사이트 오른쪽 github -> 아래 see the docs -> 왼쪽 Getting Start
- src/main/resources/eomcs/lms/conf 디렉토리에 파일을 둔다.
-'src/main/resources' 폴더를 추가한 후 자바 소스 폴더로 등록해야 한다.
-즉 폴더를 만든 후에 '$gradle eclipse'를 다시 실행한다.
-물론 이클립스에서도 프로젝트를 리프레시한다.

SQL 분리
-'src/main/resources/com/eomcs/lms/mapper/BoardMapper.xml'파일을 작성
-'BoardDao' 클래스에 있는 SQL을 이파일로 옮긴다
-물론 MyBattis 문서를 참고하여 작성

SqlSwssionFactory 인스턴스 생성
-'App.java'클래스에서 mybatisdml SqlSessionFactory 객체를 준비한다
-DAO객체가 사용할 수 있게 생성자에 주입해준다.
DAO에 적용

//PK는 반드시 id라고 해야한다 (result X)