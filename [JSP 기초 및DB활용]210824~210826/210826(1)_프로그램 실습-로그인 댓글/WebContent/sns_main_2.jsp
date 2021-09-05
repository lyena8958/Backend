<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 완료된 화면</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	
	//조건문을 안걸으면 매번 set username을하게됨
	// request를 안했을 때에, == 넘어온값을 없을때는 등록안하고
	// 있을때만 등록하겠다.
	
	//System.out.println(session);
	if(username!=null){//add에서 다시돌아왔을때 기존 이름을 가져오기위함
		//System.out.println(username);// 로깅기법
		session.setAttribute("username", username);	
	}
	
%>

<h1>현재 페이지</h1>
<hr>
<form action="sns_add_2.jsp" method="post">
	[<%=session.getAttribute("username") %>] <input type="text" name="msg">
	<input type="submit" value="댓글 작성하기">

</form>
<hr>
<!-- 지금까지 등록된 글 올리기 -->
<ol>
<% // 메세지가 있다는걸 가정하고 갖고와서 값을 출력 
	ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
	// 여기서 어플리케이션 셋어트리뷰트를 안한 이유는 메세지가 최초로 생성될때하는것이다 == sns_add
	if(msgs!=null){
		for(String v: msgs){
			out.println("<li>"+v+"</li>");
		}
	}
%>
</ol>

</body>
</html>