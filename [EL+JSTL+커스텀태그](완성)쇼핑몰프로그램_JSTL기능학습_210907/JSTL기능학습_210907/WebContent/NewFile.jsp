<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- isErrorPage로 더 많이사용함!! ↓ 안쓸수록 좋다. (코드결함을 인지하고있기때문) 테스트용!-->
<!-- try-catch문 과 동일한 기능 -->
<c:catch var="errMsg"> <!-- 에러명을 변수에 저장 -->
	<%= 10/0 %>
</c:catch>
${errMsg}  <!-- 에러가발생했다면 수행, 안했다면 미수행 -->

<br>

<!-- int i =10 처럼 변수를 만들 수 있다. -->
<c:set var="msg" value="안녕하세요!"/> <!-- scope는 page로 default 적용된다. == page에서만 사용가능 - 다른스코프는 자주 사용되진 않는다. -->

<c:remove var="msg"/> <!-- 변수를 지울 수 있다. -->

<h1>${msg}</h1> <!-- c:out으로도 출력이 가능하다. == 다만 자주사용되진 않는다. -> EL로 사용 -->

<hr>

<!-- 객체 -->			<!-- member.email -->    <!-- value 객체속성을 정의 -->
<c:set target="${member}" property="email" value="lyena8958@gmail.com"/>
${member.name } <br>
${member.email }  <!-- hong@naver.com이 아니라 lyena8958로 나온다. -->

</body>
</html>