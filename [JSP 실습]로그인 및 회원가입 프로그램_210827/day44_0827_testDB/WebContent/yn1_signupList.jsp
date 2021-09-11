<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, day44_0827_testDB.MemberVO"%>
 <jsp:useBean id="memberDAO" class="day44_0827_testDB.MemberDAO" scope="application"/>
<%
	response.setCharacterEncoding("UTF-8");

	ArrayList<MemberVO> datas = memberDAO.memSelectAll();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style>
a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>No</th>
			<th>성명</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
<% 		
		// memSelectAll에서 반환된 데이터가 없다면 == 회원정보없음
		if(datas.size()==0||datas==null){
%>		
		<tr>
			<td colspan="4"><h3>회원정보가 없습니다.</h3></td>
		</tr>
<%	
		 }
		else{// 데이터가 있다면 회원정보 출력
			int i = 0; // 회원목록수
			for(MemberVO vo : datas){
			i++;
%>
		<tr>
			<td><%=i %></td>
			<td><%=vo.getUserName() %></td>
			<td><%=vo.getUserID() %></td>
			<td><%=vo.getUserPW() %></td>
		</tr>
<% 				
			}
		}
%>


	</table>

	<button type="button">
		<a href="yn1_index_login.html">처음으로 돌아가기</a>
	</button>
</body>
</html>