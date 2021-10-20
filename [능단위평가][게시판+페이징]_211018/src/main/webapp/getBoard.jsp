<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board.*"%>
<jsp:useBean id="vo" class="model.board.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateBoard.do" method="post">
	<input type="hidden" value="${data.id}" name="id">
	<table border="1">
		<tr>
			<td>글 제목</td>
			<td><input type="text" name="title" value="${data.title}"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${data.writer}" disabled></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><input type="text" name="content" value="${data.content}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 변경"></td>
		</tr>
	</table>
</form>
<hr>
<a href="deleteBoard.do?id=${data.id}">글 삭제하기</a>
<hr>
<a href="main.do">메인페이지로 이동하기</a>

</body>
</html>