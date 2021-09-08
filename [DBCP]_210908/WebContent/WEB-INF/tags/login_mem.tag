<%@ tag language="java" pageEncoding="UTF-8"%>

<% 
// 로그인이 되었다면,
if(session.getAttribute("userData")!=null){

%>
<form action="YN(1)_control.jsp"method="post">
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="mnum" value="${userData.mnum }">
	<p>아이디&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;${userData.userID}</p>
	<input type="text" name="userPW" value="${userData.userPW}" placeholder="비밀번호 입력" required>
	<input type="text" name="userName" value="${userData.userName}" placeholder="성함 입력" required>
	<input type="submit" value="회원수정">
	<a href="YN(1)_control.jsp?action=delete&mnum=${userData.mnum }"><input type="button" value="회원탈퇴"></a>
	<a href="YN(1)_control.jsp?action=logout"><input type="button" value="로그아웃"></a>
</form> 
	
<%
}

	
	
	%>

