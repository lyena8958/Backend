<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- requried를 true로 누군가 사용했기 때문에 필수속성이 있을 수 있다. > if의 test속성 -->
<!-- ex)tld -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- msg라는 변수에 test라는 문자를 넣음 -->
<c:set var="msg" value="user"/>

<!-- else를 지원하지 않는다. -->				<!-- res는 결과를 저장한다고 한다. -->
<c:if test="${msg =='test'}" var="res"> <!-- test : 속성을 입력하지 않았는데도 나온경우는 >> 필수속성이다. -->
	1-결과는  [${res}] 입니다. <!-- 바디태그 -->

</c:if>

<!-- res는 if문밖에서도 사용이 가능하다. == false, true-->


<!-- else대체 -->
<c:if test="${msg !='test'}" var="res"> <!-- test : 속성을 입력하지 않았는데도 나온경우는 >> 필수속성이다. -->
	2-결과는  [${res}] 입니다. <!-- 바디태그 -->
</c:if>

<!-- if문 사용예시 : 관리자니? -->
<!-- 로그인, 로그아웃 -->
<!-- 받아온데이터가 재고가 0이니? -->

</body>
</html>