<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<%
//회원 메뉴바
if(session.getAttribute("memberVO") != null){ 
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

