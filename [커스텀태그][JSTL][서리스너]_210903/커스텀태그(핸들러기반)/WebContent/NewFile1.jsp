<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/test2.tld" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀태그-핸들러기반</title>
</head>
<body>

<!-- Attribute을 required "true"로 함에 따라 -> 태그를 부를 때 자동으로 속성들이 생성된다. -->
<mytag:msg bgcolor="pink" border="10">DataBean의 데이터목록</mytag:msg>

</body>
</html>