<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/public.jsp" %>
<c:choose>
	<c:when test="${errorMsg != null}">
	<font color="red" size=15">${errorMsg}</font>
	</c:when>
	<c:otherwise>
<script type="text/javascript">
$(document).ready(function() {
	control = "${root}/reboard";
	
	initVars();
	
	$("#viewBtn").click(function() {
		$("#seq").val("${wseq}");
		$("#commonForm").attr("method", "get").attr("action", viewpath).submit();
	});
	
	$("#listBtn").click(function() {
		$("#commonForm").attr("method", "get").attr("action", listpath).submit();
	});
	
});
</script>

<table width="100%" cellpadding="6" cellspacing="2" border="0"
	bgcolor="#ffffff" style="border: #e1e1e1 solid 1px">
	<tr>
		<td class="bg_board_title" width="100%"><img
			src="${root}/img/board/icon_arrow_08.gif" width="3" height="11"
			border="0" align="absmiddle" hspace="6" vspace="6"> <b>게시판</b>
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#e1e1e1"
			style="overflow: hidden; padding: 0px;"></td>
	</tr>
	<tr>
		<td class="bg_menu" width="100%" style="padding: 25px" height="35"
			align="center"><b>게시물이 등록되었습니다.</b><br>
		<br>

		<div align="center">
			<img src="${root}/img/board/b_wirtecf.gif" id="viewBtn" width="91" height="21"
			border="0" align="absmiddle" alt="작성한 글 확인" hspace="10">
			<img src="${root}/img/board/poll_listbu1.gif" id="listBtn"
			width="62" height="21" border="0" align="absmiddle" alt="목록보기"
			hspace="10">
		</td>
	</tr>
</table>
<br>
</body>
</html>
	</c:otherwise>
</c:choose>