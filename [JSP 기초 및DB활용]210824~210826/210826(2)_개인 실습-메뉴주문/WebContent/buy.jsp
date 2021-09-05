<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, model_menuVO.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
	font-size : 3em;
	color : red;
}
</style>

</head>
<body>
	<h3>구매내역</h3>
	<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Menu> menuName = (ArrayList<Menu>)application.getAttribute("menuName");
	ArrayList<Menu> basket = (ArrayList<Menu>)application.getAttribute("basket");
	ArrayList<Integer> orderCnt = (ArrayList<Integer>)application.getAttribute("orderCnt");

	
	if(basket==null){//최초 주문시 뒤로보내기
		out.println("<script>alert('주문내역이 없습니다.');history.go(-1);</script>");
	}
	
	int totalPrice = 0;
	for(Menu v: basket){
		out.println(v.getMenuName()+" "+v.getPrice()+"원"+"<br>");
		totalPrice += v.getPrice();
	}
	out.println("<hr>총 금액 : "+totalPrice+"원");
%>
<a href="apply.jsp">결제하시겠습니까??</a>
</body>
</html>