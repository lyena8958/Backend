<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.product.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="product" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="productList" class="java.util.ArrayList" scope="request"/>

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
<script> 
	function basket(){
		console.log('확인');
		console.log(document.aaa.hello);
		document.aaa.hello.value="basketAdd";
		document.aaa.submit();
	}

</script>
  </head>


  <body>
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.jsp"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base">
     
     
     <!-- //////////////////////////////////////////////////////////////-->
     <!--/////////////////// 회원메뉴바 - 커스텀태그(파일기반)호출 ////////////////-->       
     <!--/////////////////////////////////////////////////////////////-->
     <product:product_mem/>
     <!--  -->
     
     <!--/////////////////////////////////////////////////////////////// -->
 	<!--//////////////////// 비회원메뉴바 - 커스텀태그(파일기반) 호출 //////////////-->
 	<!--/////////////////////////////////////////////////////////////// -->
 	<product:product_noMem/>
 	<!--  -->
 	
 	
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
 
 
 		<!-- ////////////////////////////////////////////////////////////////////// -->
 		<!-- 상품목록 forEach출력///////////////////////////////////////////////////// -->
 		<!-- ////////////////////////////////////////////////////////////////////// -->
 	  <c:forEach var="vo" items="${productList}">
 	  	    <!--  -->
            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
              <div class="card h-100 px-lg-5 card-span">
                <div class="card-body d-flex flex-column justify-content-around">
                  <div class="text-center pt-5">
                    <h5 class="my-4">${vo.pName}</h5>
                  </div>
                  <ul class="list-unstyled">
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span>${vo.price} 원</li>
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span>재고 ${vo.cnt } 개</li>
                  </ul>
                  <div class="text-center my-5">
                    <div class="d-grid">
                     <form action="control.jsp" method="post" name="form1">
                     <input type="hidden" name="action" value="basketAdd">
                     	 <!-- <input type="hidden" name="action" value="buy"> -->
	                      <input type="hidden" name="pnum" value="${vo.pnum }"> 
	                      <input type="number" value="1" name="buyCnt" required>
	                      <br><br>
	                      <button class="btn btn-danger hover-top btn-glow border-0" value="check" type="submit">장바구니 담기</button>
	                      <!-- <button class="btn btn-danger hover-top btn-glow border-0" name="oneProduct" value="check" type="submit">구매하기</button> -->
                      
                      <br><br>
                      	<!-- <input type="button" class="btn btn-danger hover-top btn-glow border-0" onClick="basket()" value="장바구니 담기"> --> <!-- onClick="basket()"  -->
                      </form>				
                      <!-- <a href="control.jsp?action=basketAdd&pnum=${vo.pnum }&buyCnt=${param.buyCnt}"><input type="button" class="btn btn-danger hover-top btn-glow border-0" value="장바구니 담기"></a> -->
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- // -->	
 	  
 	  </c:forEach>
 
      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="bg-1000">

        <div class="container">
          <div class="row">
            <div class="col-lg-6">
              <h2 class="fw-bold text-white">Get an update every week</h2>
              <p class="text-300">We ensure that your product is delivered in the safest possible<br />manner, at the correct location, at the right time.</p>
            </div>
            <div class="col-lg-6">
              <h5 class="text-primary mb-3">SUBSCRIBE TO NEWSLETTER </h5>
              <form class="row gx-2 gy-2 align-items-center">
                <div class="col">
                  <div class="input-group-icon">
                    <label class="visually-hidden" for="inputEmailCta">Address</label>
                    <input class="form-control input-box form-quriar-control text-light" id="inputEmailCta" type="email" placeholder="Enter your mail" />
                  </div>
                </div>
                <div class="d-grid gap-3 col-sm-auto">
                  <button class="btn btn-danger" type="submit">Subscribe</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->




      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="bg-900 pb-0 pt-5">

        <div class="container">
          <div class="row">
            <div class="col-12 col-sm-12 col-lg-6 mb-4 order-0 order-sm-0"><a class="text-decoration-none" href="#"><img src="assets/img/gallery/footer-logo.png" height="51" alt="" /></a>
              <p class="text-500 my-4">The most trusted Courier<br />company in your area.</p>
            </div>
            <div class="col-6 col-sm-4 col-lg-2 mb-3 order-2 order-sm-1">
              <h5 class="lh-lg fw-bold mb-4 text-light font-sans-serif">Other links </h5>
              <ul class="list-unstyled mb-md-4 mb-lg-0">
                <li class="lh-lg"><a class="text-500" href="#!">Blogs</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Movers website</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Traffic Update</a></li>
              </ul>
            </div>
            <div class="col-6 col-sm-4 col-lg-2 mb-3 order-3 order-sm-2">
              <h5 class="lh-lg fw-bold text-light mb-4 font-sans-serif">Services</h5>
              <ul class="list-unstyled mb-md-4 mb-lg-0">
                <li class="lh-lg"><a class="text-500" href="#!">Corporate goods</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Artworks</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Documents</a></li>
              </ul>
            </div>
            <div class="col-6 col-sm-4 col-lg-2 mb-3 order-3 order-sm-2">
              <h5 class="lh-lg fw-bold text-light mb-4 font-sans-serif"> Customer Care</h5>
              <ul class="list-unstyled mb-md-4 mb-lg-0">
                <li class="lh-lg"><a class="text-500" href="#!">About Us</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Contact US</a></li>
                <li class="lh-lg"><a class="text-500" href="#!">Get Update</a></li>
              </ul>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->




    

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