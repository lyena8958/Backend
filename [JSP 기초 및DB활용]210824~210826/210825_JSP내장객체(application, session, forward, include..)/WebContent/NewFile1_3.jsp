<%-- 지시어 : 내장객체(1) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%><%--지시어 --%>
    					<%--errorPage 에러가 발생했다면! 이곳으로 보내주세요~ (error.jsp) --%>
    					<%--마치 웹툰페이지에서 없는 화를 눌렀을때 다른창으로 보내준 것처럼 --%>  
    					<%--이후 에러 페이지에서도 isErrorPage를 통해 true로 적용해주어야 한다. --%>
    					
    					<%--본인의 페이지가 오류페이지임을 확인하기 위해 isErrorPage와 셋뚜 --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--일부러 오류를 작동시키자. --%>
<% 
String str="test";
	int i = Integer.parseInt(str);
%>
<%-- 에러문구 : java.lang.NumberFormatException: For input string: "test" --%>
<%--url에서 뒷부분이 NewFile1.jsp인데, 이 페이지에서 에러임을 나타났으며  --%>
<%--error페이지 처리가 된 페이지 임을 암시할수있다. == 너가어디까지 완료했는지 알수있는 단서다. --%>
</body>
</html>