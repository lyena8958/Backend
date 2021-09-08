<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.member.*"%>
<%request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="memberVO" class="model.member.MemberVO"/>

<jsp:setProperty property="*" name="memberVO"/>



<% 
	String action = request.getParameter("action");

if(action.equals("main")){
	ArrayList<MemberVO> memList = memberDAO.memLists();
	request.setAttribute("memList", memList);
	pageContext.forward("YN(1)_main.jsp");
}

if(action.equals("login")){
	
	MemberVO userData = memberDAO.loginCheck(memberVO);
	
	//로그인성공 == 고객정보 세션추가
	if(userData!=null){
		session.setAttribute("userData", userData);
	}
	
	response.sendRedirect("YN(1)_control.jsp?action=main");
}
if(action.equals("logout")){
	
	session.invalidate();
	response.sendRedirect("YN(1)_control.jsp?action=main");
}
if(action.equals("signUp")){
	boolean signUp = memberDAO.SignUp(memberVO);
	
	// 회원가입 == 메인이동
	if(signUp){
		response.sendRedirect("YN(1)_control.jsp?action=main");	
	}
	else{ //실패 이전페이지 이동
		out.println("<script>alert('중복 아이디가 있어 가입에 실패하셨습니다.'); history.go(-1); </script>");
	}
	
}
if(action.equals("update")){
	if(memberDAO.memUpdate(memberVO)){
		response.sendRedirect("YN(1)_control.jsp?action=main");	
	}
	else{
		out.println("<script>alert('업데이트실패!'); history.go(-1); </script>");
	}
}
if(action.equals("delete")){
	if(memberDAO.memDelete(memberVO)){
		session.invalidate();
		response.sendRedirect("YN(1)_control.jsp?action=main");	
	}
	else{
		out.println("<script>alert('탈퇴실패!'); history.go(-1); </script>");
	}
}

%>

