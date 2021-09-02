<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="b.jsp">
      <jsp:useBean id="dataBean" class="model.ProductBean" scope="session" />
      <select name="data">
         <%
            for(String v:dataBean.getProduct()){
               // out.println("<option>"+v+"</option>");
         %>
            <option><%=v%></option>
         <%   
            }
         %>
      </select>
      <input type="number" name="cnt" value="1">
      <input type="submit" value="결제">
   </form>

</body>
</html>