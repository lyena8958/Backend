<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="assets/js/common.js"></script>
<script type="text/javascript">

//signUp_HRAdmin
window.onload = function(){
	var signUp = document.signUpForm;
	signUp.onsubmit = function(){

		var pw = signUp.pw;
		var pwCheck = signUp.pwCheck;

		if(signUp.pw.value!=pwCheck.value){
			alert('비밀번호가 일치하지 않습니다.')
			return false;
		}
	}


}

</script>
</head>

<body>
	<div id="auth">

		<div class="row h-100">
			<div class="col-lg-5 col-12">
				<div id="auth-left">
					<div class="auth-logo">
						<a href="index.jsp"><img src="assets/images/logo/YHS_LOGO1.png"
						alt="Logo" id="LOGOLogin"></a>
					</div>
					<h1 class="auth-title"  style="font-size : 50px; margin-bottom : 0px; text-align:center;">
						관리자 등록
					</h1>
					<br>
					<br>
					<br>
					<form action="insertHRAdmin.do" method="post" name="signUpForm">
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="text" class="form-control form-control-xl" 
								placeholder="사번" name="hmem" required>
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
						<button type="submit" class="btn btn-primary btn-block btn-lg shadow-lg mt-5" id="signBtn">Sign-Up</button>
					</form>
				</div>
			</div>
			<div class="col-lg-7 d-none d-lg-block">
				<div id="auth-right"></div>
			</div>
		</div>

	</div>
</body>

</html>