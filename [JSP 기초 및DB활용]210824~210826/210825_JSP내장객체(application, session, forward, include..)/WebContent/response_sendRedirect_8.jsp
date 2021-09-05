<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리다이렉팅 방식</title>
</head>
<body>

<!-- 기본구조가 필요없긴하나, 그냥씀 -->

<!-- 다음페이지를 위한 request를 새로만든다. >> 다음페이지없음 -->
<%response.sendRedirect("result.jsp"); %>

<!-- 페이지를 불러낼적에 forward과 비교를하면 
다음 페이지를 위한 response를 새로 만들기 때문에 null로 뜨는 것이다. -->
<!-- 새로만들기때문에 데이터가없어짐 == username -->
</body>
</html>