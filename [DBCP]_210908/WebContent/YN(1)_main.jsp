<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP 개인실습</title>
</head>
<script>
	function memDelete(){
		document.form1.action.value="delete";
		
		document.form1.submit();
	}
</script>
<body>


<login:login_mem/>
<login:login_noMem/>

<br>
<hr>
<br>
<h3>=====회원목록=====</h3>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>성명</th>
	</tr>
<c:forEach var="v" items="${memList }">
	<tr>
		<td>${v.userID}</td>
		<td>${v.userPW}</td>
		<td>${v.userName}</td>
	</tr>
</c:forEach>
</table>



</body>
</html>