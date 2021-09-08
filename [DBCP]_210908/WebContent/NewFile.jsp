<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP 테스트</title>
</head>
<body>

<h2>DBCP 연결 테스트</h2>
<hr>

<!-- DBCP에 설정한 5개 중 하나 -->
<!-- query = select // update = insert update delete --> <!-- jdbc/orcl 하나로 모두 불러옴 -->
<sql:query var="rs" dataSource="jdbc/orcl">
	SELECT * FROM TEST 
</sql:query>

<c:forEach var="v" items="${rs.rows}"> <!-- rs.rows. 데이터를 받아오겠다. -->
	${v.name } / ${v.email } <br>
</c:forEach>

</body>
</html>
