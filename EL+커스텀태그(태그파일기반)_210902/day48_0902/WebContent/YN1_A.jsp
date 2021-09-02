<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productBean" class="model.ProductBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- EL실습 -->
</head>
<body>
<!-- >>실습<< 
빈즈컴포넌트에,
 물건의 이름과
 물건의 가격을 저장


A.jsp 어떤 물건을 / 몇개 구매할지 결정
B.jsp 어떤 물건을 N개 구매하여, 총___원 입니다. -->
<form action="YN1_B.jsp">
	<% 						// product 배열의 길이만큼 반복문 수행
		for(int i = 0; i < productBean.getProduct().length; i++){		
		%>
			<span name="data<%=i%>"><%=productBean.getIndexProduct(i) %></span>
			<span><%=productBean.getIndexPrice(i) %>원</span>
			<input name="cnt<%=i %>" type="number" value="0" >
			<br>
	<%
	 	}
	%>

	<input type="submit" value="구매하기">
</form>


</body>
</html>