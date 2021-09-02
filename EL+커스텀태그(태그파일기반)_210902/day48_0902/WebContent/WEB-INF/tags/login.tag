<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<jsp:useBean id="memberBean" class="model.MemberBean"/>
<%@attribute name="border" %>
<%@attribute name="bgcolor" %>


<%
	if(session.getAttribute("mem")==null){
		
	

%>
<form action="loginApply.jsp" method="post">
	<table border="${border}" bgcolor="${bgcolor}">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" id="id" placeholder="아이디 입력"></td>
			<td>패스워드</td>
			<td><input type="text" name="pw" id="pw" placeholder="비밀번호 입력"></td>
		</tr>
	</table>
	<input type="submit" value="로그인하기">
</form>


<%
		// 사용자가 아이디를 입력했다면
		if(request.getParameter("id")!=null){
			boolean login = memberBean.loginCheck(request.getParameter("id"), request.getParameter("pw"));
			if(login){// 로그인성공 --> 세션 등록 및 페이지 이동
				session.setAttribute("mem", memberBean);
				response.sendRedirect("loginApply.jsp");
			}
			else{//로그인 실패
				out.println("<script>alert('로그인 실패!'); history(-1);</script>");
			}
		}

	}
	else{
%>
		<script>
			function logout(){
			result = confirm("로그아웃 하시겠습니까?");
			if(result){//세션 초기화 후, login 재접속
				<%session.invalidate();
				//response.sendRedirect("login.jsp");
				%>
				 document.location.href="login.jsp";
			}
			else{//변화없음
				return;
			}
		}
		</script>
		<input type="button" value="로그아웃" onClick="logout()">
		
<%
		
	}

%>
