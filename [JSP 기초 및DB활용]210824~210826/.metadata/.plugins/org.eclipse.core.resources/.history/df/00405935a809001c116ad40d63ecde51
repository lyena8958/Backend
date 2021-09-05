<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*,java.util.ArrayList"%>
 <jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/><!-- 무조건 컨트롤러를 거쳐오기때문에 굳이 세션이나 앱을 사용할 필요는 없다. -->
					<!-- 타입이 AL이기때문에 클래스를 al로 지정한다.(id와 class타입이 같아야 함) -->
 
<!-- list.jsp를 index로(첫페이지) 하면 안되는 이유 -->
<!-- 글목록 화면을 보여줄것 == arraylist데이터가 필요 -->
<!-- 이때 AL데이터를 DAO로 받아오는데 이 작업을 컨트롤러에서 하기 때문에 -->
<!-- V와 M 직행이 안되기 때문에 C를 거쳐서 해야하므로 index.jsp페이지에서 받고, list를 출력할 예정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 화면</title>
</head>
<body>
<!-- 해당페이지에서 입력/수정/삭제를 위한 클릭 링크 필요 == 최소 링크 2개 -->

<h2>게시글 목록</h2>
<hr>
<a href="form.jsp">글 등록</a>
<hr>


<table border="1">
	<tr>
		<th>글 번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<!--content는 상세페이지에서 보여줄 예정 -->
	</tr>
	<%
		// 뷰 부분
		//데이터 개수를 모르니 foreach를 통해 출력
		// 참고로 datas에 값이없어도 오류가 나지않는데, dao에서 al을 받았을 때 null로 받지않고 al자체이기 때문이다.
		for(MessageVO vo:(ArrayList<MessageVO>)datas){ 
			//(ArrayList<MessageVO>)로 캐스팅을 안해주면 ArrayList로 인지하기 때문에 식별이불가하다.
			// 또한 ArrayList였다면 MessageVO 가아니라 Object인것이다.
			// 근데 오버라이딩이 되어있어 out.println(vo+"<br>") 로도 출력이 가능하다.
			//그런데 출력할 문구위치가 지정되어있기 때문에 그렇게는 사용안했다.
			
	%>
		<tr>
		<!-- num를 누르면 상세페이지 이동하도록 구현할것임 > pk이기 때문에 구현하기쉬움 -->
						<!-- get방식 , 데이터가 여러개로 겹칠때 &사용됨-->
			<td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum()%>"> <%= vo.getMnum() %></a></td> 
			<!-- 글 변경을 위한 비밀번호 등의 인증작업이 필요하겠다.-->
			<td><%= vo.getTitle() %></td>
			<td><%= vo.getWriter() %></td>
			<td><%= vo.getWdate() %></td>
		</tr>
		
	<%	
		}
	%>
</table>

</body>
</html>