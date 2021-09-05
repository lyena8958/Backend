<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memberDAO" class="day44_0827_testDB.MemberDAO" scope="application"/>

<jsp:useBean id="memberVO" class="day44_0827_testDB.MemberVO"/>
<jsp:setProperty property="*" name="memberVO"/>
 <%
 	boolean login = memberDAO.loginCheck(memberVO);
 	String mod = request.getParameter("mod");
 	if(login || mod!=null){
 		//로그인에 성공했다면 세션에 고객데이터 추가
 		session.setAttribute("memberVO", memberVO);
 		if(mod.equals("소비자")){
 			response.sendRedirect("user.html");	
 		}
 		else if(mod.equals("점주")){
 			response.sendRedirect("admin.jsp");
 		}
 		
 	}
 	else{
 		out.println("<script>alert('로그인에 실패하였습니다.'); history.go(-1);</script>");
 	}
 %>


