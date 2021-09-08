<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!-- print2.tag -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!-- print2.tag에서 정의한 어트리뷰트를 보내어 css할수있다. -->
<mytag:printDataBean border="1" bgcolor="pink">실습중입니다!</mytag:printDataBean>
<!-- 실습중입니다! == print2.tag>jsp:doBody -->
<!-- view에서 get set을 모르는  사람도 쓸수가있다. == 분업이 간편하다 -->

</body>
</html>