<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String mod = request.getParameter("mod");
		
		

		// 사용자 입력정보 가져옴
		if (userId.equals("") || mod == null) {// 아이디 혹은 모드 선택안했다면
			out.println("<script>alert('입력안한 항목이 있습니다!'); history.go(-1);</script>");

		}
		else{
			session.setAttribute("userId", userId);
			session.setAttribute("mod", mod);
			if (mod.equals("user")) {
				response.sendRedirect("user.jsp");
			} 
			
			else if (mod.equals("admin")) {
				response.sendRedirect("admin.jsp");
			}	
		}
		
		
		
	%>
</body>
</html>