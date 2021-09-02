<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${param.data}를 ${param.cnt}개 구매 <br>
결제금액은 ${dataBean.calc(param.data,param.cnt)}원입니다. <br>

</body>
</html>