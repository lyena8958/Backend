<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
</head>
<body>
<!-- EL실습 -->
<jsp:useBean id="productBean" class="model.ProductBean" scope="session"/>
<%
	for(int i = 0; i < productBean.getProduct().length; i++){
		productBean.totalPrice(productBean.getIndexProduct(i),(Integer.parseInt(request.getParameter("cnt"+i))));
		
	}
%>
${productBean.product[0]} : ${param.cnt0 }개 = ${param.cnt0 * productBean.getIndexPrice(0)}
<hr>
${productBean.product[1]} : ${param.cnt1 }개 = ${param.cnt1 * productBean.getIndexPrice(1)}
<hr>
${productBean.product[2]} : ${param.cnt2 }개 = ${param.cnt2 * productBean.getIndexPrice(2)}
<hr>
${productBean.product[3]} : ${param.cnt3 }개 = ${param.cnt3 * productBean.getIndexPrice(3)}

<h3>총 결제 금액은 <%= productBean.getTotal() %>원 입니다. </h3> 


</body>
</html>