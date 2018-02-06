<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<form:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
						<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-md-8">
								<form:input type="text" path="firstName" class="form-control"
									placeholder="First Name" />
									<form:errors path="firstName" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<form:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" />
									<form:errors path="lastName" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<form:input type="text" path="email" class="form-control"
									placeholder="abc@xyz.com" />
									<form:errors path="email" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<form:input type="text" path="contactNumber"
									class="form-control" placeholder="Phone Number" maxlength="10" />
									<form:errors path="contactNumber" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								<form:input type="password" path="password" class="form-control"
									placeholder="Password" />
									<form:errors path="password" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-md-8">
								<form:input type="password" path="confirmPassword" class="form-control"
									placeholder="Confirm Password" />
									<form:errors path="confirmPassword" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Select role</label>
							<div class="col-md-8">
								<label class="radio-inline">
									<form:radiobutton path="role" value="USER" checked="checked" />User
								</label>
								<label class="radio-inline">
									<form:radiobutton path="role" value="SUPPLIER" />Supplier
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
								Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>