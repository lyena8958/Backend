<!-- 강사님풀이 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> datas = new ArrayList();
	datas.add("apple");
	datas.add("사과");
	pageContext.setAttribute("datas", datas);
%>
<c:forEach var="v" items="${datas }">
	<li>${v}</li>
</c:forEach>

<!-- 
그 EL에쓴 param이랑 스크립트 릿에서쓴 request.getParameter 이랑 같은의미가맞는건가요?
   >> 같은 의미는 아니지만 서로 간에 이용이 가능하다.
 -->
 
<form>
	<input type="number" name="num" value="0">
	<input type="submit" value="확인">
</form>
<hr>	
<% request.getParameter("num"); %>
<c:if test="${param.num%2==0 }">
	짝수
</c:if>
<c:if test="${param.num%2!=0 }">
	짝수
</c:if>
</body>
</html>