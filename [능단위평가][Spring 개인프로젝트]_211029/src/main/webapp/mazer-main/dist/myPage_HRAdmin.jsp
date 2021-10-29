<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Mazer Admin Dashboard</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet"
	href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="assets/css/pages/auth.css">
<script src="assets/js/common.js"></script>
</head>

<body>
	<div id="auth">

		<div class="row h-100">
			<div class="col-lg-5 col-12">
				<div id="auth-left">
					<div class="auth-logo">
						<a href="main.jsp"><img src="assets/images/logo/YHS_LOGO.png"
						alt="Logo" id="LOGOLogin"></a>
					</div>
					<h1 class="auth-title"  style="font-size : 50px; margin-bottom : 0px;">
						마이페이지
					</h1>
					<br>
					<br>
					<br>
					<form action="updateHRAdmin.do" method="post" name="signUpForm">
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="text" class="form-control form-control-xl" 
								placeholder="사번" name="hmem" value="${userData.hmem}" readonly>
							<div class="form-control-icon">
								<i class="bi bi-person"></i>
							</div>
						</div>
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="password" class="form-control form-control-xl"
								placeholder="비밀번호" name="pw" required>
							<div class="form-control-icon">
								<i class="bi bi-shield-lock"></i>
							</div>
						</div>
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="password" class="form-control form-control-xl"
								placeholder="비밀번호 확인" name="pwCheck" required>
							<div class="form-control-icon">
								<i class="bi bi-shield-lock"></i>
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-block btn-lg shadow-lg mt-5" id="signBtn">정보수정</button>
					</form>
					<a href="javascript:void(0);" onClick="userDelete(${userData.hnum})"><button class="btn btn-primary btn-block btn-lg shadow-lg mt-5" id="signBtn">회원탈퇴</button></a>
				</div>
			</div>
			<div class="col-lg-7 d-none d-lg-block">
				<div id="auth-right"></div>
			</div>
		</div>

	</div>
</body>

</html>