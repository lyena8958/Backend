<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대댓글 개인실습</title>
</head>
<body>


<h1>댓글목록</h1>
<br><br><br><br>

<hr>

<c:forEach var="ListVO" items="${msg_Lists}">
	<c:set var="msg" value="${ListVO.msg}">
		<table>
		<tr>
			<th>ID</th>
			<th>내용</th>
			<th>좋아요</th>
			<th>조회수</th>
			<th>작성날짜</th>
		</tr>
		<tr>
			<td>${msg.id}</td>
			<td>${msg.msg}</td>
			<td>${msg.favcount}</td>
			<td>${msg.replycount}</td>
		</tr>
		<h6>대댓글</h6>
		<c:forEach var="reply" items="${ListVO.reply_List}">
			└>  <p>${reply.id} | ${reply.rmsg} | ${reply.datetime}</p>
		
		</c:forEach>
		
		</table>
	</c:set>
	<br><br><br><br><br>
<hr>
</c:forEach>


</body>
</html>
