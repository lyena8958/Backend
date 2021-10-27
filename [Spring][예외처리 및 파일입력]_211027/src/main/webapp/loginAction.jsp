<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.*"%>
<%

// login.jsp 
// 아이디 값
// 비밀번호 값

// vo에 해당 값들을 set

// dao로 getMember() 수행

String id = request.getParameter("id");
String password = request.getParameter("password");

MemberVO vo = new MemberVO();
vo.setId(id);
vo.setPassword(password);

MemberDAO dao = new MemberDAO();
MemberVO data = dao.getMember(vo);

/*
jdbcTemplate가 스프링 컨테이너 격인 서버와 충돌되어 실행이 안되고 있는 상황
--> 이에 대한 설정은 이수자 평가 이후 진행할 예정
*/

// 로그인 성공	
if(data!=null){
	session.setAttribute("userData", data);
	response.sendRedirect("main.jsp");
	
}
// 로그인 실패
else{
	response.sendRedirect("index.jsp");
}

%>
