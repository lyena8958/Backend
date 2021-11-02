<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="insertBoard.do" method="post">
	<input type="hidden" value="${user}" name="writer" />
	<table border="1">
		<tr>
			<td bgcolor="lightsalmon">글 제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td bgcolor="lightsalmon">글 내용</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 작성하기"></td>
		</tr>
	</table>
</form>
<hr>
<a href="main.do">메인페이지로 이동하기</a>

</body>
</html>