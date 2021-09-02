<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="product"%>
<!DOCTYPE html>
<!-- 커스텀 태그, EL 실습 -->
<html>
<head>
<meta charset="UTF-8">
<title>총 결제</title>
</head>
<body>
<product:totalPrice border="1" bgcolor="yellow"/>


</body>
</html>