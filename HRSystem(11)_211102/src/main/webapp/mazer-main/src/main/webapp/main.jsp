<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${user}님, 안녕하세요! :D &nbsp;&nbsp;&nbsp; <a href="logout.do">로그아웃</a></h3>
<hr>
<h1>글 목록</h1>
<hr>
<form action="main.do" method="post">
	<table width="350"> <!-- condition+keyword -->
		<tr><td align="right">
			<select name="condition">
				<c:forEach var="op" items="${sm}">
					<option value="${op.value}">${op.key}</option>
				</c:forEach>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색하기">
		</td></tr>
	</table>
</form>
<table border="1" width="350">
	<tr bgcolor="lightblue">
		<th>글 번호</th><th>글 제목</th><th>글 작성자</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="getBoard.do?id=${v.id}">${v.id}</a></td><td>${v.title}</td><td>${v.writer}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<a href="insertBoard.jsp">글 작성</a>
</body>
</html>