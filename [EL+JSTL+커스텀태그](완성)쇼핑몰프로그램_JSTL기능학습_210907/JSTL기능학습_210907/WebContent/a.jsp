<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form method="post" action="test2.jsp">
      <jsp:useBean id="dataBean" class="model.DataBean" scope="session" />
      <select name="data">
         <c:forEach var="v" items="${dataBean.dataList}">
            <option>${v}</option>
         </c:forEach>
      </select>
      <input type="submit" value="다음 페이지로!">
   </form>
   
</body>
</html>