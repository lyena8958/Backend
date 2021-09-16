<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<br>
		${msg.userID} |	${msg.msg}   
		>> ${msg.datetime} | 좋아요 ${msg.likeCnt} ─ 댓글 ${msg.replyCnt}</h3>




<ol>
	<c:forEach var="replyList" items="${msgData.replyList}">

<li>
		${replyList.userID}

		${replyList.rmsg}
		>> [${replyList.datetime}]
		



</li>

	</c:forEach>
</ol>
	<br>
	----------------------------------------------------------------------
	<br>
</c:forEach>

</body>

</html>