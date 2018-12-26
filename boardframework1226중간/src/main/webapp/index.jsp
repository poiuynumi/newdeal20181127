<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.member.model.MemberDto"%>  
<%
MemberDto memberDto = new MemberDto();
memberDto.setId("java2");
memberDto.setName("안효인");
memberDto.setEmail("troment@nate.com");

session.setAttribute("userInfo", memberDto);

response.sendRedirect(request.getContextPath() + "/badmin/boardmenu.bit");
%>