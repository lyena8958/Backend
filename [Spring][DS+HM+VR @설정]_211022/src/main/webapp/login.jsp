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
			<td>아이디</td>							<!-- ${memberVO.id} -->
			<td><input type="text" name="id" value="${guest.id}"></td>
		</tr>
		
		<tr>
			<td>비밀번호</td>									<!-- ${memberVO.password} -->
			<td><input type="password" name="password" value="${guest.password}"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="로그인"></td>
			<td><a href="signUp.jsp"><input type="button" value="회원가입"></a></td>
		</tr>
		
	</table>
</form>

</body>
</html>