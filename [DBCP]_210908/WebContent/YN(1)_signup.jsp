<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP개인실습-회원가입 페이지</title>
</head>
<body>

<form action="YN(1)_control.jsp">
<input type="hidden" name="action" value="signUp">
<input type="text" name="userID" placeholder="아이디" required>
<input type="text" name="userPW" placeholder="비밀번호" required>
<input type="text" name="userName" placeholder="성명" required>
<input type="submit" value="회원가입">
</form>


</body>
</html>