<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="productBean" class="model.ProductBean" scope="session"/>

<%@attribute name="border" %>
<%@attribute name="bgcolor" %>
<table border="${border}" bgcolor="${bgcolor}">
	
	<%
							// 물건의 총 length 만큼 반복
		for(int i = 0; i < productBean.getProduct().length; i++){
			System.out.println(productBean.getProduct().length);
	%>
		<tr>
		<td><%=productBean.getIndexProduct(i) %></td>
		<td><%=productBean.getIndexPrice(i)%></td>
		<td><%=request.getParameter("price"+i) %></td>
		
		</tr>	
	<%	
		productBean.totalPrice(productBean.getIndexProduct(i) , Integer.parseInt(request.getParameter("price"+i)));
		}
	%>
	
	결제하실 금액은 총 <%=productBean.getTotal() %>원 입니다!
</table>
