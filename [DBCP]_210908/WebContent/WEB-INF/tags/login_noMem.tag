<%@ tag language="java" pageEncoding="UTF-8"%>

<% 
	// 로그인이 완료가 안되었다면,
	if(session.getAttribute("userData")==null){
%>
<form action="YN(1)_control.jsp"method="post">
	<input type="hidden" name="action" value="login">
	<input type="text" name="userID" placeholder="아이디 입력" required>
	<input type="password" name="userPW" placeholder="비밀번호 입력" required>
	<input type="submit" value="로그인하기">
	<a href="YN(1)_signup.jsp"><button type="button">회원가입하기</button></a>
</form> 
	
<%
	}	
%>

