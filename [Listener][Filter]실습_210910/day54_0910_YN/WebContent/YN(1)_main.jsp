<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스너+필터 개인실습_main page</title>
</head>
<body>

<form action="YN(1)_result.jsp" method="post">
	<select name="menuSelect">
		<option>${Cafelatte.menu}</option>
		<option>${IceAmericano.menu}</option>
		<option>${Affogato.menu}</option>
	</select>
<input type="submit" value="선택완료">
</form>


</body>
</html>