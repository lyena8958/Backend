<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="로그인"></td>
			<td><a href="signUp.jsp"><input type="button" value="회원가입"></a></td>
		</tr>
		
	</table>
</form>

</body>
</html>