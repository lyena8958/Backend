<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="JDBC" class="day44_0827_testDB.JDBC"/>
<%
	/*String jdbc_driver ="oracle.jdbc.driver.OracleDriver";
	String jdbc_url ="jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn=null;
	PreparedStatement pstmt = null;*/
	
	Connection conn = JDBC.getConnection();
	
	PreparedStatement pstmt = null;

	try{
		//Class.forName(jdbc_driver);	
		//conn = DriverManager.getConnection(jdbc_url,"kim","8958");
		String sql = "insert into a values(?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, request.getParameter("a"));
		pstmt.setInt(2, Integer.parseInt(request.getParameter("b")));
		// a,b에 값이 없을 때 문제가 생긴다. == 공간이낭비 == 조건문처리로 막아주어야함
		if(request.getParameter("a")!=null){
			pstmt.executeUpdate();	
		}
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jsp > DB -->
</head>
<body>
<%--
드라이버 연동
 드라이버 연결 
 db연동 
 db연결해제
 --%>
<form action="NewFile.jsp" method="post">
	문자열 a: <input type="text" name="a"><br>
	정수 b: <input type="text" name="b"><br> <!--자료형 이슈맞추기위해 텍스트로받음  -->
	<input type="submit" value="DB에 데이터 추가하기">
</form>
<hr>
<h3>DB에 저장된 데이터 목록</h3>
<%
	// ResultSet
	ResultSet rs= null; 
	try{
		String sql="select * from a";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int i =1;
		while(rs.next()){
			out.println(i+". "+rs.getString("a")+" "+rs.getInt("b")+"<br>");
			i++;
		}
		rs.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	finally{
		JDBC.close(conn, pstmt);
	}
%>

</body>
</html>