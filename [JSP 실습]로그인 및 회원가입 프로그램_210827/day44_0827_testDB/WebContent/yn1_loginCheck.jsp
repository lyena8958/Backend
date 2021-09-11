<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="day44_0827_testDB.MemberVO"%>
<% request.setCharacterEncoding("UTF-8"); %>
 <jsp:useBean id="memberDAO" class="day44_0827_testDB.MemberDAO" scope="application"/>
 <jsp:useBean id="memberVO" class="day44_0827_testDB.MemberVO"/>
 <jsp:setProperty property="*" name="memberVO"/>
 <%
 	boolean login = memberDAO.loginCheck(memberVO);
 
 	if(login){
 		//로그인에 성공했다면 세션에 VO속성추가
 		session.setAttribute("memberVO", memberVO);
 
 		//out.println("<script>alert('로그인이 성공하였습니다.');</script>");
 		response.sendRedirect("yn1_loginApply.html");
 	}
 	else{
 		out.println("<script>alert('로그인 실패하였습니다.'); history.go(-1);</script>");
 	}
 %>
