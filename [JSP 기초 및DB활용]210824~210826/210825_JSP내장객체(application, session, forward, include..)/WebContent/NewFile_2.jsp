<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Date"%>
<%--  "%@ page" 로된 태그는 페이지 지시어(JSP지시어) 라고 함. -  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2><%= new Date() %></h2> 
<!-- "%=" 표현식  → 서블릿 파일로 변환되었을 때, -->
<!-- (서블릿파일 변환시)NewFile_jsp.java 안에서 표현식 부분은  out.println(new Date())로 변환이 되는데, %= new Date()%와 같다고 볼 수 있다. %-->
<%--이 주석(JSP 주석)은 개발자끼리의 소통을 할 때 주로 사용된다. (페이지 소스코드에서 보이지않음) --%>


</body>
</html>