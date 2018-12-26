<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/public.jsp" %>

<script type="text/javascript">
  $(document).ready(function() {
	  control="${root}/album";
	      
	  initVars();
	  $(".writeBtn").click(function() {
		  $("#commonForm").attr("method", "get").attr("action", writepath).submit();
		});
	  
	  $(".posting").click(function() {
      $("#seq").val($(this).attr("article-no"));
      $("#commonForm").attr("method", "get").attr("action", viewpath).submit();
    });
	  
	  $("#firstpage").click(function() {
		  $("#pg").val("1");
		  $("#key").val("");
		  $("#word").val("");
	    $("#commonForm").attr("method", "get").attr("action", listpath).submit();
	  });
	  
	  $(".mvpage").click(function() {
		  $("#pg").val($(this).attr("move-page-no"));
	    $("#commonForm").attr("method", "get").attr("action", listpath).submit();
	  });
	  
	  $("#searchBtn").click(function() {
      $("#pg").val("1");
      $("#key").val($("#skey").val());
      $("#word").val($("#sword").val());
      $("#commonForm").attr("method", "get").attr("action", listpath).submit();
    });
	  
	  $("#myBtn").click(function() {
	      $("#pg").val("1");
	      $("#key").val("id");
	      $("#word").val("${userInfo.id}");
	      $("#commonForm").attr("method", "get").attr("action", listpath).submit();
	    });
  
  });


</script>


<!-- title start -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	

	<tr>
		<td bgcolor="#ededed" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>


	<tr>
		<td class="bg_board_title_02" height="1" colspan="11"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>
</form>
<!-- bbs end -->

<!-- 하단 페이징 -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="5"></td>
	</tr>
	<tr valign="top">
		<td nowrap><img
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기" class="writeBtn"></td>
		<td width="100%" align="center"><!--PAGE--> 페이지 분류를 하는 부분</td>
		<td nowrap class="stext"><b>현재 페이지 출력 부분</b> / 총 페이지수를 출력 하는 부분
		pages</td>
	</tr>
</table>
<br>
<!-- 하단 페이징 -->

<!-- 검색 영역-->
<form name="searchForm" method="post" action="javascript:goBbsSearch();"
	style="margin: 0px"><input type="hidden" name="" value="">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="10"></td>
	</tr>
	<tr>
		<td width="50%"></td>
		<td nowrap><select name="item" onchange="javascript:ch()"
			class="inp">
			<option value="subject">글제목
			<option value="writer">글쓴이
			<option value="no">글번호
		</select> <span id="sear1"> <input type="text" name="query" size="22"
			class="inp" style="margin-top: -19px;"> </span> <span id="sear2"
			style="display: none;"> <select name="head" class="inp">
			<option value="말머리선택">말머리선택
		</select> </span> <a href="javascript:goBbsSearch();"><img
			src="${root}/img/board/sbtn_s.gif" width="32" height="18"
			border="0" align="absmiddle" alt="검색"></a> <a
			href="javascript:goMyList('안효인')"><img
			src="${root}/img/board/sbtn_mytext.gif" width="82" height="20"
			align="absmiddle" alt="내가 쓴 글 보기"></a><br>
		</td>
		<td width="50%" align="right"><a href="#"><img
			src="${root}/img/board/sbtn_top.gif" width="24" height="11"
			align="absmiddle" alt="TOP"></a><br>
		</td>
	</tr>
</table>
</form>
</body>
</html>

