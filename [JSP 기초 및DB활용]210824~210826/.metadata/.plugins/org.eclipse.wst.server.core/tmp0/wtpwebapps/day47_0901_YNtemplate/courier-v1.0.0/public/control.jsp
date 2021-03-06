<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.Ordermember.*, model.review.*"
	errorPage="errorPage.jsp"%>
	
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="ordermemberDAO" class="model.Ordermember.OrderMemberDAO" />
<jsp:useBean id="reviewDAO" class="model.review.ReviewDAO"/>

<jsp:useBean id="ordermemberVO" class="model.Ordermember.OrderMemberVO" scope="session"/>
<jsp:setProperty property="*" name="ordermemberVO" />

<jsp:useBean id="reviewVO" class="model.review.ReviewVO"/>
<jsp:setProperty property="*" name="reviewVO"/>

<%     
	String action = request.getParameter("action");

	// 리뷰 메인페이지 이동(list)
	if(action.equals("list")){
		// 전체 리뷰
		// 리뷰 목록을 주기위해 datas 파라미터 전송~
		ArrayList<ReviewVO> datas = reviewDAO.RVSelectAll();
		request.setAttribute("datas", datas); 	
		pageContext.forward("lists_review.jsp");
	}
	// 회원가입 데이터 생성
	if(action.equals("signup")){
		session.invalidate();
		boolean signup = ordermemberDAO.memInsert(ordermemberVO);
		request.setAttribute("signup", signup);
		pageContext.forward("signupApply.jsp");	
		
	}
	//login.jsp에서 받아옴
	// 로그인이 완료되면 선택된 모드에 따라 페이지 이동 
	if(action.equals("loginCheck")){// 로그인 성공
		if(ordermemberDAO.loginCheck(ordermemberVO)){
			// 소비자or점주 사용자가 선택한 모드를 가져옴
	 		String mod = request.getParameter("mod");

	 			// 사용자 계정 저장 - (세션단위)
				// userID로 모든 속성의 데이터를 받아옴
				ordermemberVO = ordermemberDAO.memSelectOne(ordermemberVO);	 			
				session.setAttribute("ordermemberVO", ordermemberVO);//set->set..?

	 			if(mod.equals("소비자")){	 				
	 				// 메인 페이지 이동
	 				response.sendRedirect("control.jsp?action=list");	
	 			}
	 			else if(mod.equals("점주")){
	 				pageContext.forward("admin.jsp");
	 			}
	 		
		}
		// 로그인 실패
		else{
 		out.println("<script>alert('로그인에 실패하였습니다.'); history.go(-1); </script>");
 		}
	}
	
	// 로그아웃
	if(action.equals("logout")){
		session.invalidate();
		response.setContentType("UTF-8");
		pageContext.forward("index.jsp");
	}
	
	// lists_review -> 리뷰작성 클릭 -> insert_review.jsp에서 작성 -> 파리미터값이 옴
	if(action.equals("insert")){
		if(reviewDAO.RVInsert(reviewVO)){
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect("control.jsp?action=list");	
		}
		else{
			System.out.println("DB 게시판 insert");
			throw new Exception("DB 게시판 insert 오류 발생!"); 
		}
	}
	
	// lists_review -> 내 리뷰보기 클릭하면
	if(action.equals("userreview")){
		// 사용자 리뷰
		ReviewVO vo = new ReviewVO();
		System.out.println("★"+vo);
		vo.setOnum(ordermemberVO.getOnum());
		
		// onum으로 고객의 글정보를 모두 불러옴
		ArrayList<ReviewVO> userReviews = reviewDAO.RVUserDatas(vo);
		request.setAttribute("userReviews", userReviews);
		
		pageContext.forward("user_view.jsp");
	}
	
	// user_review -> 내게시물에 타이틀을 클릭하면
	if(action.equals("editreview")){
		ReviewVO data = new ReviewVO();
		data.setRnum(Integer.parseInt(request.getParameter("rnum")));
		System.out.println(data);
		// vo재활용하여 해당 게시물의 정보가져오기 
		data = reviewDAO.RVSelectOne(data);
		request.setAttribute("data", data);
		
		pageContext.forward("edit_review.jsp");
	}
	
	if(action.equals("update")){
		//System.out.println("update 방문하셨당");
		// 정상반영 : true
		if(reviewDAO.RVUpdate(reviewVO)){
			System.out.println("update완료");
			out.println("<script>alert('정상적으로 수정이 완료되었습니다.');");
			
			response.sendRedirect("control.jsp?action=list");			
		}
		//미반영 : false
		else{
			System.out.println("update실패");
			throw new Exception("DB update 오류 발생!"); 
		}
	}
	
	if(action.equals("delete")){
		System.out.println(reviewVO);
		if(reviewDAO.RVDelete(reviewVO)){			
			pageContext.forward("deleteApply.jsp");	
		}
		else{
			throw new Exception("DB 삭제 오류 발생!"); 
		}
		
		
	}
	//검색기능
	if(action.equals("search")){
		//검색 내용을 가져옴
		String search =	request.getParameter("search");
		request.setAttribute("search", search);
		System.out.println("search"+" "+search);
		
		// dao를 활용하여 검색기록을 list로 받음
		ArrayList<ReviewVO> searchDatas = reviewDAO.RVSearch(search);
		request.setAttribute("searchDatas", searchDatas); // request로 속성설정
		
		pageContext.forward("search_List.jsp");
		
	}


%>