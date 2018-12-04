SQL 삽입공격

/board/uqdate
a',mno=3,cont='에이18

적용 후 확인 : 원래 내용이 지워지고 입력한 내용으로 변경됨

MemberDao interface 만들기 (Dao패키지)

Member findByEmailPassword(String email, -) //이메일과 암호로 사용자를 찾음
throw Exception

MariaDbMemberDao class 생성 (implements MariaDao)

query문
"select mno,name,email,photo"
+ "from -

if (rs.next()) { //만약에 일치하는 사용자가 있으면
    Member member = new Member();
    member.setNo(rs.getInt("mno"));
    member.setName(rs.getInt("name"));
    -
    -
}

LoginCommand class 생성

사용자로부터 이메일과 암호를 받아 그런 이메일과 암호가 존재하는지 확인하는 작업
if (member !=null)
System.out.printf("%s 님 환영합니다!."); 

App에서 Hello열 복붙
-.put("/auth/login",
member.email)
system.out.printf("이메일?");
//로그인 명령어 생성

로그인명령어에서 삽입공격
이메일? => user03@test.com' or 'a' = 'a' or 'x'='x //하나라도 참이면 작업 수행가능
암호 => 아무거나 입력
해도 로그인 가능

Statement의 createStatement()대신 preparedStatement()사용
preparedStatement 사용하면 무조건 문자열로 인식하기 때문에 '가 인식안됨 