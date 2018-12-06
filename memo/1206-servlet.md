12.06
@
git폴더 정리
필기 한 폴더에 정리
이클립스 플러그인 확인
@


MIMETYPE 
-MIMETYPELIST https://www.freeformatter.com/mime-types-list.html
-추가하면 형식에 맞게 갖춰짐

 Domain-Specific Language = DSL

##

BoardDetailServlet
-doget() 사용
--불러올 때 키보드로 불러오는ㄴ게 아니라 req.getParameter("no") 이런식으로
-req.setAttributer : board를 저장
-parameter 통일 (request, response)
-throw new ServletEception(e); : 웹에서도 출력될 수 있도록 ServletEception에 포장해서 던짐

-wapapp밑에list.jsp복사해서 detail.jsp
--<tr>
--<th>작성자</th>
--<td><input type = "text" name = "writerNo" value = "${board.writerNo}></td>
--</tr>
--내용 뺴고 나머지에  readonly옵션을 붙임 
---input 뒤에 readonly //->편집 못하도록 설정

--detail의 tr태그 복붙
--<table>바깥쪽에 <form> 만듬
--서브에 보낼 데이터에는 이름을 주지말것
---개발자 도구 -> Network

-update 만들기
--BoardUpdateCommand를 -Servlet으로 바꿈
--@WebServlet
--httpServlet을 상속받음
--생성자에서 초기화하지 말고 init에서
--BoardDetail에서 가져와서 복붙
--변경한 다음에 바로 list로 보내기
---response.sendRedirect("list"); //데이터를 변경한 후 웹브라우저에게 url을 다시 요청하라고 응답
---클라이언트가 직접jsp요청 X(서블릿으로 요청) -> list.jsp X 
---같은방에 있으니까 앞에 /board붙일 필요 X
---post요청으로 들어온 데이터는 utf-8로 인코딩되었는데 request.getParameter()의 리턴 값은 Unicode이다 
---즉 utf-8을 unicode로 변환한 후 리턴하는 것이다 
---클라이언트가 보낸 데이터가 utf8이라고 알려주지 않으면 gerParameter()는 그 데이터를 영어라고 착각하고 영어를 unicode로 바꾸는 것이다.
---해결책은? -> getParameter()를 "최초로"호출하기 전에 클래이언트가 보낸 데이터가 utf8이라고 알려준다
----request.setChracterEncoding("UTF-8");
---예외처리

--delete만들기
---detail에 버튼 하나 더 두기
----<td> <button type="button" onclick="remove();">삭제</button> //(웹서버에서 수행)
----<script>function remove() {
    location.href = "de }//script로 묶어야 화면에 출력이 안됨 

---BoardDeletCommand 를 -Servlet으로 변경, 옮김
---http에서 서블릿 상속받도록 변경
---ctrl + space 로 doget호출
---request.getParameter("no") 
---기존이 jsp복사해서 delete.jsp로 수정

----<c:choose>
----<c:when test="${count ==0}">
----<p>해당 번호의 게시물이 없습니다.</p>
----</c:when>
----<c:otherwise><p>삭제 했습니다.</p>
----<c:choose>
----1초 후에 다시 돌아오도록 설정

form.jsp
-type 설정을 안해주면 기본으로 submit Button으로 설정된다
-list.jsp 에서 테이블 위에
--<p><a href='add'> 새글 </a><p>
-request.setChracterEncording("utf-8") // 한글이 깨지지 않도록 utf-8로 되어있다고 알려준다

webapp 밑에 auth폴더를 만들고 form.jsp 복붙
loginCommand를 refactor 해서 servlet으로 옮기고 이름을 바꾼다

loginServlet
-설정
-boardaddservlet에서 get 가져오기
-doPost Overriding 한다
-keyboard-지우고 request로 바꾼다
- -> requst.Parameter("")
-HttpSession session = request.getSession(); //다시 로그인 하기 위해 로그인 하기 전으로 돌린다 (기존 로그인정보도 되돌림)
 if (member != null)
 session.setAttribute("lofinUser", memeber); 
 response.sendRedirect("../board/list);
 else 
  session.invalidate(); 
  response.sendRedirect("login);
-Memver  loginUser = (Memer) request.getSession().getSession().getAttribute("loginUser"); 
            //session에서 로그인 정보를 꺼내서 그 정보를 사용

list(상단에 로그인 정보 출력)
- <div>
  ${sessionScope.loginUser.name}
  <a href='logout'>로그아웃</a>
  </div>
-그대로 복사해서 detail.jsp <body>바로 밑에 넣어줌 (상세 상단에서도 표시되도록)
-그대로 복사해서 form.jsp <body>바로 밑에 넣어줌 (form 상단에서도 표시되도록)

webapp 아래에 jsp파일 만들고 이름을 header로 설정
-상단에 로그인 정보 출력하는 것을 복붙 (절대경로로 설정)
-list.html과 test 삭제
-공통으로 
 <jsp:include page= >를 사용한다

 logoutServlet 만들기
 -loginServlet 복붙
 -다지우고 do Get
  request.getSession().invalidate();
  response.sendRedirect("login");

header.jsp를 변경하여 logout했을 때 상단에 log인이 뜨도록 한다 (login시 반대)

##Filter를 이용하여 서블릿을 실행하기 전에 특정 작업을 수행한다.

lms밑에 filter 패키지를 만든다
패키지에 클래스를 만들고 이름을 CharacterEncordingFiler라고 한다

interface에서 defalt 문법 -> 새 규칙을 만들더라도 기존 구현체에 영향을 안 미치게 하기위해

board add,update Servlet에서 지워준다

로그인 하지 않은 상태로 로그인 해야지만 이용가능한 서비스를 이용할 때 로그인 페이지로 보낸다
   
등록되어 있지 않은 수업번호 입력시 오류를 없애기 위해 선택목록 만들기

-membermapper복사해서 lessonmapepr
- sql -> describe lesson
테이블 구조상 특정수업을 듣지 않는 학생은 게시판에 작성할 수 없다

<select id="findByMemberNo" //memberNofh 수업을 찾는다 

<select id="findByParticipantNo" // 참여자 번호로 수업을 찾아라

select mno, lno
          from les_memb
          Where mno=3;
          에서는 수업이름을 불러올 수 없다 -> join 사용

          select 
          lm.mno, 
          l.lno,
          l.title
          from les_memb lm
          join lesson l on lm.lno=l.lno
          Where lm.mno=3;

BoardAddServlet에서
-Session을 꺼내서 로그인한 사용자 정보를 가져와서 그 사용자가 사용한 수업내용을 가져오도록 설정
-form에 보내기전 lesson이라는 이름으로 서블릿리퀘스트보관소에 담는다

게시물 상세정보에서 작성자와 수업정보를 번호가 아니라 이름으로 출력하기 위해서 join을 이용해야한다.

도메인을 만들기 애매한 경우 map을 사용해 도메인을 대신할 수 있다



---------------------
front Controller 설명
Spring WebMVC
