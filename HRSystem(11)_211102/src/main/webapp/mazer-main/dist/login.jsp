<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>YHR</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet"
	href="assets/vendors/bootstrap-icons/bootstrap-icons.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="assets/css/pages/auth.css">
</head>

<body>
	<div id="auth">

		<div class="row h-100">
			<div class="col-lg-5 col-12">
				<div id="auth-left">
					<div class="auth-logo">
						<a href="index.jsp"><img
							src="assets/images/logo/YHS_LOGO1.png" alt="Logo" id="LOGOLogin"></a>
					</div>
					<h1 class="auth-title">
						<spring:message code="message.member.login" />
					</h1>
					<br> <br> <br>
					<form action="loginHRAdmin.do" method="post" name="loginForm">
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="text" class="form-control form-control-xl"
								placeholder="<spring:message code="message.member.userNum"/>"
								name="hmem" required>
							<div class="form-control-icon">
								<i class="bi bi-person"></i>
							</div>
						</div>
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="password" class="form-control form-control-xl"
								placeholder="<spring:message code="message.member.password"/>"
								name="pw" required>
							<div class="form-control-icon">
								<i class="bi bi-shield-lock"></i>
							</div>
						</div>
						<button class="btn btn-primary btn-block btn-lg shadow-lg mt-5">
							<spring:message code="message.member.loginBtn" />
						</button>
					</form>
					<div class="text-center mt-5 text-lg fs-4">
						<p class="textColor text-gray-600">
							<spring:message code="message.member.signUpText" />
							<a href="signUp_HRAdmin.jsp" class="textColor1 1font-bold"
								id="signUpMove"><spring:message code="message.member.signUp" /></a>
						</p>
						<br>
						<!-- 비밀번호 찾기 - 향후 구현 예정<p>
							<a class="font-bold textColor2" href="auth-forgot-password.html">
								<spring:message code="message.member.passwordInfo" />
							</a>
						</p> -->
						<p>
							<a class="font-bold textColor2" href="insertPost.jsp">*
								<spring:message code="message.member.memberReport" />
							</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-7 d-none d-lg-block">
				<div id="auth-right"></div>
			</div>
		</div>

	</div>
</body>

</html>