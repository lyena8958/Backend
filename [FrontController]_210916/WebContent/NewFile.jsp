<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.sendRedirect("main.do"); %>
<!-- 원래 페이지가 없기때문에 404가 떠야하나. web.xml이 등록되어있기 때문에 Frontcotroller로 이동된다. -->

<!-- 

강사님 사용자의 do요청을 web.xml로 받거나, 혹은 어노테이션 하는 걸로 둘중 택일이 맞나용?
yes

 -->