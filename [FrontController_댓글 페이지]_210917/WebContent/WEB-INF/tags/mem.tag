<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<% if(session.getAttribute("userData")!=null){
%>
${userData.userID} 안녕!!
		<form action="msgInsert.do" method="post">
			<input type="hidden" name="userID" value="${userData.userID}">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="text" name="msg" placeholder="내용작성"> 
			<input type="submit" value="댓글달기">
		<a href="logout.do"><button type="button">로그아웃</button></a>
		<a href="main.do?user=${userData.userID}"><button type="button">내 글보기</button></a>
		</form>
<%	
}	
%>