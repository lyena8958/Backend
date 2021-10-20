<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userData" class="model.member.MemberVO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="insertBoard.do" method="post">
	<input type="hidden" name="writer" value="${userData.id}">
	<table border="1">
		<tr>
			<td>글 제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		
		<tr>
			<td>글 내용</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 작성"></td>
		</tr>
	</table>
</form>

</body>
</html>