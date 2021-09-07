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

<!-- jsp:include -->
	<!-- 이때 가져오는 페이지는 "자원"이라고 한다. -->
	
	
	<!-- 페이지 소스를 이용할 때 사용된다. -->
	
<!-- 내부자원 넣기 -->
<!-- jsp include와 비슷한 기능이다 -->
<c:import url="NewFile0.jsp" var="innerURL"/>
<c:out value="${innerURL}" escapeXml="false"/>

<hr>

<!-- 외부자원 넣기 -->
<c:import url="https://www.naver.com/" var="outerURL"/>
<c:out value="${outerURL}" escapeXml="false"/>

</body>
</html>