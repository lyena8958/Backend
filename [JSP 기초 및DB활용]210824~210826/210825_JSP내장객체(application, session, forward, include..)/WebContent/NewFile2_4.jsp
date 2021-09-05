<%-- 지시어 : 내장객체(2) --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inClude 지시어</title> <%-- inClude : 현재페이지에 다른 페이지를 추가--%>
<style>
#box1{
	border : 1px solid red;
}
#box2{
	border : 1px solid blue;
}

</style>
</head>
<body>
<%--include지시어가 오른쪽에 작성된 파일을 죄다 긁어오는것 > 1번라인부터 긁어와서 본인 페이지에 가져오는 것 >> 구조가잡혀있으니 불러오는 페이지는 기본만 갖춰있으면된다--%>
<%@ include file="menu_4.jsp" %>  <%--지시어를 쓸거야 , include지시어를, 어떤페이지 추가? menu.jsp추가할거얌 --%>
<hr>
<div id="box1"><%@ include file="news_4.jsp" %></div>
<div id="box2"><%@ include file="shopping_4.jsp" %></div>
<%--파트분배, 유지보수, 협업에 좋다. > 자주바뀌는 페이지에는 불리하며, 안바뀌는 페이지로하는게 좋다. --%>

<%-- include의 호출된 페이지 코드를 다끌고와서 하나의 servlet을 만드는 것이다. > 그러기에 기본구조 태그생략이 가능하다. --%>
<%-- 메뉴는 괜찮지만, news,shopping는 자주바뀌기때문에 전체가 다 servlet를 다시 만들어야하기 때문에 불리하다.  --%>
<%-- 유지보수는 편하지만 한 글자라도 바뀌면 서블릿페이지가 다시 처음부터 변환을해주어야 하기 때문에 불리하다는 것이다.  --%>

<%--자주바뀌는 애는 어떻게할까? NF3.jsp로 알려줌 --%>
</body>
</html>