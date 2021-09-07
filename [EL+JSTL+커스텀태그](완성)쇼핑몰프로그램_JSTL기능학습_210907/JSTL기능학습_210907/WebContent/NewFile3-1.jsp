<!-- 예나풀이 -->
<%@page import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인실습-홀짝/datas forEach</title>
</head>
<body>

<!-- 
정수를 사용자가 입력
->짝수 / 홀수
-------------------------------------
AL<String> datas << 데이터를 넣어주고
	forEach로 출력해주세요-->
	
<% 
	ArrayList<String> datas = new ArrayList<String>(); 
	pageContext.setAttribute("datas", datas);
%>
<% datas.add("문자1");
datas.add("문자2");
datas.add("문자3");
datas.add("문자4");
datas.add("문자5");
%>
<form>
<div name="num1">
<input type="text" name="num" placeholder="정수를 입력해주세요.">
</div>	
<input type="submit" value="보기">

</form>
<c:if test="${param.num % 2 == 0}">
	짝수입니다.
</c:if>
<c:if test="${param.num % 2 != 0}">
	홀수입니다.
</c:if>
<hr>
<c:forEach var="vo" items="${datas}">
	${vo}

</c:forEach>

</body>
</html>