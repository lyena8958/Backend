<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*, javax.naming.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP 실습-DAO파트만 분리하기</title>
</head>
<body>

<%
	//DAO
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	try{//최종적으로 DataSource를 얻어야 한다. 
		Context initContext = new InitialContext(); //얘를 쓰려면 javax.sql.* import //context.xml로부터 받아옴
		
		// 프로그램이 더이상 DB에 종속적이지가 않다. 결합되어있는 부분을 느슨하게 작업을 해준다.
		//오타위험, 코드 유연성 증가를 위해 20, 21 라인을 잘라서 쓰는것이 보통이다.
		//디렉토리방식 uri									//java:/comp/env 기본적으로 제공되는 것(jdbc/oracle 이런것처럼 고정)
		Context envContext = (Context)initContext.lookup("java:/comp/env"); //데이터 소스객체를 얻어오는게 목표
		DataSource ds = (DataSource)envContext.lookup("jdbc/orcl"); // lookup = 네이밍서비스 (데이터 소스를 만들어주세요)
		// 프로그래머가 지향하는 "낮은 결합도" ★★★★★x10000000, 높은 응집도 -> 프로그램이 유연해진다! -> 개별작업이 가능하다
		
		// 실무에서는 위처럼 잘라서 사용(다 붙여서 쓰면 결합도가 높아진다.)
		//DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/orcl");  //내가설정해두었던 그 이름을 ds로 받아오는것
									// 리턴타입이 object이므로 캐스팅을 해주자
									
											
		// 메서드는 위 외에는 없다.
		//드라이버를 안쓰고 DataSource
		
		conn=ds.getConnection();
		String sql="insert into test values(?,?)";
		if(request.getParameter("name")!=null){
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("email"));
			pstmt.executeUpdate();
		}
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
%>

<form method="post">
	<input type="text" name="name">
	<input type="text" name="email">
	<input type="submit" value="추가하기">
</form>

<hr>

<%
	try{
		String sql="SELECT * FROM TEST";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			out.println(rs.getString("name")+"님 이메일주소는 "+rs.getString("email")+"  <br>");
		}
		//커넥션풀이 체크를해서 사용시에는 자원반납을 체크를한다.
		//근데 미리 CLOSE을 해주면 반납을 체크하는 시간을 줄여준다.
		//finally 넣으면 좋지만 안넣어도 상관없다!~
		rs.close(); // 안닫아도 되지면 닫는것을 권장
		pstmt.close(); // 안닫아도 되지면 닫는것을 권장
		conn.close(); // 안닫아도 되지면 닫는것을 권장
	}catch(Exception e){
		System.out.println(e);
	}

%>

<!-- 기존: DB연결이 해제되면 커넥션 객체를 직접 소멸하는 방식 -->
<!-- 이번 : 커넥션 풀이 자원을 반납해주는 형태O -->

</body>
</html>