<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="yn2_forward.jsp" method="post">
	<input type="text" name="username" id="username" placeholder="이름을 입력해주세요.">
	<select name="grade">
		<option>1학년</option>
		<option>2학년</option>
		<option>3학년</option>
	</select>
	<input type="checkbox" name="subject" value="국어">국어
	<input type="checkbox" name="subject" value="영어">영어
	<input type="checkbox" name="subject" value="수학">수학
	<input type="checkbox" name="subject" value="html">html
	<input type="checkbox" name="subject" value="java">java
	<input type="submit" value="forward이동">
</form>

<form action="yn2_redirect.jsp" method="post">
	<input type="text" name="username" id="username" placeholder="이름을 입력해주세요.">
	<select name="grade">
		<option>1학년</option>
		<option>2학년</option>
		<option>3학년</option>
	</select>
	<input type="checkbox" name="subject" value="국어">국어
	<input type="checkbox" name="subject" value="영어">영어
	<input type="checkbox" name="subject" value="수학">수학
	<input type="checkbox" name="subject" value="html">html
	<input type="checkbox" name="subject" value="java">java
	<input type="submit" value="redirect이동">
</form>


</body>
</html>