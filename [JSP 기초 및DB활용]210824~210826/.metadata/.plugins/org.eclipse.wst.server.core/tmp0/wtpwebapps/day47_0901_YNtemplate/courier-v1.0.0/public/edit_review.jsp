<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.review.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="data" class="model.review.ReviewVO" scope="request"/>

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

	<script type="text/javascript">
		function del(){
			result = confirm("정말로 삭제하시겠습니까?"); //alert(알림창), confirm(선택창) 
			if(result==true){
				document.form1.action.value="delete"; 
				document.form1.submit();
			}
			else{//아무일도 일어나지않음
				return;
			}
			
		}
	
	</script>
  </head>


  <body>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="index.html"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
            <a class="btn btn-primary order-1 order-lg-0 ms-lg-3" href="control.jsp?action=list">메인화면</a>
            <form class="d-flex my-3 d-block d-lg-none">
              <input class="form-control me-2 border-200 bg-light" type="search" placeholder="Search" aria-label="Search" />
              <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
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


	<form action="control.jsp" method="post" name="form1">
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="rnum" value="<%= data.getRnum() %>">
		<section class="py-7" id="services" container-xl="container-xl">
        <div class="container">

          <div class="row h-100 justify-content-center">
            <!--  -->
            <div class="col-md-4 pt-4 px-md-2 px-lg-3">
              <div class="card h-100 px-lg-5 card-span">
                <div class="card-body d-flex flex-column justify-content-around">
                	<br><br><br>
                   <input type="text" maxlength="30" name="title" value="<%=data.getTitle() %>">
                   <br>
                  <input type="text" maxlength="10" name="writer" value="<%=data.getWriter() %>">
                  <br>
                    <span class="me-2"><i class="fas fa-circle text-primary" style="font-size:.5rem">
                    </i></span><%=data.getWdate() %></li>
                    <br><br>
                  <input type="text" maxlength="30" name="content" value="<%=data.getContent() %>"></p>
                  <div class="text-center my-5">
                    <div class="d-grid">
                      <input type="submit" value="수정" class="btn btn-danger hover-top btn-glow border-0">
                      <br>
                      <button class="btn btn-danger hover-top btn-glow border-0" onClick="del()">삭제</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- // -->
           </div>
           </div>
           </section>
   </form>

      



</html>