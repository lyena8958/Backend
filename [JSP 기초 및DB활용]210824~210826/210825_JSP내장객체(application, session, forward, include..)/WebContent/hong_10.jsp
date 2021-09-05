<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홍길동님의 미니홈피</title>
</head>
<body>

<!-- 미니홈피에 들어오는순간 방문자수를 +1할 것임 -->
<%
	//캐스팅(형변환)	// application.getAttribute("cnt"); --> 오브젝트로 넘어오니 자료혀
	   int cnt=(Integer)application.getAttribute("cnt");//애플리케이션객체에 저장된 값;
	 cnt++;
	 application.setAttribute("cnt", cnt); //cnt에 14번라인에서 설정한 cnt값을 넣어줌
%>

<h2>투데이 방문자 수: <%= cnt %> </h2> <!-- 초기설정된 1에서 증감됨을알수있음 -->


</body>
</html>