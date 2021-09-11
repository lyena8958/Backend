<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 표지페이지 -->
<!-- 앞으로 view를 보기위해서는 controller를 거쳐야 볼 수가 있다. -->
<!-- 시작뷰 -- index → controller 메인뷰를 보도록 작업을해줌 -->
<%
// index.jsp에서는 컨트롤러 페이지에게  
// list.jsp를 보여달라고 요청해야 함
//   └> action = list

//"control.jsp?action=list" == 딕셔너리 : key=value == name=value 
// 예를들어 form태그에서 name을 action으로 중복으로 입력할 경우,
// 모호성이 발생되어서 중복입력이 불가하다.
pageContext.forward("control.jsp?action=list"); // 액션태그의 forward 로 사용안한 이유는 --> pageContext의 성능이 더좋고, 효율적임을 위해서 (spring에서도 사용함)
// view: 컨트롤러 - list값을 전달했으니 보여지게 해줘

//pageContext jsp 내장객체 >  JSP 페이지에 대한 정보(데이터)를 저장한다. > 페이지의 흐름을제어, 앱과 비슷한 단위
				

				

%>
