<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	//로그인한 이력이 있다면, 바로 메인페이지로 이동
 	if(session.getAttribute("ordermemberVO")!=null){
 		response.sendRedirect("lists_review.jsp");
 	}
 %>
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
    <main class="main" id="loginTop">
      <section class="py-xxl-10 pb-0" id="home">
        <div class="bg-holder bg-size" style="background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;">
        
      <!-- control.jsp로 actiom:loginChck 파라미터가 보내지며, -->
      <!-- 사용자 데이터는 userID, userPW, mod가 보내짐 -->
      
              <form class="row" name="form1" method="post" action="control.jsp">
              <input type="hidden" name="action" value="loginCheck">
                <div class="mb-3">
                  <label class="form-label visually-hidden" for="inputName">ID</label>
                  <input class="form-control form-quriar-control" id="userID" type="text" name="userID" placeholder="아이디를 입력하세요." required minlength="4" maxlength="10"/>
                </div>
                 <div class="mb-3">
                  <label class="form-label visually-hidden" for="inputName">PW</label>
                  <input class="form-control form-quriar-control" id="userPW" type="text" name="userPW" placeholder="비밀번호를 입력하세요." required minlength="4" maxlength="10"/>
                </div>
                <div class="mb-3">
                  <label class="form-label visually-hidden" for="inputName">고객선택</label>
                  <span class="memberSelect"><input type="radio" name="mod" value="소비자" checked/>소비자</span>
                  <span class="memberSelect"><input type="radio" name="mod" value="점주"/>점주</span>
                </div>
                <div class="d-grid">
                  <button class="btn btn-primary" type="submit">로그인 하기<i class="fas fa-paper-plane ms-2"></i></button>
                </div>
              </form>
              <div class="d-grid">
                  <a href="signUp.html"><button class="btn btn-primary signUpBtn" type="submit">회원가입 하기<i class="fas fa-paper-plane ms-2"></i></button></a>
                </div>
                 <!-- <div class="d-grid">
                  <a href="memberList.jsp"><button class="btn btn-primary signUpBtn" type="submit">가입내역 확인<i class="fas fa-paper-plane ms-2"></i></button></a>
                </div> -->
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