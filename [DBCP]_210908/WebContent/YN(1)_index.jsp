<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	pageContext.forward("YN(1)_control.jsp?action=main");
%>

<!-- 2. MVC 분리
	테이블 한개만
	CRUD 모두 구현
	-> All + One
	5개의 비즈니스 메서드가 나옴-->

</body>
</html>