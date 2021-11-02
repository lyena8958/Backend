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
</head>

<body id="sColor">
	<div id="app">
		<mytag:SideBar />
		<div id="main"> <!-- <div id="main"> -->
		         <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>

			<section class="section">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">구성원 조회</h4>
					</div>

					<div class="card-body">
						<div class="row">
							<div class="col-md-6">
								<form action="showMem.do" method="post">
									<div class="form-group">
									<span>
										<label for="basicInput">사원번호</label> <input type="text" class="form-control" id="basicInput" placeholder="사번" name="mnum" required>
										<button type="submit" class="btn btn-primary me-1 mb-1">조회</button>
										</span>
									</div>
								</form>
								<!-- // Basic multiple Column Form section end -->
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<mytag:footer/>
	</div>

	<script src="assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/main.js"></script>

</body>

</html>