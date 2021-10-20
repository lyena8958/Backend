<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="model.board.BoardVO"></jsp:useBean>
<jsp:useBean id="dao" class="model.board.BoardDAO"></jsp:useBean>

<%

	if(dao.deleteBoard(vo)){
		response.sendRedirect("main.jsp");
	}
	else{
		out.println("<script>alert('실패!'); history.go(-1);</script>");
	}

%>