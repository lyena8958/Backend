<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="day44_0827_testDB.MemberVO"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="memberDAO" class="day44_0827_testDB.MemberDAO" scope="application"/>

<jsp:useBean id="memberVO" class="day44_0827_testDB.MemberVO" />
<jsp:setProperty property="*" name="memberVO"/>

<%
	MemberVO signCheck = memberDAO.memSelectOne(memberVO);

	//selectOne의 where절 대상이 id이므로 → id가검색되지않아 null로 받았다면 
	//	 == 회원가입 가능
	if(signCheck==null){ 
		memberDAO.memInsert(memberVO); //고객정보 DB저장
		out.println("<script>alert('회원가입이 정상적으로 완료되었습니다.');  history.go(-2);</script>"); // 로그인페이지 이동
		
	}
	else{ // 아니라면 가입실패
		out.println("<script>alert('아이디가 중복된 데이터가 있어 가입을 실패하셨습니다.'); history.go(-1);</script>");
	}
%>
