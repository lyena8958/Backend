<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : 
<%=request.getParameter("username") %> <br>
학년 :
<%=request.getParameter("grade") %> <br>
수강과목
<%
	String str[] = request.getParameterValues("subject");
	
	if(str!=null){
		for(String v: str){
			out.println(v+" ");
		}
	}
	else{
		out.println("신청하신 수강과목이 없습니다.");
	}
%>

</body>
</html>