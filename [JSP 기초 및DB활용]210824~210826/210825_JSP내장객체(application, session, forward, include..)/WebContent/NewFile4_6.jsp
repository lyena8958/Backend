<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 액션태그</title>

</head>
<body>
<%-- forward로 불러오는 페이지만  보여주고 본페이지는 수행하지않음--%>
<h2>NewFile4.jsp 페이지 입니다.</h2>
<hr>
<%--즉각적인 파라미터가 가능한 것으로 보아 매우 동적이다. --%>
<%--param == 파라미터(매개변수) --%>
<jsp:forward page="footer_5_6.jsp">
	<jsp:param value="lyena8958@gmail.com" name="email"/> 
	<jsp:param value="010-3368-8958" name="tel"/>
</jsp:forward> 
<%--param역시 forward에서 사용이 가능하다. --%>

<%--주도권을 넘긴상태로 다시 받아오지 않음 > footer.jsp로 서비스가 됨 내부적으로는 12, 13라인이 실행을 됐겠지만--%>
<%--보여주진않고있는 것 --%>

<%--왜 사용하냐고 싶을수도있지만, 정보를 주고 굳이 돌아오지않아도된다면 forward를쓴다.--%>
<%--현재 페이지가 돌아와야한다면(EX검색결과) 액션태그의 INCLUDE 를쓴다.--%>

</body>
</html>