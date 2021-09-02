												<!-- scriptless : default 설정됨 -->
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>

<!-- attributed 외부에서 이 태그를 쓸 때 속성을 지정/불러올 수가 있다.  -->
<!--%@ attribute %> -->
<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<!-- body-content에서 불러올 것을 액션태그로 가져온다. -->
<h1><jsp:doBody/></h1>

<hr>

<jsp:useBean id="dataBean" class="model.DataBean"/>
<table border="${border}" bgcolor="${bgcolor}">
		<!--  -->
	<%
		for(String v: dataBean.getDataList()){
			out.println("<tr><td>"+v+"</td></tr>");
		}
	%>
</table>