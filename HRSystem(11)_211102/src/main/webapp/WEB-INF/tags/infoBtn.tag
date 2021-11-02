<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="mnum" required="true"%>
<%@ attribute name="type"%>

<div role="group" aria-label="Basic example" id="memInfo">

	<c:if test="${type=='license'}">
		<a href="showMem.do?mnum=${mnum}"><button type="button"
				class="btn btn-secondary">이전</button></a>
		<a href="getSchool.do?smem=${mnum}"><button type="button"
				class="btn btn-secondary">학력</button></a>
		<a href="getCareer.do?cmem=${mnum}"><button type="button"
				class="btn btn-secondary">경력</button></a>
	</c:if>
	<c:if test="${type=='school'}">
		<a href="showMem.do?mnum=${mnum}"><button type="button"
				class="btn btn-secondary">이전</button></a>
		<a href="getCareer.do?cmem=${mnum}"><button type="button"
				class="btn btn-secondary">경력</button></a>
		<a href="getLicense.do?lmem=${mnum}"><button type="button"
				class="btn btn-secondary">자격증</button></a>
	</c:if>
	<c:if test="${type=='career'}">
		<a href="showMem.do?mnum=${mnum}"><button type="button"
				class="btn btn-secondary">이전</button></a>
		<a href="getSchool.do?smem=${mnum}"><button type="button"
				class="btn btn-secondary">학력</button></a>
		<a href="getLicense.do?lmem=${mnum}"><button type="button"
				class="btn btn-secondary">자격증</button></a>
	</c:if>

	<c:if test="${type==null}">
		<a href="getSchool.do?smem=${mnum}"><button type="button"
				class="btn btn-secondary">학력</button></a>
		<a href="getCareer.do?cmem=${mnum}"><button type="button"
				class="btn btn-secondary">경력</button></a>
		<a href="getLicense.do?lmem=${mnum}"><button type="button"
				class="btn btn-secondary">자격증</button></a>
	</c:if>

	<%-- 	<c:choose>
		<c:when test="${type=='school'}">
			<a href="getCareer.do?cmem=${mnum}"><button type="button"
					class="btn btn-secondary">처음으로</button></a>
			<a href="getCareer.do?cmem=${mnum}"><button type="button"
					class="btn btn-secondary">경력</button></a>
			<a href="getLicense.do?lmem=${mnum}"><button type="button"
					class="btn btn-secondary">자격증</button></a>			
		</c:when>
		<c:when test="${type=='license'}">
			<a href="getCareer.do?cmem=${mnum}"><button type="button"
					class="btn btn-secondary">경력</button></a>
			<a href="getLicense.do?lmem=${mnum}"><button type="button"
					class="btn btn-secondary">자격증</button></a>			
		</c:when>

		<c:otherwise>
			<a href="getSchool.do?smem=${mnum}"><button type="button"
					class="btn btn-secondary">학력</button></a>
			<a href="getCareer.do?cmem=${mnum}"><button type="button"
					class="btn btn-secondary">경력</button></a>
			<a href="getLicense.do?lmem=${mnum}"><button type="button"
					class="btn btn-secondary">자격증</button></a>
		</c:otherwise>


	</c:choose> --%>
</div>