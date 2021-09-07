<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless" import="java.util.ArrayList, model.product.ProductVO"%>
<jsp:useBean id="basketList" class="java.util.ArrayList" scope="session"/>


    <form action="control.jsp" method="post" name="form1">  
    <input type="hidden" name="action" value="pay">
    <table> 
<%
	
	// 단일상품이라면
	if(request.getAttribute("userBuy")!=null){
		//데이터를 받아와주고 구매데이터 보여주기
%>		
		<jsp:useBean id="userBuy" class="model.product.ProductVO" scope="request"/>
		
		<input type="hidden" name="buyContent" value="one" >
		<input type="hidden" name="pnum" value="<%=userBuy.getPnum() %>" >
		<input type="hidden" name="buyCnt" value="<%=userBuy.getCnt() %>" >
                
                <td><h5 class="my-4"><%=userBuy.getpName() %></h5></td>
   
              <td class="mb-2">
                <%=userBuy.getPrice() %>원
               </td>
              
              <td>
              &nbsp;&nbsp;&nbsp;<p><%=userBuy.getCnt() %>개</p>
              </td>
              
  
                <div class="d-grid">
                <td>
                  <br><br>
                  <h5 class="my-4">총 <%=userBuy.getCnt() * userBuy.getPrice() %> 원</h5>
                 </td>
                 
                
<%
	}
	else{
		int totalPrice = 0;
		for(ProductVO vo :(ArrayList<ProductVO>) basketList){
	%>		
			<input type="hidden" name="buyContent" value="lists" >
			<tr>
	            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
	              <div class="card h-100 px-lg-5 card-span">
	                <div class="card-body d-flex flex-column justify-content-around">
	                  <div class="text-center pt-5">
	                    
	                    <td><h5 class="my-4"><%=vo.getpName() %></h5></td>
	                  </div>
	                  <td class="mb-2">
	                   	<%=vo.getPrice() %>
	                   </td>
	                  
	                  <td>
	                  <p><%=vo.getCnt() %></p>
	                  </td>
	                  
	                  <div class="text-center my-5">
	                    <div class="d-grid">
	                    <td>
	                      <br><br>
	                      <h5 class="my-4"><%=vo.getCnt()*vo.getPrice() %> 원</h5>
	                     </td>
	                  
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <!-- // -->
		</tr>
<%
			totalPrice += vo.getCnt()*vo.getPrice();
		}
%>
		<h4>총 결제금액  : <%=  totalPrice %> 원</h4>
		
<%
		
	}
%>

</table>
<jsp:doBody/>
</form>
