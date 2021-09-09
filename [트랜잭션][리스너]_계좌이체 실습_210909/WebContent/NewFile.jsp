<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 리스너 실습 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 맵핑을 해두었기 때문에 http://localhost:8080/day53_0909/"abc" 로도 접속가능  -->
<h2><%= getServletContext().getInitParameter("name3") %></h2>
<h2><%= getServletContext().getInitParameter("encoding") %></h2>
<!-- 핵심서버ip주소 등 쉽게 변하지않는 설정을 사용할 때 이용함 -->
<!-- 사용자와 무관한 설정 포함 -->

</body>
</html>