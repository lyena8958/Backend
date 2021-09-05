<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
span{
	color : hotpink;
}
</style>
<body>
<%

	int cnt=(Integer)application.getAttribute("cnt");//애플리케이션객체에 저장된 값;
	cnt++;
	application.setAttribute("cnt", cnt); //cnt에 14번라인에서 설정한 cnt값을 넣어줌


%>
<h2>사장님!!</h2>
<h2>오늘의 결제된 횟수는 <span><%=cnt %>회</span> 입니다. 부자되세용ヾ(•ω•`)o</h2>

</body>
</html>