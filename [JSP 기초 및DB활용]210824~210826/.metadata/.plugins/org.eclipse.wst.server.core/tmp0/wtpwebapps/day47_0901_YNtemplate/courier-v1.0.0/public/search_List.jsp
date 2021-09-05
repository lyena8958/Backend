<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.review.ReviewVO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="searchDatas" class="java.util.ArrayList" scope="request"/>


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
        <div class="container"><a class="navbar-brand" href="index.html"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
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
              <h3 class="text-danger">고객 리뷰</h3>
            </div>
          </div>
	
<!--====================★ 리뷰작성 리스트 ==========================-->

<section class="py-7" id="services" container-xl="container-xl">
      <div class="container">

         <div class="row h-100 justify-content-center">
          <p><%= request.getAttribute("search") %></p>
          <br><br> 
            <hr>
<%	
	//검색내용이 없다면 (isEmpty :길이가0이면 true반환)
	if(searchDatas.isEmpty()||searchDatas==null){
%>
		<p>검색 내용이 존재하지 않습니다.</p>
<%
	}
	//검색내용이 있다면 기록을 보여줌
	else{
		for(ReviewVO vo : (ArrayList<ReviewVO>) searchDatas){
	
		
	
	%>
            <!--  -->
            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
              <div class="card h-100 px-lg-5 card-span">
                <div class="card-body d-flex flex-column justify-content-around">
                  <div class="text-center pt-5">
                    <h5 class="my-4"><%=vo.getTitle() %></h5>
                  </div>
                  <ul class="list-unstyled">
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span><%=vo.getWriter() %></li>
                    <li class="mb-2"><span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span><%=vo.getWdate() %></li>
                  </ul>
                  <p><%=vo.getContent() %></p>
                  <div class="text-center my-5">
                    <div class="d-grid">
                      <button class="btn btn-danger hover-top btn-glow border-0" type="submit">Learn more</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- // -->
<%

	}
}

%>    
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