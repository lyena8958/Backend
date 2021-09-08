<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
   <main class="main" id="loginTop">
   <section class="py-xxl-10 pb-0" id="home">
<%
	if(session.getAttribute("signin")==null){
%>
	<div class="bg-holder bg-size" style="background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;">
      
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

<%		
	}
%>
</section>
</main>