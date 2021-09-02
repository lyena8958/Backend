<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<!-- 바디사용xx == empty -->
<jsp:useBean id="productBean" class="model.ProductBean" scope="session"/>

<%@attribute name="border" %>
<!-- $param.border으로 안쓰는 이유는 (param==request)인데,  -->
<!-- param,request는 이전페이지에서 가져온 값을 의미한 것이며 -->

<!-- attribute는 같은  페이지에서 사용하기 때문에 
	 다른 표현법으로 입력했다고 생각하면 될 듯 -->
<form action="YN1_D.jsp" method="post">
<table border="${border}">
	
	<%
							// 물건의 총 length 만큼 반복
		for(int i = 0; i < productBean.getProduct().length; i++){
			System.out.println(productBean.getProduct().length);
			System.out.println(i);
	%>
		<tr> <!-- 아래 표현식에서 사용한 get이 EL에서 사용시엔 
		         오류더라도 기본설정이 0이라서 0을받아옴 (즉, 에어팟 10000만뜬다.)-->
		<td><%=productBean.getIndexProduct(i)%></td>
		<td><%=productBean.getIndexPrice(i)%></td>
		<td><input type="number" name="price<%=i%>" value="0"></td>
		</tr>	
	<%	
		}
	%>
</table>
	<input type="submit" value="구매하기">
</form>


