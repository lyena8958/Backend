<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>YHR</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap.css">

<link rel="stylesheet"
	href="assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet"
	href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="shortcut icon" href="assets/images/favicon.svg"
	type="image/x-icon">
<!-- fontawesome 아이콘 -->
<script src="https://kit.fontawesome.com/10c13da5c4.js"
	crossorigin="anonymous"></script>
<script src="assets/js/common.js"></script>
</head>

<body id="sColor">
	<div id="app">
		<mytag:SideBar />
		<div id="main">
			<!-- style="float: left;" -->
			<header class="mb-3">
				<a href="#" class="burger-btn d-block d-xl-none"> <i
					class="bi bi-justify fs-3"></i>
				</a>
			</header>

			<div class="page-heading">
				<div class="page-title">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>자격 사항</h3>
							<p class="text-subtitle text-muted bcolor">Multiple form
								layout you can use</p>
						</div>
						<div class="col-12 col-md-6 order-md-2 order-first">
							<nav aria-label="breadcrumb"
								class="breadcrumb-header float-start float-lg-end">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
									<li class="breadcrumb-item active" aria-current="page">Form
										Layout</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				
				<!-- // Basic Horizontal form layout section end -->
				<!-- Basic Vertical form layout section start -->
				<section id="basic-vertical-layouts">
					<div class="row match-height">
						<div class="col-md-6 col-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="infoText">조회</h4>
								</div>
								<mytag:infoBtn mnum="${data.lmem}" type="license"/>
								<!-- 데이터가 없는 경우 -->
								<c:if test="${data==null}">
									<div class="card-content" id="emptySize">
										<a href="insert_license.jsp?lmem=${lmem}"><i
											class="far fa-file-alt btnIcon"></i></a>
										<h3 id="empty">정보가 존재하지 않습니다.</h3>
								</c:if>

								<!-- 데이터가 있는 경우 -->
								<c:if test="${data!=null}">
									<div class="card-content">
										<div id="iconWrapper">
											<a href="javascript:void(0);" onClick="edit()" id="editIcon"><i
												class="fas fa-pen"></i></a> <a
												href="insert_license.jsp?lmem=${data.lmem}"><i
												class="far fa-file-alt btnIcon"></i></a>

											<!-- 이전페이지 -->
											<c:if test="${first==null}">
												<a href="getLicense.do?lmem=${data.lmem}&pnum=${pnum-1}"
													class="">
													<!-- <i
													class="fas fa-arrow-alt-circle-left btnIcon"></i>-->
													<i class="far fa-arrow-alt-circle-left"></i>
												</a>
											</c:if>

											<!-- 다음 페이지 -->
											<c:if test="${last==null}">
												<a href="getLicense.do?lmem=${data.lmem}&pnum=${pnum+1}">
													<!-- <i
													class="far fa-arrow-alt-circle-right btnIcon"></i> -->
													<i class="fas fa-arrow-alt-circle-right"></i>
												</a>
											</c:if>
										</div>
										<div class="card-body">
											<form class="form form-vertical" action="updateLicen.do"
												method="post">
												<input type="hidden" name="lnum" value="${data.lnum}">
												<input type="hidden" name="pnum" value="${pnum}">
												<div class="form-body">
													<div class="row">
														<div class="col-12">
															<div class="form-group has-icon-left">
																<label for="first-name-icon">사번</label>
																<div class="position-relative">
																	<input type="text" class="form-control"
																		placeholder="Email" id="email-id-icon" name="lmem"
																		value="${data.lmem}" readonly>
																	<div class="form-control-icon">
																		<i class="bi bi-person"></i>
																	</div>
																</div>
															</div>
														</div>
														<div class="form-group has-icon-left">
															<label for="first-name-icon">취득일</label>
															<div class="position-relative">
																<input type="date" class="form-control edit"
																	placeholder="취득일자" id="email-id-icon" name="getDate"
																	value="${data.getDate}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
														<div class="form-group has-icon-left">
															<label for="first-name-icon">만료일</label>
															<div class="position-relative">
																<input type="date" class="form-control edit"
																	placeholder="만료일자" id="email-id-icon" name="expireDate"
																	value="${data.expireDate}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
														<div class="form-group has-icon-left">
															<label for="first-name-icon">자격증 명</label>
															<div class="position-relative">
																<input type="text" class="form-control edit"
																	placeholder="자격증 명" id="first-name-icon" name="lname"
																	value="${data.lname}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-12">

														<div class="form-group has-icon-left">
															<label for="first-name-icon">등급</label>
															<div class="position-relative">
																<input type="text" class="form-control edit"
																	placeholder="직위" id="email-id-icon" name="grade"
																	value="${data.grade}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<%-- 	<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="mobile-id-icon">직무</label>
															<div class="position-relative">
																<input type="text" class="form-control edit"
																	placeholder="수행직무" id="mobile-id-icon" name="duty"
																	value="${data.duty}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div> 
													<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="password-id-icon">년차</label>
															<div class="position-relative">
																<input type="number" class="form-control edit"
																	placeholder="직급" id="password-id-icon" name="rank"
																	value="${data.rank}" readonly>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div> --%>

													<div class="col-12 d-flex justify-content-end">
														<input type="hidden" class="btn btn-primary me-1 mb-1"
															id="update" value="수정">
													</div>
													<br> <a href="javascript:void(0);"
														onClick="infoDelete('해당 자격증을 정말 삭제하시겠습니까?','deleteLicen.do?lnum=${data.lnum}&lmem=${data.lmem}&pnum=${pnum-1}');">
														<input type="hidden" value="삭제"
														class="btn btn-primary me-1 mb-1" id="delete" required>
													</a>
												</div>
											</form>
										</div>
										<hr id="pnumLine">
										<p id="pageNum">${pnum}</p>
								</c:if>
								<!-- //// 데이터가 있는 경우 -->
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<mytag:footer />
	</div>
	<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/main.js"></script>
</body>

</html>
