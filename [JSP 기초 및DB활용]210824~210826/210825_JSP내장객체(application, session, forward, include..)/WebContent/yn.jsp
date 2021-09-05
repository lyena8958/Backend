<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#odd{
		color:red;
	}
	#even{
		color : blue;
	}
</style>
</head>
<body>
<!-- 1) 1~10까지 출력해주세요

+2) 짝수는빨간글씨
	홀수는 파란글씨 -> 1~10


hint) 스크립트릿
 => html 코드 안에서 java코드를 운용할수있는가?
 -->
 
 <!-- 풀이1 -->
 <%
for(int i = 1; i <= 10; i++){
	if(i%2==0){//짝수라면
		out.println("<h2 id='even'>"+ i +"</h2>");	
	}
	else{ //홀수라면
		out.println("<h2 id='odd'>"+ i +"</h2>");
	}
}
 
 %>
 
 
 <!-- 풀이2 -->
 <%
   for(int i=1;i<=10;i++) {
      if(i%2==1){
%>
       <span id="red"><%=i %></span><BR>
   <%
      }
      else{
  %>
        <span id="blue"><%=i %></span><BR> 
<%
      }
   }
%>

</body>
</html>