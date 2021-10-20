<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="editMem.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${userData.id}" readonly></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="${userData.password}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${userData.name}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="정보변경"></td>
		</tr>
	</table>
</form>

</body>
</html>