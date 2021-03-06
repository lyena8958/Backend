<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.Ordermember.*, model.review.*"%>
<%
	request.setCharacterEncoding("UTF-8");
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
		pageContext.forward("lists_review.jsp");
	}
	
	//login.jsp에서 받아옴
	// 로그인이 완료되면 선택된 모드에 따라 페이지 이동 
	if(action.equals("loginCheck")){// 로그인 성공
		if(ordermemberDAO.loginCheck(ordermemberVO)){
			
			// 소비자or점주 사용자가 선택한 모드를 가져옴
	 		String mod = request.getParameter("mod");
	 		
	 			
	 			ReviewVO revo = new ReviewVO();
	 			revo.setOnum(ordermemberVO.getOnum());
	 			
	 			
	 			if(mod.equals("소비자")){
	 				// 전체 리뷰
	 				// 리뷰 목록을 주기위해 datas 파라미터 전송~
	 				ArrayList<ReviewVO> datas = reviewDAO.RVSelectAll();
	 				request.setAttribute("datas", datas);
	 				for(ReviewVO v : datas){
	 					System.out.println(v);
	 				}
	 				
	 				// 사용자 계정 저장 - (세션단위)
	 				//모든정보를불러옴
	 				ordermemberVO = ordermemberDAO.memSelectOne(ordermemberVO);
	 				System.out.println(ordermemberVO);
	 				pageContext.forward("lists_review.jsp");
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
		
	}
	
	// lists_review -> 리뷰작성 클릭 -> insert_review.jsp에서 작성 -> 파리미터값이 옴
	if(action.equals("insert")){
		System.out.println(reviewVO);
		if(reviewDAO.RVInsert(reviewVO)){
			out.println("<script>alert('정상적 입력이 되었습니다.');");
			response.sendRedirect("control.jsp?action=list");	
		}
		else{
			out.println("insert오류발생");
			out.println("<a href=lists.review.jsp>처음으로 돌아가기</a>");
		}
	}
	
	// lists_review -> 내 리뷰보기 클릭하면
	if(action.equals("userreview")){
		// 사용자 리뷰
		ReviewVO vo = new ReviewVO();
		vo.setOnum(Integer.parseInt(request.getParameter("onum"))); //fk onum 셋팅 ordermemberVO.getOnum()
		vo = reviewDAO.RVSelectOne(vo); // 데이터 모두 받아오고 
		System.out.println(vo+"\n"+"userview");
		
		// onum으로 고객의 글정보를 모두 불러옴
		ArrayList<ReviewVO> userReviews = reviewDAO.RVUserDatas(vo);
		request.setAttribute("userReviews", userReviews);
		
		pageContext.forward("user_view.jsp");
	}
	
	// user_review -> 내게시물에 타이틀을 클릭하면
	if(action.equals("editreview")){
		ReviewVO data = new ReviewVO();
		data.setRnum(Integer.parseInt(request.getParameter("rnum")));
		
		// vo재활용하여 해당 게시물의 정보가져오기 
		data = reviewDAO.RVSelectOne(data);
		request.setAttribute("data", data);
		
		pageContext.forward("edit_review.jsp");
	}
	
	if(action.equals("update")){
		
		// 정상반영 : true
		if(reviewDAO.RVUpdate(reviewVO)){
			out.println("<script>alert('정상적으로 수정이 완료되었습니다.');");
			
			response.sendRedirect("control.jsp?action=list");			
		}
		//미반영 : false
		else{
			out.println("Update오류발생");
			out.println("<a href=lists.review.jsp>처음으로 돌아가기</a>");
		}
	}
	
	if(action.equals("delete")){
		if(reviewDAO.RVDelete(reviewVO)){
			out.println("<script>alert('정상적으로 삭제가 완료되었습니다.');");
			response.sendRedirect("control.jsp?action=list");
			
			pageContext.forward("lists_review.jsp");	
		}
		else{
			out.println("Delete오류발생");
			out.println("<a href=lists.review.jsp>처음으로 돌아가기</a>");
		}
		
		
	}


%>