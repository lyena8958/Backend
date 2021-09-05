<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %> 
    <!-- 한글로 인식못해서 오류가생기니 넣어줄것 -->
    
<!DOCTYPE html>
<%
	int result = 0;
	if(request.getMethod().equals("POST")){
		
		String type= request.getParameter("type");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		if(cnt < 1){//유효성검사
			result = 0;
		}
		else{
			if(type.equals("아메리카노")){
				result = cnt * 2000;
			}
			else if(type.equals("카페라떼")){
				result = cnt * 2500;
			}
		}
	}

%>
<!-- 커피 키오스크

1) 커피는 아메리카노 / 카페라떼
	2000	2500

2) 종류, 개수


3) 총 금액

.jsp -->

<html>
<head>
<meta charset="UTF-8">
<title>Coffee Kiosk(1-jsp)</title>
<style>
form, div, h2, span, select, option, input{
	margin : 0;
	padding : 0;
}
form{
	margin-top : 10%;
	margin-left : 10%;
}
#menu{
	width : 450px;
	margin-bottom : 10px;
	background-color : lightblue;
}
</style>
</head>
<body>

<form method="post" id="form3">
	
	<div id="menu">
	<h2>메뉴판</h2>
	<span>아메리카노 : 2,000원</span>
	<span>카페라떼 : 2,500원</span>
	</div>
	<select name="type" id="type">
		<option>아메리카노</option>
		<option>카페라떼</option>
	</select>
	
	<input type="text" name="cnt" id="cnt" placeholder="주문할 개수를 입력">

	<input type="submit" value="계산하기" name="totalAccount" id="totalAccount">
	<input type="reset" value="입력값 초기화">
</form>
<hr>
<h3>총 금액 : <%= result %> </h3>

</body>
</html>