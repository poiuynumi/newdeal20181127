<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>수업</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>게시물 등록</h1>

<form action="add" method="post">
<table border='1'>
<tr>
  <th>내용</th>
  <td><textarea name="contents" rows="5" cols="50"></textarea></td>
</tr>
<tr>
  <th>수업</th>
  <td><input type="text" name="lessonNo"></td>
</tr>
<tr>
  <th></th>
  <td>
    <button>등록</button>
    <button type="button" onclick="location.href='list'">취소</button></td>
</tr>
</table>
</form>

</body>
</html>