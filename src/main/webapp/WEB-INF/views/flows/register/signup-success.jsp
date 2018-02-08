<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<img src="<c:url value="/resources/images/reg.jpg"/>"
				class=".img-responsive" alt="Supplier">
		</div>
		<div class="col-md-6">
			<div class="text-center">
				<h1>Welcome</h1>
				<h3>Java Orthodox Marketplace</h3>
				<h6>You can login with your email as username</h6>
				<div>
					<a href="${contextRoot}/login" class="btn btn-lg btn-success">Login</a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>