<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 트랜잭션-계좌이체실습_payApply page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금 여부</title>
</head>
<body>

<c:if test="${pay == true }" >
	<h3>결제가 완료되었습니다!</h3>	
</c:if>


<c:if test="${pay == false }" >
	<h3>금액이 부족하여 입금이 실패되었습니다.</h3>
</c:if>
	<a href="YN(1)_control.jsp?action=main"><button type="button">메인으로 가기</button></a>
</body>
</html>