<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 내장객체</title>
</head>
<body>


<%					// 세션과 똑같이 (이름, 객체)임, 변수처럼 객체명을 이름으로 설정
	application.setAttribute("username", "홍길동");
	application.setAttribute("cnt", 1);
%>

<a href="hong_10.jsp">홍길동님의 미니홈피</a>

</body>
</html>