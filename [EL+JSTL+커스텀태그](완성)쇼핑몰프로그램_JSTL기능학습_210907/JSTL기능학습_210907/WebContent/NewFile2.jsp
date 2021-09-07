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

<form>
	<select name="test">
		<option>-</option> <!-- 선택한 항목을 고정시키고싶다 == 삼항연산자활용 -->
		<option ${param.test=='a'? 'selected':'' }>a</option>
		<option ${param.test=='b'? 'selected':'' }>b</option>
		<option ${param.test=='c'? 'selected':'' }>c</option>
				<!-- 한페이지에서 장바구니 여러개 담는 것처럼 -->
	</select>
	<input type="submit" value="선택완료">
</form>
<hr>

<!--여기서 test인자를 부르고 싶다면  -->
<!-- $param.test로 EL식으로 부를 수 있다. -->

<!-- 스위치문과 흡사 -->
<c:choose>
	<c:when test="${param.test=='a' }"> <!-- case1 -->
		a를 선택했습니다.
	</c:when>
	<c:when test="${param.test=='b' }"> <!-- case2 -->
		b를 선택했습니다.
	</c:when>
	<c:otherwise> <!--보통은 when을 더 추가해서 쓴다 (안정성, 유지보수성) --> <!-- a도 b도 아니라면 default처럼 사용-->
		c를 선택했습니다. 	
	</c:otherwise>
</c:choose>

</body>
</html>