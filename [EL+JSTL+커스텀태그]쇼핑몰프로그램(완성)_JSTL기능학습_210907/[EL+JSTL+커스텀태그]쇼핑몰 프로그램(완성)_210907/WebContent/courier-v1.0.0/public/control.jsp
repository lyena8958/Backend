<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.member.*, model.product.*"
	errorPage="errorPage.jsp"%>
	
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="productDAO" class="model.product.ProductDAO"/>
<jsp:useBean id="basketList" class="java.util.ArrayList" scope="session"/>

<jsp:useBean id="memberVO" class="model.member.MemberVO"/>
<jsp:useBean id="productVO" class="model.product.ProductVO"/>

<jsp:setProperty property="*" name="memberVO"/>
<jsp:setProperty property="*" name="productVO"/>

<%
	String action = request.getParameter("action");

	// [메인페이지 이동]
	if(action.equals("list")){
		// 전체 리뷰
		ArrayList<ProductVO> productList = productDAO.productList("");
		request.setAttribute("productList", productList); 	
		

		// 로그인session이 존재하고, 관리자 계정이라면 -> 관리 페이지 이동
		
		if(session.getAttribute("memberVO")!=null){
			System.out.println(session.getAttribute("memberVO") +" 점주");
			System.out.println(" 1"); 
			System.out.println(" 2");
			
			MemberVO data = (MemberVO)session.getAttribute("memberVO");
			if(data.getUserID().equals("admin")&& 
					data.getUserPW().equals("admin")){ 
				System.out.println("점주1");
				pageContext.forward("admin.jsp");
				System.out.println("점주3");
				return;
			}
		}
		//사용자는 기본페이지 이동
		pageContext.forward("lists_product.jsp");
	}
	
	// [로그인] 
	if(action.equals("login")){
		memberVO = memberDAO.MemData(memberVO);
		// 로그인 성공(null로 반환받지 않았다면)
		if(memberVO!=null){
			// 사용자 계정 저장(세션단위)			
			session.setAttribute("memberVO", memberVO);
			// 메인페이지로 이동
	 		response.sendRedirect("control.jsp?action=list");
		}
		// 로그인 실패
		else{
 			out.println("<script>alert('로그인에 실패하였습니다.'); history.go(-1); </script>");
 		}

	}
	
	// [로그아웃]
	if(action.equals("logout")){
		session.invalidate();
		response.setContentType("UTF-8");
		pageContext.forward("index.jsp");
	}
	
	// [검색기능]
	if(action.equals("search")){
		//검색 내용을 가져옴
		String search =	request.getParameter("search");
		request.setAttribute("search", search);
		
		// dao를 활용하여 검색기록을 list로 받음
		ArrayList<ProductVO> searchDatas = productDAO.productList(search);
		request.setAttribute("searchDatas", searchDatas); // request로 속성설정
		
		pageContext.forward("search_List.jsp");
		
	}
	
	// [마이페이지(수정,삭제)]
	if(action.equals("mypage")){
		//System.out.println("mypage "+session.getAttribute("memberVO"));
		pageContext.forward("myPage.jsp");
		
	}
	if(action.equals("basket")){
		if(session.getAttribute("memberVO")==null){
			out.println("<script>alert('회원 이용만 가능합니다.'); history.go(-1); </script>");
			return;
		}
		pageContext.forward("basket.jsp");
	}
	// [장바구니 추가]
	if(action.equals("basketAdd")){
		if(session.getAttribute("memberVO")==null){
			out.println("<script>alert('회원 이용만 가능합니다.'); history.go(-1); </script>");
			return;
		}
		System.out.println(basketList.size());
		// 버킷리스트 최종생성이라면
		if(basketList.size()==0){
			basketList = new ArrayList<ProductVO>();
			session.setAttribute("basketList", basketList);
		}
		int buyCnt = Integer.parseInt(request.getParameter("buyCnt"));
		
		//받은 pnum으로 set된 vo의 모든 데이터를 받아옴
		productVO = productDAO.productData(productVO);
		System.out.println(productVO.getCnt()+"비교1");
		System.out.println(buyCnt+"비교2");
		System.out.println(buyCnt > productVO.getCnt());
		// 데이터에 있는 재고량이 더 적다면 뒤로가기
		if(buyCnt > productVO.getCnt()){
			out.println("<script>alert('선택제품의 재고수량이 부족하여 주문이 불가합니다.'); history.go(-1);</script>");
			return;
		}
		productVO.setCnt(buyCnt);
		
		//System.out.println("★"+productVO);
		// 상단에 뒤로가기가 안되었다면 물품담기
		basketList.add(productVO);
		out.println("<script>alert('정상적으로 바구니에 담았습니다!'); history.go(-1);</script>");

	}
	// [장바구니 단일삭제]
	if(action.equals("basketDelete")){
		int index = Integer.parseInt(request.getParameter("index"));
		System.out.println(index);
		basketList.remove(index);
		response.sendRedirect("control.jsp?action=list");
	}
	// [구매하기]
	if(action.equals("buy")){
		if(session.getAttribute("memberVO")==null){
			out.println("<script>alert('회원 이용만 가능합니다.'); history.go(-1); </script>");
			return;
		}
		int buyCnt = Integer.parseInt(request.getParameter("buyCnt"));
		
		productVO = productDAO.productData(productVO);

		// 주문수량 보다 >데이터에 있는 재고가 더적다면
		if(buyCnt > productVO.getCnt()){
			out.println("<script>alert('선택제품의 재고수량이 부족하여 주문이 불가합니다.'); history.go(-1); </script>");
			return;
		}
		
		// 단일구매		// 다중구매는 basketadd에서 따로 add처리됨
		if(request.getParameter("oneProduct")!=null){ 
		
		//구매 정보 parameter 받아와서
		int pnum = Integer.parseInt(request.getParameter("pnum"));			
	
		// productVO에 저장
		ProductVO userBuy = new ProductVO();
		userBuy.setPnum(pnum);
		userBuy = productDAO.productData(userBuy); // 데이터를 모두 받아옴
		userBuy.setCnt(buyCnt);
		
		request.setAttribute("userBuy", userBuy);
	
		}
		else{		
		// 재고수량 체크
		for(ProductVO vo : (ArrayList<ProductVO>)basketList){
			ProductVO data = new ProductVO();
			data.setPnum(vo.getPnum());
	
			data = productDAO.productData(data); // DB에 해당 제품 데이터 받아옴
		

			}
		}
		pageContext.forward("buy.jsp");
	}
	
	// [결제하기]
	if (action.equals("pay")) {
		
		// 단일구매
		if (request.getParameter("buyContent").equals("one")) {
			
			//pnum이 set된 VO로 데이터를 모두 받고,
			productVO = productDAO.productData(productVO);
		
			// 재고 차감
			productVO.setCnt(productVO.getCnt()-Integer.parseInt(request.getParameter("buyCnt")));
			
			System.out.println("pay" + productVO);
			boolean payApply = productDAO.productUpdate(productVO);

			
			// 재고업데이트 == 구매완료
			if (payApply) {
				request.setAttribute("payApply", payApply);
				session.removeAttribute("basketList"); // 구매한 장바구니의 데이터 삭제
				pageContext.forward("buyApply.jsp");
			} else {//구매실패
				System.out.println("update실패");
				throw new Exception("제품 구매에 이상이 발견되었습니다!");
			}
	 		
		} 
		// 다중구매
		else {
				System.out.println(basketList+" ★");
			for (ProductVO vo : (ArrayList<ProductVO>) basketList) {
				ProductVO data = new ProductVO();
				data.setPnum(vo.getPnum());
				data = productDAO.productData(data);
				// 결제한 재고수 차감 
				
				data.setCnt(data.getCnt() - vo.getCnt());

				boolean payApply = productDAO.productUpdate(data);

				// 재고업데이트 == 구매완료
				if (payApply) {
					request.setAttribute("payApply", payApply);
					session.removeAttribute("basketList"); // 구매한 장바구니의 데이터 삭제
					pageContext.forward("buyApply.jsp");
				} else {//구매실패
					System.out.println("update실패");
					throw new Exception("제품 구매에 이상이 발견되었습니다!");
				}

			}
		}

	}
	// [회원가입]
	if (action.equals("signup")) {
		boolean signup = memberDAO.signUp(memberVO);
		request.setAttribute("signup", signup);
		pageContext.forward("signupApply.jsp");

	}

	// [회원정보 수정]
	if (action.equals("myPageUpdate")) {
		if (memberDAO.MemUpdate(memberVO)) {
			System.out.println("update완료");
			out.println("<script>alert('정상적으로 수정이 완료되었습니다.');");

			response.sendRedirect("control.jsp?action=list");
		}
		//미반영 : false
		else {
			System.out.println("update실패");
			throw new Exception("DB update 오류 발생!");
		}
	}
	// [회원탈퇴]
	if (action.equals("myPageDelete")) {
		if (memberDAO.MemDelete(memberVO)) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	
	
//////////////////////////관리자//////////////////////////////////////////////
	// 관리자 - 상품 추가
	if(action.equals("ADInsert")){
		if(productDAO.productInsert(productVO)){
			//다시 본페이지로 이동
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("관리자 상품추가 오류 발생!");
		}
	}
	// 관리자 - 상품 삭제
	if(action.equals("ADDelete")){
		//System.out.println("ad확인 "+request.getParameter("pnum"));
		ProductVO data = new ProductVO();
		data.setPnum(Integer.parseInt(request.getParameter("pnum")));
		if(productDAO.productDelete(data)){
			//다시 본페이지로 이동
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("관리자 상품삭제 오류 발생!");
		}
	}
	// 관리자 - 상품 변경
	if(action.equals("ADUpdate")){
		if(productDAO.productUpdate(productVO)){
			//다시 본페이지로 이동
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("관리자 상품변경 오류 발생!");
		}
	}
	
	
%>
