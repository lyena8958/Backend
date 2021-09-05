<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩 vs 리다이렉팅</title>
</head>
<body>
<!-- 자바코드가 없으니 html로 사용해도 무관 -->
<!-- 이름과 이메일이 뜨며, url이 forward.jsp로 바뀜  (forward페이지에서 호출한 페이지로 주도권을 넘김)-->
<!-- 1) forward.jsp 페이지 요청  -->
<!-- get방식이었다면 forward.jsp?username="사과"...이런식으로 나왔을 것임 -->
<form action="forward_8.jsp" method="post">
	<input type="text" name="username">
	<input type="submit" value="페이지 이동">
</form>

<hr>
<!-- 위와 아래의 차이점은 어느 파일로 향하느냐 그것밖에없다. -->

<!-- 이메일은 당연히 안나오는데, 이름도 안나온다 -->
<!-- response객체를 주체로한 샌드리다이렉팅 방식은 
	기존 jsp 액션태그(forward방식)와 다르게, 
	페이지를 전환/이동 할때에  전환과 이동을 위한, request, response 매번 객체를 새로 생성함-->
<!-- 데이터가 따라다니느냐(forward) VS 매번 생성되느냐(샌드리다이렉팅) >> 보통은 forward를 사용함-->
<form action="response_sendRedirect_8.jsp" method="post">
	<input type="text" name="username">
	<input type="submit" value="페이지 이동">
</form>


<!-- 
강사님 ㅎㅎ.. 또 질문할거있는데욤..!
forward를부르면 URL foward.jsp로 뜨고, 
redirect를 부르면 URL result.jsp로 나오는데 요거 차이점이 

forward는 본인페이지이나, "주도권만" 불러낸 페이지로 넘어가서 result페이지의 데이터?를 forward로 모두 갖고와서 그런거고,
redirect 페이지를 넘겨주기위해 request를 새로만드는(새로고침형식..?)것이  제가 잘이해한게맞나용??

==> 맞음, 근데 redirect는 페이지를 새로 생성하는형식
 -->

</body>
</html>