<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model.*"%>
	errorPage="errorPage.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memberDAO" class="model.MemberDAO"/>

<jsp:useBean id="memberVO" class="model.MemberVO"/>
<jsp:setProperty property="*" name="memberVO"/>


<%     
	String action = request.getParameter("action");

	//로그인시 세션이 있다면 --> 다음페이지 이동
	// 없다면 --> 로그인 화면으로 이동
	if(action.equals("login")){
		if(session.getAttribute("signin")!=null){
			response.sendRedirect("loginApply.jsp");
		}
		else{
			response.sendRedirect("login.jsp");
		}
		
	}
	// 회원가입 데이터 생성
	if(action.equals("signup")){
		boolean signup = memberDAO.SignUp(memberVO);
		request.setAttribute("signup", signup);
		pageContext.forward("signupApply.jsp");	
		
	}

	if(action.equals("loginCheck")){// 로그인 성공
		System.out.println(memberVO);
		boolean signin = memberDAO.LoginSelectOne(memberVO);
		if(signin){		
				session.setAttribute("signin", signin);
	 			response.sendRedirect("login.jsp");	
		}
		// 로그인 실패
		else{
 		out.println("<script>alert('로그인에 실패하였습니다.'); history.go(-1); </script>");
 		}
	}

	// 로그아웃
	if(action.equals("logout")){
		session.invalidate();
		response.setContentType("UTF-8");
		pageContext.forward("index.html");
	}
	
	


%>