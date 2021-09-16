<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type" required="true"%>

<!-- msg -->
<c:if test="${type=='msg'}">
<!-- [msg] 댓글내용 - 바로출력하지 않고 회원여부에 따라 출력 == UD기능을 위함 -->
  <!-- 회원 UD기능  댓글 (C는하단에) -->
		<c:if test="${userData != null}">
			<!-- 댓글 작성자 삭제/수정기능 -->
			<c:if test="${userData.userID == msg.userID}">
			
				<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="msgUpdate">
					<input type="hidden" name="mnum" value="${msg.mnum}">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="text" name="msg" value="${msg.msg}">
					<input type="submit" value="수정하기">
				</form>
				
				<!--삭제버튼 -->
				<a  class="c1" href="control.jsp?action=msgDelete&mnum=${msg.mnum}&mcnt=${mcnt}"><input type="button" value="삭제하기"></a>
				<br>
				
			</c:if>
				<c:if test="${userData.userID != msg.userID}">
					${msg.msg} 
				</c:if>
		</c:if>	
  <!-- // -->
  
  <!-- 비회원 댓글출력 -->
		<c:if test="${userData == null}">
			${msg.msg} 
		</c:if>
  <!-- // -->	

</c:if>










<!-- rmsg -->
<c:if test="${type=='rmsg'}">

		
<!-- [rmsg] 리플내용 - 바로출력하지 않고 회원여부에 따라 출력 == UD기능을 위함 -->
 <!-- 본인 UD기능  리플 (C는상단에) -->		
			<c:if test="${userData.userID == replyList.userID}">
			<a href="control.jsp?action=replyDelete&rnum=${replyList.rnum}&mcnt=${mcnt}"><input type="button" value="삭제하기"></a>
				<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="replyUpdate">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mnum" value="${replyList.mnum}">
					<input type="text" name="rmsg" value="${replyList.rmsg}">
					<input type="submit" value="수정하기">
				</form>
		</c:if>
<!--  // -->

 <!-- 비당사자 댓글출력 -->
			<c:if test="${userData.userID != replyList.userID}">
					${replyList.rmsg}
			</c:if>
<!-- // -->

</c:if>