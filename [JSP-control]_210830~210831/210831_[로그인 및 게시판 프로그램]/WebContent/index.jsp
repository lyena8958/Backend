<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="control.jsp" method="post">
<input type="hidden" name="action" value="login">
<input type="text" name="userID">
<input type="password" name="userPW">
<input type="submit" value="로그인">
</form>

</body>
</html>