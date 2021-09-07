<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- NF5와 달리 url자체를 보내주는역할 -->
<!-- redirect 대체사용 -->
<c:redirect url="NewFile2.jsp">
	<c:param name="test">a</c:param>
</c:redirect>

</body>
</html>