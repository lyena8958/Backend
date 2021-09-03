<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/test.tld" prefix="mytag" %>
<!-- 하나의 설정파일에 다음과 같이 uri를 지정한다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- tld-test.tld에서 element를 test로 달아서 아래처럼 입력이 된 것이다. -->
<h1><mytag:test/></h1>
<!-- 맵핑 된 tld가 호출(사용되기)시작한다면, 
미리 만들어둔 핸들러(클래스)에서 doTag메서드로 오게 되어있다. -->


</body>
</html>