<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.member.model.MemberDto"%>
  
<%

MemberDto memberDto = new MemberDto();

memberDto.setId("aa");
memberDto.setName("전지영");
memberDto.setEmail("aaa");

session.setAttribute("userInfo", memberDto);

response.sendRedirect(request.getContextPath() + "/badmin/boardmenu.bit");
%>