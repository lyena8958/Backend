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
		<!-- get방식으로 param을 보내줄수있는것이다. --> <!--  href랑 같이 사용이된다. -->
		<!-- NewFile3.jsp에 param을 넣기위함 -->
<c:url value="NewFile2.jsp" var="testURL">
	<c:param name="test">b</c:param>
</c:url>
<h2>${testURL }</h2>
<a href="${testURL}">눌러보세요!</a>

</body>
</html>