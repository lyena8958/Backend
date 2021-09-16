<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대댓글 메인페이지</title>
<style>
	@import url("css/css.css");
</style>

<!-- jQuery ,ajax -->
<script src="jquery-3.6.0.min.js"></script>
<script src ="script.js"></script>

</head>
<body>
<div id="content">
<a href="control.jsp?action=main" id="logo"><h1>●LOGO</h1></a>
<hr>
<br><br>
<h2>댓글 목록</h2>
<br>
<!-- 댓글목록 출력 -->
<c:forEach var="msgData" items="${msgDatas}"> 
<h3>

	<c:set var="msg" value="${msgData.msg}"/>
		<!-- 리플 C -->
		<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="replyAdd">
					<input type="hidden" name="mnum" value="${msg.mnum}">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="text" name="rmsg">
					<input type="submit" value="리플달기">
		</form>
		<br>
		<a href="control.jsp?action=msgUpdate&mnum=${msg.mnum}&userID=${msg.userID}&msg=${msg.msg}&replyCnt=${msg.replyCnt}&likeCnt=${msg.likeCnt+1}&mcnt=${mcnt}">좋아요♥</a>

		${msg.userID} |
		
<!-- [msg] 댓글내용 - 바로출력하지 않고 회원여부에 따라 출력 == UD기능을 위함 -->
  <!-- 회원 UD기능  댓글 (C는하단에) -->
		<c:if test="${userData != null}">
			<!-- 댓글 작성자 삭제/수정기능 -->
			<c:if test="${userData.userID == msg.userID}">
			
				<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="msgUpdate">
					<input type="hidden" name="mnum" value="${msg.mnum}">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="text" name="msg" value="${msg.msg}">
					<input type="submit" value="수정하기">
				</form>
				
				<!--삭제버튼 -->
				<a  class="c1" href="control.jsp?action=msgDelete&mnum=${msg.mnum}&mcnt=${mcnt}"><input type="button" value="삭제하기"></a>
				<br>
				
			</c:if>
				<c:if test="${userData.userID != msg.userID}">
					${msg.msg} 
				</c:if>
		</c:if>	
  <!-- // -->
  
  <!-- 비회원 댓글출력 -->
		<c:if test="${userData == null}">
			${msg.msg} 
		</c:if>
  <!-- // -->	
  
  
		>> ${msg.datetime} | 좋아요 ${msg.likeCnt} ─ 댓글 ${msg.replyCnt}</h3>




<ol>
	<c:forEach var="replyList" items="${msgData.replyList}">

<li>
		${replyList.userID}
		
<!-- [rmsg] 리플내용 - 바로출력하지 않고 회원여부에 따라 출력 == UD기능을 위함 -->
 <!-- 본인 UD기능  리플 (C는상단에) -->		
			<c:if test="${userData.userID == replyList.userID}">
			<a href="control.jsp?action=replyDelete&rnum=${replyList.rnum}&mcnt=${mcnt}&mnum=${replyList.mnum}"><input type="button" value="삭제하기"></a>
				<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="replyUpdate">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mnum" value="${replyList.mnum}">
					<input type="text" name="rmsg" value="${replyList.rmsg}">
					<input type="submit" value="수정하기">
				</form>
		</c:if>
<!--  // -->

 <!-- 비당사자 댓글출력 -->
			<c:if test="${userData.userID != replyList.userID}">
					${replyList.rmsg}
			</c:if>
<!-- // -->

		>> [${replyList.datetime}]
		



</li>

	</c:forEach>
</ol>
	<br>
	----------------------------------------------------------------------
	<br>
</c:forEach>

	──────────────────────────────────────────────────────────────────────────────────────────────

<a href="control.jsp?action=main&mcnt=${mcnt+1}">더보기 클릭!</a>

	──────────────────────────────────────────────────────────────────────────────────────────────

<form action="control.jsp" method="post">

	<mytags:mem/>
	<mytags:nomem/>

</form>

<br><br><br><br>
	──────────────────────────────────────────────────────────────────────────────────────────────
	<p>회원목록</p>
	<ol>
	<c:forEach var="mem" items="${userDatas}">
		<li><a href="control.jsp?action=main&user=${mem.userID}&mcnt=${mcnt}">${mem.userName} 님</a></li>
	
	</c:forEach>
	</ol>
</div>	
	
	
<!-- 광고 파트 ^^77 -->
<div id="ad">
	<p>광고배너</p>
<ul id="adAdd">
	<!-- ajax로 데이터 불러옴 -->
</ul>
</div>


<script>
	function signUpMove(){
		
		window.open('signUp.jsp','회원가입', 'width=500, height=700');
	}

</script>
</body>

</html>