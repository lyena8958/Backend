<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
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





      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section id="findUs">

        <div class="container">
          <div class="row justify-content-center">
            <div class="col-md-8 col-lg-5 mb-6 text-center">
              <h2>Error :(</h2>
              <h6><%= exception %></h6>
              <br><br>
              <hr>
              <h5>URL을 잘못 입력하셨거나, 시스템 문제일 수도 있습니다.</h5>
              <h5>재접속시에도 같은 현상이 반복된다면, 아래 고객센터로 연락주세요.</h5>
              <h5>Mobile)010-3368-8958</h5>
            </div>
              <div class="text-center">
                <a class="text-light" href="control.jsp?action=list"><button class="btn btn-primary px-5"><i class="fas fa-phone-alt me-2"></i>처음으로 이동하기</button></a>
              </div>
            </div>
          </div>
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