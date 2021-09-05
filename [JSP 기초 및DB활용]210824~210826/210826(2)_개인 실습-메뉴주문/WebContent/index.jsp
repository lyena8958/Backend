<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인  창</title>
</head>
<body>
<!-- 로그인 index.jsp☆
   -없는입력방지
   -일반사용자 vs 관리자 분리
   user.jsp      admin.jsp
상품 구매 user.jsp
   상품 3개와 수량입력
   상품 3개에 대한 금액은 미리 정해놓을것
      => .jsp내부에서 % %사용
      (=> Java의 class단위로 미리 생성)
   수량 0이하 입력방지
   장바구니 추가 add.jsp
   결제 buy.jsp
결제 buy.jsp
   index.jsp로 이동할수있는 수단 만들어놓을것
   이때 세션정보 초기화
관리자 페이지 admin.jsp
   총 결제한 횟수를 보여줄 것

+) 가능하다면 템플릿도 사용해볼것!
어렵다면, 기본내용에 충실할것!!!
4시에 풀이!~~-->
 
<%	session.invalidate();
	if(application.getAttribute("cnt")==null){
		application.setAttribute("cnt", 0);
		
	}

%>
 
<script type="text/javascript">alert("🍖탕화쿵푸 L점에 오신 것을 환영합니다🍖")</script>
<form action="NewFile.jsp" method="post">
	<input type="text" placeholder="아이디 입력" name="userId">
	<input type="radio" name="mod" value="user">사용자
	<input type="radio" name="mod" value="admin">관리자
	<hr>
	<input type="submit" value="로그인">
	
</form>





</body>
</html>