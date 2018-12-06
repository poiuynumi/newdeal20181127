12.06

MIMETYPE 
-MIMETYPELIST https://www.freeformatter.com/mime-types-list.html
-추가하면 형식에 맞게 갖춰짐

 Domain-Specific Language = DSL

##

BoardDetailServlet
-doget() 사용
--불러올 때 키보드로 불러오는ㄴ게 아니라 req.getParameter("no") 이런식으로
-req.setAttributer : board를 저장
-parameter 통일 (request. response)
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