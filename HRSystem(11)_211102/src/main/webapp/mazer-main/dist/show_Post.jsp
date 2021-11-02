<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

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
<!-- JQuery -->
<script src="assets/js/jquery-3.6.0.min.js"></script>

<script src="assets/js/common.js"></script>
<script type="text/javascript">
window.onload=function(){
	var form = document.postUForm;
	var resultApply = document.getElementById("resultApply");
	
	console.log(resultApply);
	
	if(resultApply.value=="Active"){
		document.getElementById("InActive").remove();
		form.result.style.backgroundColor ="#e9ecef"; // readonly효과
	}
}

</script>
</head>

<body id="sColor">
	<div id="app">
		<mytag:SideBar/>
		<div id="main">
			<header class="mb-3">
				<a href="#" class="burger-btn d-block d-xl-none"> <i
					class="bi bi-justify fs-3"></i>
				</a>
			</header>
			<div ID="loginMove">
				<a href="getListPost.do">YHS</a>
			</div>
			<div class="page-heading" style="margin-top: 60px;">
				<div class="page-title">
					<div class="row">
						<div class="col-12 col-md-6 order-md-1 order-last">
							<h3>윤리 신고</h3>
							<p class="text-subtitle text-muted">※ 익명
								보장&nbsp;|&nbsp;인사담당자에게 전달되어 이후 열람이 불가하오니 유의 바랍니다.</p>
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


				<!-- // Basic multiple Column Form section start -->
				<section id="multiple-column-form">
					<div class="row match-height">
						<div class="col-12">
							<div class="card" style="width : 60%;">
								<div class="card-header">
									<h4 class="card-title">신고 단일조회</h4>
								</div>
								<div class="card-content">
									<div class="card-body">
										<form action="updatePost.do" method="post" class="form"
											name="postUForm">
											<input type="hidden" name="pnum" value="${data.pnum}">
											<input type="hidden" name="password" value="${data.password}">
											<div class="row">
												<div class="col-md-6 col-12">
													<div class="form-group">
														<label for="first-name-column">대상 사번</label>

														<!-- 사번 input -->
														<input type="text" id="first-name-column"
															class="form-control" placeholder="사번" name="pmem"
															maxlength="10" value="${data.pmem}" readonly>

													</div>

												</div>
												<div class="col-md-6 col-12">
													<div class="form-group">
														<br>

													</div>
												</div>
												<div class="col-md-6 col-12">
													<div class="form-group fullPost">
														<label for="last-name-column">카테고리</label>
														<!--  <input type="text" id="last-name-column" class="form-control "
                                                            placeholder="카테고리" name="category" required> -->
														<fieldset class="form-group">
															<select class="form-select" id="basicSelect" name="category" style="background-color : #e9ecef;" >
																<option>${data.category}</option>
<!-- 																<option>폭언ㆍ욕설</option>
																<option>직급자의 강요</option>
															    <option>의도적인 괴롭힘(평가/업무/사적 등)</option>
															    <option>폭행/성폭행</option>
															    <option>성추행</option>
																<option>기타</option> -->
															</select>
														</fieldset>
													</div>
												</div>
												<div class="col-md-6 col-12">
													<div class="form-group">
														<br>

													</div>
												</div>
												<div class="col-md-6 col-12">
													<div class="form-group fullPost">
														<label for="city-column">내용</label> <input type="text"
															id="city-column" class="form-control pTextarea"
															name="content" value="${data.content}" readonly>
													</div>
												</div>
												<div class="col-md-6 col-12">
													<div class="form-group">
														<br>

													</div>
												</div>
												<div class="col-md-6 col-12">
													<label for="last-name-column">처리결과</label>
														<fieldset class="form-group">
															<select class="form-select" id="resultSelect" name="result" onchange="resultSelColor();">
															    <option id="Active">Active</option>
																<option id="InActive" selected>InActive</option>
															</select>
														</fieldset>
													</div>
												</div>
												<div class="col-12 d-flex justify-content-end">
													<input type="submit" class="btn btn-primary me-1 mb-1" value="반영">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" id="resultApply" value="${data.result}">
				</section>
				<!-- // Basic multiple Column Form section end -->
			</div>

			<mytag:footer />
		</div>
	</div>
	<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/main.js"></script>
</body>

</html>