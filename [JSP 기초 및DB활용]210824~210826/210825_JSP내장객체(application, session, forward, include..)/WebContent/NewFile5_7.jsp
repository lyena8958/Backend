<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체-request 결과페이지</title>
<!-- 사용자입력폼 >> NF6.html -->
</head>
<body>
	<!-- 어차피 출력을 할거니 표현식으로 out을 통해 출력해줘도 된다. -->
	이름 :
	<%=request.getParameter("username")%>
	<br> 학년 :
	<%=request.getParameter("grade")%>
	<br>
	<%
		String data[] = request.getParameterValues("subject");
		// data[] == null
		//System.out.println(data); == null // 로깅기법
	
		if(data != null){
			out.println("수강하는 과목 <br>");
			for(String v: data){
				out.println(v+ "<br>");	
			}
		}
		else{
			out.println("- 수강과목 없음 -");
		}
		
		
		/*if (request.getParameterValues("subject") == null) {
			out.println("- 수강과목 없음 - ");			
			
		} else {
			String data[] = request.getParameterValues("subject");
			for (String v : data) { // foreach
				out.println(v + "<br>"); // 띄워쓰기가 없으니 br로 해주자.
			}
		}*/
	%>
	<%--request.getParameterValues(name)는 str 배열로 받음 --%>
</body>
</html>