<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="cafe" class="test.CafeBean"/>
    <jsp:setProperty property="*" name="cafe"/>
<!DOCTYPE html>
	<% cafe.totalAccount();%>

<!-- 커피 키오스크

1) 커피는 아메리카노 / 카페라떼
	2000	2500

2) 종류, 개수


3) 총 금액

.jsp + java(빈즈 컴포넌트) -->
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Kiosk(2-jsp)</title>
<style>
form, div, h2, span, select, option, input{
	margin : 0;
	padding : 0;
}
form{
	margin-top : 10%;
	margin-left : 10%;
	
}
#area{
	background-color : #007042;
	color : white;
}
#menu{
	width : 450px;
	margin-bottom : 10px;
	margin : 10px;
}
</style>
</head>
<body>
<div id="area">
<form method="post" id="form3">

	<div id="menu">
	<h2>메뉴판</h2>
	<span>아메리카노 : 2,000원</span>
	<span>카페라떼 : 2,500원</span>
	</div>
	
	<select name="type" id="type">
		<option>아메리카노</option>
		<option>카페라떼</option>
		<option>카라멜마끼아또</option>
		<option>밀크티</option>
		<option>타로스무디</option>
		<option>망고스무디</option>
		<option>제주그린티</option>
	</select>
	<select name="addType" id="addType">
		<option>펄 추가</option>
		<option>알로에 추가</option>
		<option>디카페인 추가</option>
		<option>샷 추가</option>
	</select>
	
	<input type="text" name="cnt" id="cnt" placeholder="주문할 개수를 입력">

	<input type="submit" value="계산하기" name="totalAccount" id="totalAccount">
	<input type="reset" value="입력값 초기화">

</form>
<hr>
<h3>총 금액 : <jsp:getProperty property="result" name="cafe"/> </h3>
</div>
</body>
</html>