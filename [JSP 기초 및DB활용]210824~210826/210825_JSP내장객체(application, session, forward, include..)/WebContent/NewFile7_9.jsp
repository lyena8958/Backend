<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장객체</title>
</head>
<body>

<!-- 매번 세션을 동작을하니까 if조건문을 걸어주자. -->
<%						
	//세션이 새거니? 세션이 만료될때에만 셋팅하도록 조건문설정(데이터사라짐)
	if(session.isNew()){//if를 설정안했다면 페이지를 볼때마다 세션생성, 
		out.println("<script>alert('세션을 설정함!')</script>");
						// 어떠한 값을(value) name으로 지정할수있다.
						// 포켓몬객체(value)를 피카츄(name)이라할수있다.
	session.setAttribute("user", "coding_helper");
	// coding_helper라는 사람이 
	// user 라는 변수명(이름)으로 등록됨
	// 어떤 단위로? 세션단위로 등록이 되었다. == 브라우저가 종료되지 않는한, 사라지지않음!(페이지가 몇번이고 넘어가도 남음) 
	//									장바구니처럼, 로그인 처럼
	// 							  == 시간개념이있는데, 30분(==1800초)
	
	session.setMaxInactiveInterval(5); // 세션시간설정
	// 5초뒤에 새로고침하면 다시 세션이 생성됨
	// 5초 전에 새로고침하면 변화없음
	}
%>

		<!-- getAttribute : 이름을넣으면 등록된값을 보여줍니다.-->
<%= session.getAttribute("user") %>님, 환영합니다! <br> <!-- 오브젝트를 꺼낼수있고. -->
<%= session.getMaxInactiveInterval() %> 초동안 세션정보가 유지됩니다. <br> <!-- 시간을확인할수있다. -->

</body>
</html>