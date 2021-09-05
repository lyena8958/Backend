<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#area {
	background-image: url(image/보노보노.jpg);
	background-size: 150px;
	width: 400px;
	height: 100px;
	display: block;
	font-weight: bold;
}
</style>
</head>
<body>

	<!-- 
	로그인할수있는폼-> 로그인 여부
	
	방문자수확인 폼 ->
 -->

	<form method="post">
		<table id="area">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" id="pw">
				</td>
			</tr>
			<tr colspan="2">
				<td><input type="submit" value="로그인" name="login" id="login"></td>
			</tr>
		</table>
	</form>


	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if ((id=="" || pw=="")) {
			out.println("<script>alert('입력되지 않은 사항이 있습니다. 확인해 주세요.')</script>");
			
		} 
		else if(!(id==null || pw==null)) { //null이 아니라면 수행
			out.println(id +" "+ pw);
			application.setAttribute("username", "홍길동");
			application.setAttribute("cnt", 1);
			out.println("<script>alert('방문하신걸 환💥영💥')</script>");
			out.println("<a href='yn3_userHome.jsp'>" + id + "님의 홈페이지 이동</a>");
		}
	%>

</body>
</html>