<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.message.MsgSet"%>
    
    <jsp:useBean id="messageDAO" class="model.message.MessageDAO"/>
    <jsp:useBean id="messageVO" class="model.message.MessageVO"/>
    
    <jsp:useBean id="replyDAO" class="model.reply.ReplyDAO"/>
    <jsp:useBean id="replyVO" class="model.reply.ReplyVO"/>
    
	<jsp:useBean id="userMsgDAO" class="model.userMsg.UserMsgDAO"/>
    <jsp:useBean id="userMsgVO" class="model.userMsg.UserMsgVO"/>
    
    
    
<%
	String action = request.getParameter("action");

// 메인페이지 이동(각 댓글별 데이터 전송)
	if(action.equals("main")){
		
		ArrayList<MsgSet> msg_Lists = messageDAO.msg_SELECT_ALL(10, "");
		request.setAttribute("msg_Lists", msg_Lists);
		
		pageContext.forward("main2.jsp");
		
		
	}

%>