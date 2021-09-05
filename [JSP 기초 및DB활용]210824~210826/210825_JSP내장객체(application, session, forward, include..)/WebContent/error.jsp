<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    					<%--너 에러페이지니? 응 하고 답해줘야 NF.jsp와 호환이 된다. --%>
    					<%--본인의 페이지가 오류페이지임을 확인하기 위해 ErrorPage와 셋뚜 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러처리 페이지</title>
<style>
	#er{
		color : red;
	}
	
</style>
</head>
<body>

<h2>발생에러 : <span id="er"><%=exception %></span></h2>

</body>
</html>