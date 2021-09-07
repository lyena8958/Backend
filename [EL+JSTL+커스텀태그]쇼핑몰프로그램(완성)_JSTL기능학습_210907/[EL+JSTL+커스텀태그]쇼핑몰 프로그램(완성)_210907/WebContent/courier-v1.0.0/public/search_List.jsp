<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="search" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>



<!DOCTYPE html>
<html lang="en-US" dir="ltr">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
    <title>courier | Landing, Responsive &amp; Business Templatee</title>


    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicons/favicon.ico">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <meta name="msapplication-TileImage" content="assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">


    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="assets/css/theme.css" rel="stylesheet" />

  </head>


  <body>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.jsp"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
			<a class="btn btn-primary order-1 order-lg-0 ms-lg-3" href="control.jsp?action=list&onum=">
            	메인화면</a>
            <!-- <form class="d-flex my-3 d-block d-lg-none">
              <input class="form-control me-2 border-200 bg-light" type="search" placeholder="Search" aria-label="Search" />
              <button class="btn btn-outline-primary" type="submit">Search</button>
            </form> -->
          </div>
        </div>
      </nav>
      <section class="py-xxl-10 pb-0" id="home">
        <div class="bg-holder bg-size" style="background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;">
        </div>
        <!--/.bg-holder-->

      </section>


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      


          <div class="row justify-content-center">
            <div class="col-md-8 col-lg-5 text-center mb-3">
              <h3 class="text-danger">"${search}" 검색내용</h3>
            </div>
          </div>
		<hr>
<!--====================★ 리뷰작성 리스트 ==========================-->

<section class="py-7" id="services" container-xl="container-xl">
      <div class="container">

         <div class="row h-100 justify-content-center">

	<search:Search>
		<!-- foreach전달 -->
		<table  border="1">
			<tr>
				<th>상품명</th>
				<th>금액</th>
				<th>재고</th>
			</tr>
		<c:forEach var="vo" items="${searchDatas}">	
			
			<tr >
				<td>${ vo.pName} |</td>
				
				<td>${vo.price} 원 |</td>

				<td>재고 ${vo.cnt }개 |</td>
			</tr>
			
						<div class="text-center my-5">
                    <div class="d-grid">
                     <!--향후...구현....ㅇㅖ정..
                     <form action="control.jsp" method="post">
                     	 <input type="hidden" name="action" value="buy">
	                      <input type="hidden" name="pnum" value="${vo.pnum}">
	                      <input type="number" value="1" name="cnt" required>
	                       <button class="btn btn-danger hover-top btn-glow border-0" type="submit">구매하기</button>
                      </form> 
                      <br><br>
                      <a href="cotrol.jsp?action=basket"><button class="btn btn-danger hover-top btn-glow border-0">장바구니 담기</button></a>-->
                    </div> 
                  </div>
              <hr>
            <!-- <div class="col-md-4 pt-4 px-md-2 px-lg-3">
              <div class="card h-100 px-lg-5 card-span">
                <div class="card-body d-flex flex-column justify-content-around">
                  <div class="text-center pt-5">
                    <h5 class="my-4">${ vo.pName}</h5>
                  </div>
                  <ul class="list-unstyled">
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span>${vo.price} 원</li>
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span>재고 ${vo.cnt }개</li>
                  </ul>
                  <div class="text-center my-5">
                    <div class="d-grid">
                     <form action="control.jsp" method="post">
                     	 <input type="hidden" name="action" value="buy">
	                      <input type="hidden" name="pnum" value="${vo.pnum}">
	                      <input type="number" value="1" name="cnt" required>
	                      <button class="btn btn-danger hover-top btn-glow border-0" type="submit">구매하기</button>
                      </form>
                      <br><br>
                      <a href="cotrol.jsp?action=basket"><button class="btn btn-danger hover-top btn-glow border-0">장바구니 담기</button></a>
                    </div>
                  </div>
                </div>
              </div>
            </div> -->
            <!-- // -->
		
		</c:forEach>
		</table>
	<!-- // -->
	</search:Search>
 
		</div>
	  </div>
	</section>
</main>
    <!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="assets/js/theme.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@200;300;400;500;600;700;800&amp;display=swap" rel="stylesheet">
</body>
</html>