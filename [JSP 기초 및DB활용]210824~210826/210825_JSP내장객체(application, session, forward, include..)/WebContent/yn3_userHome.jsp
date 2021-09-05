<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	background-image : url(image/보노보노.jpg);
}

</style>
</head>
<body>
<%
	
	int cnt = (Integer)application.getAttribute("cnt");
	cnt++;
	application.setAttribute("cnt", cnt);
	
%>

<h2>투데이 방문자 수 : <%= cnt %></h2>

<h2></h2>

</body>
</html>