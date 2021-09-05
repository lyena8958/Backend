<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩(forward) 방식</title>
</head>
<body>
<!-- 액션태그의 include는 본페이지를 다 볼수있지만, 
forward는 페이지로 주도권을 다 넘겨버립니다. -->
<jsp:forward page="result.jsp">
	<jsp:param value="lyena8958@gmail.com" name="email"/>
</jsp:forward>
<!-- 본인페이지에서 주도권을 result.jsp로 보낸다.  -->
</body>
</html>