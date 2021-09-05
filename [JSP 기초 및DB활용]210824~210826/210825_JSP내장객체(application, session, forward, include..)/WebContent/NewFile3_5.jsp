<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 액션태그</title>
<%--jsp 액션태그 >> "jsp:" useBean, getProperty, setProperty --%>
<%--jsp로 시작하는게 jsp의 액션태그다 --%>
</head>
<body>
<%--결론 자주안바뀌는건 NF2.jsp의 지시어 include를사용하고 --%>
<%--자주바뀌는건 액션태그의 include를 사용하자 ↓ --%>
<h2>NewFile3.jsp 페이지 입니다.</h2>
<hr>
<%--include 지시어에서(NF2_4) → include 액션태그로 보는중 --%>
<%--즉각적인 파라미터가 가능한 것으로 보아 매우 동적이다. --%>
<%--param == 파라미터(매개변수) --%>
<jsp:include page="footer_5_6.jsp">
	<jsp:param value="coding_helper@naver.com" name="email"/> 
	<jsp:param value="010-1234-5678" name="tel"/>
</jsp:include> 
<%--jsp뒤에 /를주면 짝없이 사용하겠다는 것 > 바디를 줄수도있고 안줄수도있다는 것이다. > 바디가있으면 인자(파라미터를 넘길 수가 있다.) --%>
<%--jsp:include 파트분배, 유지보수, 협업 --%>
<%--파트분배, 유지보수, 협업은 코더들이 반드시 생각해야 될 부분이다. --%>

<%--태그 바디 , h1에게는 있고 br에게는 없는 것, a한테는 있는데 img에게는 없는 것--%>
<%--태그는 짝을 갖고나오게되어있으나, 일부는 짝이없다. --%>
<%--태그바디가있음에따라 동적이라고 볼수가있다. --%>

<%--지시어의 include에서 하나씩 불러서 한번에 실행됐다면 == 한개라도 바뀌면 컴파일러를 모두 다시한다.
☆일단 NF3. 를 실행하다가 19번 액션태그를 만나면 그때 불러와서 실행되는 방식
 -> ==  변경요소가 있을때 해당 변경되는 페이지만 적용됨
 --%>

<%--자기페이지에 include를 포함시키는방식 --%>

</body>
</html>