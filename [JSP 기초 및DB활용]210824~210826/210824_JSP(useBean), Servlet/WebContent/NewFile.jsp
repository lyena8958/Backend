<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- import = "java.util.Date" > 실무스타일 -->
    <!-- contentType="text/html == Test.java(서블릿) > setContentType이 같은데, 
    	이는 JSP에서도 응답할 내용을 이 파일에서 할수도 있다.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=new java.util.Date() %>  <!-- import를안할 경우  앞에 써주자-->
<!-- new Date() > 상단에 import를해준경우 -->

</body>
</html>