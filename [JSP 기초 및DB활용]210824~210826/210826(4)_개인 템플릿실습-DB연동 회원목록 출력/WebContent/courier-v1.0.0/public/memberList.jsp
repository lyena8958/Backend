<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,day44_0827_testDB.MemberVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="memberDAO" class="day44_0827_testDB.MemberDAO" scope="application"/>

<jsp:useBean id="memberVO" class="day44_0827_testDB.MemberVO"/>
<jsp:setProperty property="*" name="memberVO"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>●참치라이더 멤버공유●</title>
</head>
<body>

<%
	ArrayList<MemberVO> datas = memberDAO.memSelectAll();
%>

<table border="1">
	<tr>
		<th>성명</th>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
	
	<% 
		if(datas!=null){
			for(MemberVO vo: datas){
	%>		<tr>
			<td><%=vo.getUserName() %></td>
			<td><%=vo.getUserID() %></td>
			<td><%=vo.getUserPW() %></td>
			</tr>
	<% 
			}
		}
		else{
	%>
			<td colspan="3">가입 멤버 내역이 없습니다.</td>
	<%	}
	%>
	
</table>


</body>
</html>