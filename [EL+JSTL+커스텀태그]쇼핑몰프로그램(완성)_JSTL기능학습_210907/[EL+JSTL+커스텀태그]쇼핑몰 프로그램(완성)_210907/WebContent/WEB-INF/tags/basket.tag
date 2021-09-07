<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" import="java.util.ArrayList, model.product.ProductVO"%>
<jsp:useBean id="basketList" class="java.util.ArrayList" scope="session"/>

<%
	int totalPrice = 0;
	if(basketList.isEmpty()){
	
%>
		<h4>해당 목록이 없습니다.</h4>
<%
	}
	else{
		int i = 0;
		for(ProductVO vo: (ArrayList<ProductVO>)basketList ){
	%>		
            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
            <div class="card h-100 px-lg-5 card-span">
              <div class="card-body d-flex flex-column justify-content-around">
                <div class="text-center pt-5">
                <a href="control.jsp?action=basketDelete&index=<%=i%>"><img id="BKdeleteBtn" src="assets/img/deleteBtn.png" /></a>
                  <h5 class="my-4"><%=vo.getpName() %></h5>
                </div>
                <!-- 삭제버튼 -->
                <ul class="list-unstyled">
                <!-- // -->
                  <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                  </i></span><%=vo.getPrice() %>원</li>
                </ul>
                <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                  </i></span><%=vo.getCnt() %>개</li>
                <div class="text-center my-5">
                <h5><%= vo.getCnt()*vo.getPrice() %>원</h5>
                </div>
              </div>
            </div>
          </div>
	<%		
			i++;
			totalPrice += vo.getCnt()*vo.getPrice();
		}
		%>
		<h3>총 <%= totalPrice %>원</h3>
		<form action="control.jsp">
			<input type="hidden" name="action" value="pay">
			<input type="hidden" name="buyContent" value="list">
			<button class="btn btn-danger hover-top btn-glow border-0" type="submit">결제하기</button>
		</form>
<%
	}

 %>
 
 		