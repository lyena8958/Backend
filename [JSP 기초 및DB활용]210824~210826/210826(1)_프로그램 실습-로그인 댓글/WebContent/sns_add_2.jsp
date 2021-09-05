<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 등록 페이지</title>
</head>
<body>

<%

	request.setCharacterEncoding("UTF-8");
	String msg = request.getParameter("msg"); // 직전페이지에서 작성한 데이터 msg받아오기
	// 오브젝트로 오기때문에 스트링으로 캐스팅해주자
	String username = (String)session.getAttribute("username");  //세션에 저장되어있던 정보가져오기
	// 누가 무슨댓글을썼는지
	ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");

	//메세지가 없으면 == 최초등록
	if(msgs==null){
		msgs=new ArrayList<String>();
		application.setAttribute("msgs", msgs);
	}
	
	msgs.add(username + "님이 [" + msg + "] 등록");
	
	//다시 댓글창으로 입력하게 로그인창으로 이동
	//전달할 데이터가 없으니 sendRedirect로이동 (application에서 데이터저장했기때문)
	response.sendRedirect("sns_login_2.jsp");
%>

</body>
</html>