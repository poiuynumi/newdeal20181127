##작업



###웹 프로젝트 관련 빌드 명령을 사용할 수 있게 준비한다

- build.gradle파일에 'eclipse'플러그인 대신에 'eclipse-wtp'플러그인을 추가한다.
-- 웹 애플리케이션 배치 파일(.war)을 만들 'war' 플러그인을 추가한다.
-- 단독으로 실행할 수 없기 때문에 'application'플러그인 제거한다.
--'app-을 지워준다

BoardListServelet

기존App.java는 필요없으니까 지운다

BoardListCommand를 서블릿으로 바꾼 후 지워준다
서버리스타트
console창을 확인하면 BoardListCommand가 없어짐


내일 -> commandfmf 서블릿으로 바꾼다
->
->서블릿을 다시 일반클래스로 바꾼다 (controler로)


###서블릿 애플리케이션 개발에 사용할 라이브러리 추가하기

-mvn에서 servlet-api검색

###이클립스 웹 프로젝트 설정하기
-scr/main/webapp
   -HTML,CSS,JabaScript,

   ###이클립스에 톰캣서버 등록
   -환경설정
   --톰캣서버가 설치된 디렉



