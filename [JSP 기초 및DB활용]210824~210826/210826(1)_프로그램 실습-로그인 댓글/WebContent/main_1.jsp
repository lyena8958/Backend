<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 해당페이지는 NF_1을 통해 이동됨 -->
<!-- request 써도돼? yes jsp의 내장객체이기 때문 -->
<%-- request.setCharacterEncoding("UTF-8");    // request.getParameter("username") == 로그인정보
											 // 로그인정보를 사라지게하고싶지않아 setAttribute를 해준 것
											 //만약에 username에 들어간 정보가없다면 null으로 나오게 해준다. == 오류안뜨고
	session.setAttribute("username",request.getParameter("username"));
				//저기 위에는 모두 통일시키자
				// input 네임을 갖다가 name속성에 username로 했기때문에 맞게써줘야함
				// 근데 객체명도 왜 같게하는지?
				// 유지보수 : 같은의미, 값은 값을 가지고 있다면 변수명을 일치시킨다!
				// 설계 -> 변수명 정의, 주석
				
				// 쇼핑몰 내 메인페이지에서 다른페이지 상세메뉴, 마이페이지등 이동을할 때마다
				// 새로 요청하는데, ==request를 새로생성
				// 데이터를 유지할 때에는 request, session, application을 활용하자
				
				System.out.println("도착한 데이터["+request.getParameter("username")+"]");//로깅기법
				
/*
서블릿변환된 파일들이 각각 다르지않나욤?

서버측 데이터이기때문에 유지가 되는 것
세션에 대해서 우리가 정의하거나 할수가없음

*/
--%>

<%= session.getAttribute("username") %>님 환영합니다! <br>
<h2>=== 상품 목록 ===</h2>

<form action="addProduct_1.jsp" name="form1" method="post">
	<select name="product">
		<option>셔츠</option>
		<option>블라우스</option>
		<option selected>반팔티</option>
		<option>청바지</option>
		<option>운동화</option>
	</select>
	<input type="number" value="1" name="cnt"> <!-- 0이하의 유효성검사는 프론트가 함(백에서도할순있긴하다) -->
	<input type="submit" value="상품 추가하기">
</form>
<a href="buy_1.jsp">구매하기</a>
</body>
</html>