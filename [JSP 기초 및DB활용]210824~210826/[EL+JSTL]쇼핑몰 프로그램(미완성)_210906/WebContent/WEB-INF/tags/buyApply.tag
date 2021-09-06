<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>



<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-8 col-lg-5 mb-6 text-center">
			<% boolean payApply = (boolean)request.getAttribute("payApply"); 
            	if(payApply){
            %>
				<h2 class="text-danger">고객님!</h2>
					<h2>구매가 완료되었습니다.</h2>
						<h2>이용해 주셔서 감사드립니다. 빠른 시일내 발송해드리겠습니다. :)</h2>
			<%
				}

				else {
			%>
				<h2 class="text-danger">고객님!</h2>
					<h2>시스템이 불안정하여 구매가 취소되었습니다.</h2>
					  <br><br>
						<h4>아래 연락처로 연락주시면 신속한 안내드리겠습니다.</h4>
							<h4>Tel)02-0000-0000</h4>


			<%
				}
			%>
		</div>
		<div class="col-12">
			<div class="card card-span rounded-2 mb-3">
				<div class="row"></div>
			</div>
		</div>
		<div class="text-center">
			<form action="control.jsp" method="post">
				<input type="hidden" name="action" value="list"> <a
					class="text-light" href="index.html"><button
						class="btn btn-primary px-5">
						<i class="fas fa-phone-alt me-2"></i>처음으로
					</button></a>
			</form>
		</div>
	</div>
</div>