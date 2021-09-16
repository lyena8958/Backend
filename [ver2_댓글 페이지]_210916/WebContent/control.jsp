<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.message.*, model.userInfo.UserInfoVO"%>

<jsp:useBean id="userInfoVO" class="model.userInfo.UserInfoVO"/>
<jsp:useBean id="userInfoDAO" class="model.userInfo.UserInfoDAO"/>
<jsp:useBean id="messageDAO" class="model.message.MessageDAO" />
<jsp:useBean id="messageVO" class="model.message.MessageVO" />
<jsp:useBean id="replyDAO" class="model.reply.ReplyDAO" />
<jsp:useBean id="replyVO" class="model.reply.ReplyVO" />

<jsp:setProperty property="*" name="userInfoVO"/>
<jsp:setProperty property="*" name="messageVO"/>
<jsp:setProperty property="*" name="replyVO"/>

<%

String action = request.getParameter("action");

// 페이징처리 -- 요청 목록개수 확인
String mcntStr = request.getParameter("mcnt");
//System.out.println(mcntStr+"들림!");
int mcnt = 0;
	if(mcntStr!=null){
		
		mcnt = Integer.parseInt(mcntStr);
	}

// 사용자 로그인 후, 기존데이터 유지를 위한 control 요청값 사전저장
String url = "control.jsp?action=main&mcnt=";
url = url + mcnt;
	
// 사용자 내글보기 요청 확인
String id = "";
//System.out.println(request.getParameter("user"));
if(request.getParameter("user")!=null){
	mcnt =  100;
	id = request.getParameter("user");
	url = url + "&user=" + id;
}



// 메인이동
if(action.equals("main")){
	// 댓글목록 전체출력 
	ArrayList<MsgSet> msgDatas = messageDAO.msg_SELECT_ALL(mcnt, id);
	
	// 회원목록 전체출력
	ArrayList<UserInfoVO> userDatas = userInfoDAO.user_SELECT_ALL(); 
	
	request.setAttribute("msgDatas", msgDatas);
	request.setAttribute("mcnt", mcnt);
	request.setAttribute("userDatas", userDatas);
	pageContext.forward("main.jsp");
}
//회원가입
else if(action.equals("signUp")){
	
	if(userInfoDAO.user_INSERT(userInfoVO)){
		out.println("<script>alert('가입 완료!'); window.close(); </script>");
	}
	else{
		out.println("<script>alert('가입 실패!'); history.go(-1); </script>");
	}
	
}
//로그인
else if(action.equals("login")){
	
	UserInfoVO userData = userInfoDAO.user_SELECT_ONE(userInfoVO);  
	
	// 로그인 비교 ID&&PW  --- 로그인 성공
	if(userData!=null){
		session.setAttribute("userData", userData);
		response.sendRedirect(url);
	}
	else{ // 로그인 실패
		out.println("<script>alert('로그인 실패!');  history.go(-1); </script>");
	}
	
	
}
//로그아웃
else if(action.equals("logout")){
	session.invalidate();
	response.sendRedirect("control.jsp?action=main");
}
//댓글추가
else if(action.equals("msgInsert")){
	if(messageDAO.msg_INSERT(messageVO)){
		response.sendRedirect(url);
	}
	else{
		out.println("<script>alert('댓글 추가실패!');  history.go(-1); </script>");
	}
	
}
// 댓글삭제
else if(action.equals("msgDelete")){
	
	// mnum을 통해 데이터 삭제
	if(messageDAO.msg_DELETE(messageVO)){
		response.sendRedirect(url);
	}
	else{
		out.println("<script>alert('댓글 삭제실패!');  history.go(-1); </script>");
	}
}
// 댓글수정
else if(action.equals("msgUpdate")){
	if(session.getAttribute("userData")==null){
		out.println("<script>alert('회원만 이용이 가능한 서비스 입니다!');  history.go(-1); </script>");
		return;
	}
	
	// mnum을 통해 단일 데이터를 정보를 모두 받아온 뒤,
	messageVO = messageDAO.msg_SELECT_ONE(messageVO);
	
	//System.out.println(messageVO+"★");
	
	// 사용자가 입력한 메세지 set
	messageVO.setMsg(request.getParameter("msg"));
	if(request.getParameter("likeCnt")!=null){
		messageVO.setLikeCnt(Integer.parseInt(request.getParameter("likeCnt")));	
	}

	// 업뎃완료 -> 메인이동
	if(messageDAO.msg_UPDATE(messageVO)){
		response.sendRedirect(url);
	}
	else{// 업뎃실패 -> 뒤로가기
		out.println("<script>alert('댓글 업뎃실패!');  history.go(-1); </script>");
	}
}
// 대댓글 추가
else if(action.equals("replyAdd")){
	//System.out.println(replyVO+"reply");
	if(session.getAttribute("userData")==null){
		out.println("<script>alert('회원만 이용이 가능한 서비스 입니다!');  history.go(-1); </script>");
		return;
	}
	
	if(replyDAO.reply_INSERT(replyVO)){
		response.sendRedirect(url);
	}
	else{
		out.println("<script>alert('리플 추가실패!');  history.go(-1); </script>");
	}
}
else if(action.equals("replyDelete")){
	if(replyDAO.reply_DELETE(replyVO)){
		response.sendRedirect(url);
	}
	else{
		out.println("<script>alert('리플 삭제실패!');  history.go(-1); </script>");
	}
}
else if(action.equals("replyUpdate")){
	if(replyDAO.reply_UPDATE(replyVO)){
		response.sendRedirect(url);
		
	}
	else{
		out.println("<script>alert('리플 업뎃실패!');  history.go(-1); </script>");
	}
}
%>
