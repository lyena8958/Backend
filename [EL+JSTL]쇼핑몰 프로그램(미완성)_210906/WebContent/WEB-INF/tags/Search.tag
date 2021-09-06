<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<jsp:useBean id="searchDatas" class="java.util.ArrayList" scope="request"/>

	<%	
	//검색내용이 없다면 (isEmpty :길이가0이면 true반환)
	if(searchDatas.isEmpty()||searchDatas==null){
	%>
		<p>검색 내용이 존재하지 않습니다.</p>
	<%
	}
	//검색내용이 있다면 기록을 보여줌
	else{
	%>
		<jsp:doBody/>
	
	<%
	}
	
	%>