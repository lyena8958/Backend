<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>필터 실습</title>
</head>
<body>
	<!-- 여기서 한글로 전송시 >> b.jsp에서 한글문자가 깨져서 나온다 -->
	<!-- 이를 필터를 통해서 국제화 처리를 해줄 것이다. -->
<form action="b.jsp" method="post">
	<input type="text" name="test">
	<input type="submit" value="전송">
</form>
<!-- 서버 → 필터init → a페이지 → 필터 doFilter → b페이지 수행됨 -->
</body>
</html>


<!-- 서버에 add end Remove 에 있는 파일들은 -->
<!-- 어노테이션이 있는 리스너라 필터 등을 모두 실행을 시켜놓기 때문에 -->
<!-- 충돌이 발생할 수가 있으므로, remove를 통해 속도개선을 할 수가 있다. -->