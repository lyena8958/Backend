<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.board.*, model.member.MemberVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${userData.name}님,
		안녕하세요! <a href="logout.do">로그아웃</a>
	</h3>
	<span><a href="memEdit.jsp">회원정보 변경</a>&nbsp;<a
		href="deleteMem.do?id=${userData.id}">회원탈퇴</a></span>
	<hr>
	<h1>글 목록</h1>
	<hr>

	<!-- 포스트 -->
	<form action="main.do" method="post">
		<table>
			<!-- condition+keyword -->
			<tr>
				<!-- 응집도가 낮고, 결합도가 낮아 다른 데이터들을 바꾸기가 어렵다(국제화- 영번역) -> BoardController -> main -->
				<th><select name="condition">
						<c:forEach var="op" items="${sm}">
							<option value="${op.value}">${op.key}</option>
						</c:forEach>
				</select></th>
				<td><input type="text" name="keyword"></td>
				<td><input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>

	<hr>
	<table border="1">

		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>글 작성자</td>
			<td>작성일</td>
		</tr>
		<c:set var="index" value="${boardIndex}" />
		<c:forEach var="v" items="${datas}">

			<tr>
				<td><a href="getBoard.do?id=${v.id}">${index}</a></td>
				<td>${v.title}</td>
				<td>${v.writer}</td>
				<td>${v.wdate}</td>
			</tr>
			<c:set var="index" value="${index+1}" />
		</c:forEach>
	</table>
	<hr>
	<a href="insertBoard.jsp">글 작성</a>

	<ul>
		<c:forEach var="index" items="${indexx}">
			<li><a href="main.do?index=${index}">${index}</a></li>
		</c:forEach>
	</ul>
</body>
</html>