<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 순수자바코드 -> 굳이 jsp로 할 필요는 없다
 request.setCharacterEncoding("UTF-8");    // request.getParameter("username") == 로그인정보
											 //만약에 username에 들어간 정보가없다면 null으로 나오게 해준다. == 오류안뜨고
	String username = request.getParameter("username");
				//저기 위에는 모두 통일시키자
				// input 네임을 갖다가 name속성에 username로 했기때문에 맞게써줘야함
				// 근데 객체명도 왜 같게하는지?
				// 유지보수 : 같은의미, 값은 값을 가지고 있다면 변수명을 일치시킨다!
				// 설계 -> 변수명 정의, 주석
				
				// 쇼핑몰 내 메인페이지에서 다른페이지 상세메뉴, 마이페이지등 이동을할 때마다
				// 새로 요청하는데, ==request를 새로생성
				// 데이터를 유지할 때에는 request, session, application을 활용하자
				
	// 유저네임이 공백으로 데이터가 넘어온다면 뒤로가기(history.go(-1))
	if(username.equals("")){
		out.println("<script>alert('이름을 입력하세요!'); history.go(-1);</script>");
		
	}
	// 유저네임이 입력되어 데이터가 넘어온다면 main페이지로 이동
	else{  // 로그인이되었으니 세션속성을 설정해준다.(로그인 유지형태)
		session.setAttribute("username", username);
		response.sendRedirect("main_1.jsp"); 
		// 어차피세션을 저장해주어 이동시켜줄것이기 때문에 sendRedirect통해 새로 페이지가 생성되도 무상관
	}
				
	System.out.println("도착한 데이터["+request.getParameter("username")+"]");//로깅기법

%>