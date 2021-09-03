<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
   <main class="main" id="loginTop">
   <section class="py-xxl-10 pb-0" id="home">
<%
	if(session.getAttribute("signin")!=null){
%>
    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
 
      
        <div class="bg-holder bg-size" style="background-image:url(assets/img/gallery/hero-header-bg.png);background-position:top center;background-size:cover;">
        
      		<form action="control.jsp" method="post">
             <input type="hidden" name="action" value="logout">
                <div class="d-grid">
                  <button class="btn btn-primary" type="submit">로그아웃<i class="fas fa-paper-plane ms-2"></i></button>
                </div>
              
              </form>
		  </div>
		</section>
    </main>
<%		
	}
%>


