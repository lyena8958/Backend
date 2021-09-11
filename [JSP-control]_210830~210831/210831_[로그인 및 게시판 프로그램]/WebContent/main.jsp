<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*,java.util.*"%>
<jsp:useBean id="user" class="model.userTable.UserTableVO" scope="session" />
<jsp:useBean id="list" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=user.getUserID()%>님,환영합니다!</h3>
<hr>

<a href="control.jsp?action=logout">로그아웃</a>
<hr>

<a href="form.jsp">글 작성하기</a>
<hr>

<form action="control.jsp" method="post">
<input type="hidden" name="action" value="search">
<select name="condition">
	<option selected value="title">제목</option>
	<option value="writer">작성자</option>
</select>
<input type="text" name="content">
<input type="submit" value="검색하기">
</form>
<hr>

<table border="1">
	<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>작성자</td>
	</tr>
	<%
		if(list.size()==0){
			out.println("<tr><td colspan='3'>표시할 항목 없음</td></tr>");
		}
		else{
			for(MessageVO v:(ArrayList<MessageVO>)list){
	%>
		<tr>
			<td><%=v.getMid()%></td>
			<td><%=v.getTitle()%></td>
			<td><%=v.getWriter()%></td>
		</tr>
	<%
			}
		}
	%>
</table>
</body>
</html>