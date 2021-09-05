<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="container"><a class="navbar-brand" href="index.html"><img src="assets/img/gallery/logo.png" height="45" alt="logo" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base">
              <li class="nav-item px-2"><a class="nav-link" aria-current="page" href="index.html">Home</a></li>
              <li class="nav-item px-2"><a class="nav-link" href="#services">Our Services</a></li>
              <li class="nav-item px-2"><a class="nav-link" href="#findUs">Find Us</a></li>
            </ul>
            <div class="dropdown d-none d-lg-block">
              <button class="btn bg-soft-warning ms-2" id="dropdownMenuButton1" type="submit" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-search text-warning"></i></button>
              <div class="dropdown-menu dropdown-menu-lg-end p-0 rounded" aria-labelledby="dropdownMenuButton1" style="top:55px">
                <form>
                  <input class="form-control border-200" type="search" placeholder="Search" aria-label="Search" style="background:#FDF1DF;" />
                </form>
              </div>
            </div><a class="btn btn-primary order-1 order-lg-0 ms-lg-3" href="#!">Contact Us</a>
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



      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section id="findUs">

			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-8 col-lg-5 mb-6 text-center">
						<% boolean signup = (boolean)request.getAttribute("signup"); 
						System.out.println(signup);
            	if(signup){
            %>
						<h2 class="text-danger">고객님!</h2>
						<h2>회원가입이 완료되었습니다. :D</h2>
					</div>
					<div class="col-12">
						<div class="card card-span rounded-2 mb-3">
							<div class="row"></div>
						</div>
					</div>
					<div class="text-center">
						<a class="text-light" href="login.jsp"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>로그인 이동
							</button></a>
						<br><br><br>
						<a class="text-light" href="index.html"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>처음으로
						</button></a>
					</div>
				</div>
			</div>
			<%
				}

				else {
			%>
						<h2 class="text-danger">고객님!</h2>
						<h2>중복된 아이디가 있어 가입 진행이 불가합니다.</h2>
					</div>
					<div class="col-12">
						<div class="card card-span rounded-2 mb-3">
							<div class="row"></div>
						</div>
					</div>
					<div class="text-center">
						<a class="text-light" href="signUp.html"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>회원가입 이동
							</button></a>
						<br><br><br>
						<a class="text-light" href="index.html"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>처음으로
						</button></a>
					</div>
				</div>
			</div>
			
			<%
				}
			%>

</section>

       

      </section>

      <section class="py-0 bg-1000">

       

      </section>

    </main>
    <!-- ===============================================-->
    <!--    End of Main Content-->
    <!-- ===============================================-->




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