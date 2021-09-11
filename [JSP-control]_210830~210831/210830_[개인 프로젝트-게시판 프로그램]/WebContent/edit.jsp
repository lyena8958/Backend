<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="model.message.MessageVO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정/삭제 화면</title>
<script>
	function del(){
		result = confirm("정말로 삭제하시겠습니까?"); //alert(알림창), confirm(선택창) 
		if(result==true){ //확인 버튼을 누른다면,
			// c에게 보낼 action value를 dalete로 변경
			//    --> 사용자가 선택을 할 수있게된다.
			document.form1.action.value="delete"; 
			// 현재 controller에서 delete 후 이동페이지를 설정안했을 때는
			// 뒤로가기시 edit가아니라 delete가 수행되는 버그가 발생했는데,
			// 이는 향후 delete 기능을 set하면 없어질 문제가 딱히문제가 생기지 않는다.
			document.form1.submit();
		}
		else{//아무일도 일어나지않음
			return;
		}
	}
</script>
</head>
<body>

<!-- 변심으로 첫 페이지를 돌아가고싶은 사용자를 위해 메인돌아가기 a태그 사용 -->
<a href="control.jsp?action=list">메인으로 돌아가기</a>
<form action="control.jsp" method="post" name="form1"> <!-- 스크립트에서 태그를 가져오기위해 name부여 -->
<input type="hidden" name="action" value="update"> <!-- C입장에서 업데이트 항목인지 모르니 >> 사용자가 보이면안돼서 hidden으로 지정 -->
<input type="hidden" name="mnum" value="<%=data.getMnum()%>"> <!-- mnum을 이 페이지 에서 못받아왔으니 hidden으로부터 사용자에게 데이터를 가려주고, 데이터를 같이 넘긴다. -->
<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" value="<%=data.getWriter()%>"></td> <!-- 수정을 text로 받음 -->
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" value="<%=data.getTitle()%>"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content" value="<%=data.getContent()%>"></td>
	</tr>
		<tr>
		<td>작성일</td>
		<td><input type="date" name="date" value="<%=data.getWdate()%>"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="내용 변경하기"> <!-- 수정==submit -->
		<input type="button" value="글 삭제하기" onClick="del()"></td> <!-- 삭제==버튼 -->
	</tr>
</table>
</form>
</body>
</html>