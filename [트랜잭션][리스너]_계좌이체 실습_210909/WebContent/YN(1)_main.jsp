<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 트랜잭션-계좌이체실습_main page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트랜잭션 실습-view</title>
</head>
<body>

<form action="YN(1)_control.jsp">
<input type="hidden" name="action" value="pay">

<table border="1">
	<tr>
	<th>보낼분&nbsp;&nbsp;|&nbsp;&nbsp;금액</th>
	<th>받는분</th>
	<th>이체하기</th>
	</tr>
	<tr>
	<td><input type="text" name="outUser" placeholder="성함입력"><input type="number" name="money"></td>
	<td><input type="text" name="inUser" placeholder="성함입력"></td>
	<td><input type="submit" value="이체"></td>
	</tr>

</table>
</form>

<br><br><br>
<hr>
<h3>=========고객목록=========</h3>

<table  border="1">
<tr>
	<th>고객명</th>
	<th>통장잔액</th>
</tr>
<c:forEach var="v" items="${bankList}">
<tr>
	<td>${v.bname }</td>
	<td>${v.balance }원</td>
</tr>

</c:forEach>


</table>



</body>
</html>