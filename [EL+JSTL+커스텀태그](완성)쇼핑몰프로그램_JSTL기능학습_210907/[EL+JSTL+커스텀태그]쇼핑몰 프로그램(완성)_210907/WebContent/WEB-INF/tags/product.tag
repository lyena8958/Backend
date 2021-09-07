<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" import="java.util.ArrayList, model.product.*"%>

<jsp:useBean id="productList" class="java.util.ArrayList" scope="request"/>


<script> 
	function basket(){
		console.log(document.form1.action);
		document.form1.action.value="basketAdd"; 
		document.form1.submit();
	} 
</script>

    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.html"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base">
            
<%  // 태그 1
	if(session.getAttribute("memberVO") == null){ // 비회원
%>		
		<!-- 비회원  : 로그인, 검색기능 -->
              <li class="nav-item px-2"><a class="nav-link" aria-current="page" href="login.jsp">
              	로그인</a></li>
            </ul>
            <div class="dropdown d-none d-lg-block">
              <button class="btn bg-soft-warning ms-2" id="dropdownMenuButton1" type="submit" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-search text-warning"></i></button>
              <div class="dropdown-menu dropdown-menu-lg-end p-0 rounded" aria-labelledby="dropdownMenuButton1" style="top:55px">
                <form action="control.jsp" method="post">
                  <input type="hidden" name="action" value="search">
                  <input class="form-control border-200" name="search" type="search" placeholder="Search" aria-label="Search" style="background:#FDF1DF;" />
                </form>
              </div>
            </div>	
<%
}	// 태그2
	else{// 회원
%>
		<!-- 회원 : 로그아웃, 검색, 마이페이지, 장바구니 -->
              <li class="nav-item px-2"><a class="nav-link" aria-current="page" href="control.jsp?action=logout">
              	로그아웃</a></li>
            </ul>
            <div class="dropdown d-none d-lg-block">
              <button class="btn bg-soft-warning ms-2" id="dropdownMenuButton1" type="submit" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-search text-warning"></i></button>
              <div class="dropdown-menu dropdown-menu-lg-end p-0 rounded" aria-labelledby="dropdownMenuButton1" style="top:55px">
                <form action="control.jsp" method="post">
                  <input type="hidden" name="action" value="search">
                  <input class="form-control border-200" name="search" type="search" placeholder="Search" aria-label="Search" style="background:#FDF1DF;" />
                </form>
              </div>
            </div><a class="btn btn-primary order-1 order-lg-0 ms-lg-3" href="control.jsp?action=mypage">
            	마이페이지</a>
            <a class="btn btn-primary order-1 order-lg-0 ms-lg-3" href="control.jsp?action=basket">
            	장바구니</a>

<%
	} 
%>
		
        </div>
        </div>
      </nav>
      <section class="py-xxl-10 pb-0" id="home">
        <div class="bg-holder bg-size" style="background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;">
        </div>

      </section>
      <!-- ============================================-->
      <!-- <section> begin ============================-->
      


          <div class="row justify-content-center">
            <div class="col-md-8 col-lg-5 text-center mb-3">
              <h3 class="text-danger">상품 목록</h3>
            </div>
          </div>
          
<%	for(ProductVO vo : (ArrayList<ProductVO>) productList){
	
	%>
            <!--  -->
            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
              <div class="card h-100 px-lg-5 card-span">
                <div class="card-body d-flex flex-column justify-content-around">
                  <div class="text-center pt-5">
                    <h5 class="my-4"><%=vo.getpName() %></h5>
                  </div>
                  <ul class="list-unstyled">
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span><%= vo.getPrice() %> 원</li>
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span>재고 <%=vo.getCnt() %>개</li>
                  </ul>
                  <div class="text-center my-5">
                    <div class="d-grid">
                     <form action="control.jsp" method="post" name="form1">
                     	 <input type="hidden" name="action" value="buy">
	                      <input type="hidden" name="pnum" value="<%= vo.getPnum()%>">
	                      <input type="number" value="1" name="buyCnt" required>
	                      <br><br>
	                      <button class="btn btn-danger hover-top btn-glow border-0" name="oneProduct" value="check" type="submit">구매하기</button>
                      
                      <br><br>
                      	<input type="button" class="btn btn-danger hover-top btn-glow border-0" onClick="basket()" value="장바구니 담기">
                      </form>				
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- // -->
<%

	}

%>   


