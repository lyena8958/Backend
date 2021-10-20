<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="vo" class="model.board.BoardVO"/>
<jsp:useBean id="dao" class="model.board.BoardDAO"/>
<jsp:setProperty property="*" name="vo"/>

<%
	if(dao.updateBoard(vo)){
		response.sendRedirect("main.jsp");
	}
	else{
		out.println("<script>alert('오류발생!'); history.go(-1); </script>");
	}

%>
