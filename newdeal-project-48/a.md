클래스 이름 첫번째는 무조건 대문자로

MariaDBBoardDao
creatStatement 대신 preparedStatement
괄호 안으로 집어넣음

ResultSet -을 괄호 밖으로 꺼낸다
stmt.setInt(1,no);
try(ResultSet rs -) { //try문 안에 try를 다시 집어 넣음

insert명령어 동일하게 변경
stmt.setString(1, board.getContents()): //1번부터 시작
stmt.setString(2, board.getWriteNo()):
-

update도 동일하게 변경

delete도 동일하게 변경



