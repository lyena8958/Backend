<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.userTable.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	UserTableVO user=(UserTableVO)session.getAttribute("user");
%>
<form action="control.jsp" method="post">
<input type="hidden" name="action" value="insert">
<input type="hidden" name="writer" value="<%=user.getUserID()%>">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content"></td>
	</tr>
	<tr>
		<td colspan='2'><input type="submit" value="글 작성하기"></td>
	</tr>
</table>
</form>

</body>
</html>