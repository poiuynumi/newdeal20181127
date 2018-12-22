<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.bit.member.model.MemberDto"%>
    
   <%
   	MemberDto memberDto = new MemberDto();
   memberDto.setId("1");
   memberDto.setName("1");
   memberDto.setEmail("1@gmail.com");
   session.setAttribute("userInfo", memberDto);
	response.sendRedirect(request.getContextPath() + "/badmin/boardmenu.bit");
%>