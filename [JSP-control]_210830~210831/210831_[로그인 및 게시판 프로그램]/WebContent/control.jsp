<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String condition=request.getParameter("condition");
	String content=request.getParameter("content");
	//System.out.println(condition+" "+content);
%>
<jsp:useBean id="mDAO" class="model.message.MessageDAO" />
<jsp:useBean id="uDAO" class="model.userTable.UserTableDAO" />
<jsp:useBean id="uVO" class="model.userTable.UserTableVO" />
<jsp:setProperty property="*" name="uVO"/>
<jsp:useBean id="mVO" class="model.message.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<%
	String action=request.getParameter("action");
	if(action.equals("login")){
		uVO=uDAO.selectOne(uVO);
		if(uVO==null){
			out.println("<script>alert('로그인 실패!');history.go(-1)</script>");
		}
		else{
			session.setAttribute("user", uVO);
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		pageContext.forward("index.jsp");
	}
	else if(action.equals("insert")){
		mDAO.insertDB(mVO);
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("search")){
		ArrayList<MessageVO> list=mDAO.selectAll(condition,content);
		request.setAttribute("list", list);
		pageContext.forward("main.jsp");
	}
	else if(action.equals("main")){
		ArrayList<MessageVO> list=mDAO.selectAll("title", "");
		request.setAttribute("list", list);
		pageContext.forward("main.jsp");
	}
%>