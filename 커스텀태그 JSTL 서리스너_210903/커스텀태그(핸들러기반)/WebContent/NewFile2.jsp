<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/test3.tld" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀태그-핸들러기반</title>
</head>
<body>
<!-- 태그바디에 메시지 넣고 
글자크기, 색 넣는 커스텀태그

-> 태그핸들러기반으로 재작업 -->

<mytag:body bgcolor="hotpink" fontSize="10em">&lt;( •̀ ω •́ )&gt;</mytag:body>


</body>
</html>