<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<%

	if(session.getAttribute("userData")==null){
		
%>			
			<form action="login.do" method="post">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="text" name="userID" placeholder="아이디">
			<input type="text" name="userPW" placeholder="비밀번호">
			<input type="submit" value="로그인">
			<br>
			<a onClick="signUpMove()"><button type="button">회원가입</button></a>
			</form>
<%
		
	}

%>
