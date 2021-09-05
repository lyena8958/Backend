<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("UTF-8");
	session.setAttribute("username", request.getParameter("username"));
%>

<% session.getAttribute("username") %>	님 환영합니다!	<br>

<h2>====상품목록====</h2>

<form action="ynAddProduct_1" name="form1" method="post">



</form>

</body>
</html>