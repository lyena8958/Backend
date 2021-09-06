<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>



			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-8 col-lg-5 mb-6 text-center">
			<% boolean signup = (boolean)request.getAttribute("signup"); 
						System.out.println(signup);
            	if(signup){
            %>
						<h2 class="text-danger">고객님!</h2>
						<h2>회원가입이 완료되었습니다. :D</h2>
					</div>
					<div class="col-12">
						<div class="card card-span rounded-2 mb-3">
							<div class="row"></div>
						</div>
					</div>
					<div class="text-center">
						<a class="text-light" href="login.jsp"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>로그인 이동
							</button></a>
						<br><br><br>
						<a class="text-light" href="index.jsp"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>처음으로
						</button></a>
					</div>
				</div>
			</div>
			<%
				}

				else {
			%>
						<h2 class="text-danger">고객님!</h2>
						<h2>중복된 아이디가 있어 가입 진행이 불가합니다.</h2>
					</div>
					<div class="col-12">
						<div class="card card-span rounded-2 mb-3">
							<div class="row"></div>
						</div>
					</div>
					<div class="text-center">
						<a class="text-light" href="signUp.html"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>회원가입 이동
							</button></a>
						<br><br><br>
						<a class="text-light" href="index.jsp"><button
								class="btn btn-primary px-5" >
								<i class="fas fa-phone-alt me-2"></i>처음으로
						</button></a>
					</div>
				</div>
			</div>
			
			<%
				}
			%>