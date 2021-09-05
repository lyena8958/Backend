<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- 배포(라이브러리)했으니 uri -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<!-- !!!!순수 뷰!!!! -->

<table border="1">
<c:forEach var="v" items="${members}">
	<tr>
		<td>${v.name}</td>
		<td>${v.email}</td>
		
		<!-- 그대로 읽지말라는 속성추가  escapeXml-->
		<!-- 아래 코드보다 if else로 사용하는 경우가 더 많다 -->
		<td><c:out value="${v.email}" escapeXml="false"><font color="red">email 정보없음</c:out></td> <!-- 출력 c:out 많이는 안쓰임> 이메일이 빠졌을 때 --email정보없음 -->
		<!-- 데이터가 없을때만 태그바디에 있는 텍스트가 출력 될 수 있었던건, -->
		<!-- EL식에서 입력이안되어있으면 null인데, (출력되지는 않음 왜냐하면 string이니까) -->
		<!-- null이라면 태그바디를 출력하는 기능인 것이다. -->
		
		<!--  <td><c:out value="${v.email}"><font color="red">email 정보없음</c:out></td>-->
		
		
	</tr>
</c:forEach>
</table>


</body>
</html>