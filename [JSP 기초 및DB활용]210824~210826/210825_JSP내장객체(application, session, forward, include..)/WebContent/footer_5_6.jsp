<%--NF3.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>푸터 페이지</title>
</head>
<body>

<h2>footer.jsp에서 출력하는 메세지입니다.</h2>
<%= request.getParameter("email") %> <br> <%--항상 뭘 받던지 Str로 받는다. --%>
<%--위는 표현식 --%>

<%--위 아래 코드는 똑같다. --%>
<%
	out.println(request.getParameter("tel"));
%>

</body>
</html>