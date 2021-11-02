<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">

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
</head>

<body id="sColor">
	<div id="app">
		<mytag:SideBar />
		<div id="main">
			<header class="mb-3">
				<a href="#" class="burger-btn d-block d-xl-none"> <i
					class="bi bi-justify fs-3"></i>
				</a>
			</header>

			<div class="page-heading">
				<div class="page-title">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>채용 발령</h3>
							<p class="text-subtitle text-muted">Multiple form layout you
								can use</p>
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
									<h4 class="card-title">신규입사자 정보</h4>
								</div>
								<div class="card-content">
									<div class="card-body">
										<form class="form form-vertical" action="insertMem.do"
											method="post" name="postIForm">
											<div class="form-body">
												<div class="row">
													<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="first-name-icon">입사일</label>
															<div class="position-relative">
																<input type="date" class="form-control"
																	placeholder="Email" id="email-id-icon" name="startDate">
																<div class="form-control-icon">
																	<i class="bi bi-person"></i>
																</div>
															</div>
														</div>
														<div class="col-12">
															<div class="form-group has-icon-left">
																<label for="password-id-icon">재직</label>
																<div class="position-relative">
																	<input type="text" class="form-control"
																		placeholder="재직/퇴직/휴직" id="password-id-icon"
																		name="work">
																	<div class="form-control-icon">
																		<i class="fas fa-angle-double-right"></i>
																	</div>
																</div>
															</div>
														</div>
														<div class="form-group has-icon-left">
															<label for="first-name-icon">이름</label>
															<div class="position-relative">
																<input type="text" class="form-control" placeholder="성명"
																	id="first-name-icon" name="mName" required>
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-12">

														<div class="form-group has-icon-left">
															<label for="first-name-icon">생년월일</label>
															<div class="position-relative">
																<input type="date" class="form-control"
																	placeholder="Email" id="email-id-icon" name="birthDate">
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="mobile-id-icon">부서명</label>
															<div class="position-relative">
																<input type="text" class="form-control"
																	placeholder="부서명" id="mobile-id-icon" name="teamName">
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="password-id-icon">직무</label>
															<div class="position-relative">
																<input type="text" class="form-control"
																	placeholder="ex)인력관리" id="password-id-icon" name="duty">
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-12">
														<div class="form-group has-icon-left">
															<label for="password-id-icon">직위</label>
															<div class="position-relative">
																<input type="text" class="form-control"
																	placeholder="사원/선임/책임/수석/임원" id="password-id-icon"
																	name="position">
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
																<input type="number" class="form-control"
																	placeholder="직급" id="password-id-icon" name="mrank">
																<div class="form-control-icon">
																	<i class="fas fa-angle-double-right"></i>
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-6 mb-1">
														<fieldset>
															<div class="input-group">
																<input type="file" class="form-control"
																	id="fileUpload" name="path">
																	<!-- aria-describedby="inputGroupFileAddon04"
																	aria-label="Upload"  -->
															</div>
														</fieldset>
													</div>
													<div class="col-12 d-flex justify-content-end">
														<button type="submit" class="btn btn-primary me-1 mb-1">채용발령</button>
														<button type="reset"
															class="btn btn-light-secondary me-1 mb-1">Reset</button>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- // Basic Vertical form layout section end -->



				<!-- // Basic multiple Column Form section end -->
			</div>
		</div>
		<mytag:footer />
	</div>
	<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/main.js"></script>
</body>

</html>