<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model_menuVO.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
<style>
header, h2, div, input {
	margin: 0;
	padding: 0;
	align: center;
}

header {
	margin: 10%;
}

#menu {
	margin-left: 10%;
	margin-right: 10%;
}

.menuTitle {
	color: red;
	margin-bottom: 5px;
}
a{
	display : block;
	margin: 10%;
	color : black;
	font-weight : bold;
}
</style>
</head>
<body>

	<%
		String userId = (String)session.getAttribute("userId");
		ArrayList<Menu> menuName = (ArrayList<Menu>)application.getAttribute("menuName");		
		
		if(menuName==null){ // 애플리케이션에 저장된 정보가 없다면
			menuName = new ArrayList<Menu>();
			
			//객체생성
			Menu menu;

			//객체화 및 AL데이터 삽입
			menuName.add(menu = new Menu("마라탕", 15000));
			menuName.add(menu = new Menu("마라샹궈", 23000));
			
			menuName.add(menu = new Menu("꿔바로우", 15000));
			menuName.add(menu = new Menu("꽃빵튀김", 12000));
			menuName.add(menu = new Menu("계란볶음밥", 10000));
			
			application.setAttribute("menuName", menuName);
		}
	%>
	<form action="add.jsp" method="post">
		<header>
			<h2><%=userId %>님, 어서오세요!! 탕화쿵푸마라탕 YA점 입니다.
			</h2>
			<h3>주문은 아래에서 입력해주세요.</h3>
		</header>

		<div id="menu">
			<h4 class="menuTitle">메뉴</h4>
			<%
				for(Menu v: menuName){
					out.println(v.getMenuName()+" "+v.getPrice()+"won");
					out.println("<input type=number value='0' name="+v.getMenuName()+" min='0' max='10'> <br> ");
				}
			%>

			<hr>
			<input type="submit" value="장바구니담기">
		</div>
	</form>
	<a href="buy.jsp">구매하러 가기!!</a>

</body>
</html>