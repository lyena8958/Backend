<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model_menuVO.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>구매내역</h3>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Menu> menuName = (ArrayList<Menu>)application.getAttribute("menuName");
	ArrayList<Menu> basket = (ArrayList<Menu>)application.getAttribute("basket");
	ArrayList<Integer> orderCnt = new ArrayList<Integer>(); //메뉴개수

	boolean flag = false; //메뉴 선택여부
	
	for(Menu v: menuName){//사용자의 입력된 메뉴주문개수를 orderCnt객체에 저장
		orderCnt.add(Integer.parseInt((request.getParameter(v.getMenuName()))));
	}
	if(basket==null){//최초 주문시
		basket = new ArrayList<Menu>();
		application.setAttribute("basket", basket);
	}
	
	for(int i = 0; i < orderCnt.size(); i++){
		
		if(orderCnt.get(i) > 0){ //주문한 메뉴가 있다면
			flag = true;
			Menu menu = new Menu(menuName.get(i).getMenuName(), menuName.get(i).getPrice());
			System.out.println(menuName.get(i).getPrice()+"1");
			int price = menuName.get(i).getPrice() * orderCnt.get(i);
			//menu.setPrice(menuName.get(i).getPrice() * orderCnt.get(i));// 상품 가격 * 주문한 개수 
			menu.setPrice(price);// 상품 가격 * 주문한 개수
			basket.add(menu);
			System.out.println(menuName.get(i).getPrice()+"2");
			
		}
	}
	
	
	if(!flag){//주문내역이없다면
		out.println("<script>alert('주문내역이 없습니다.');history.go(-1);</script>");	
	}
	else if(flag){//주문내역이있다면
		session.setAttribute("orderCnt", orderCnt);
		out.println("<script>alert('정상적으로 추가되었습니다.')</script>");
		out.println("<script>history.go(-1)</script>");
	}

	
%>

</body>
</html>