<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Address</h4>
				</div>
				<div class="panel-body">
					<form:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="billing">
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address</label>
							<div class="col-md-8">
								<form:input type="text" path="addressLineOne"
									class="form-control" placeholder="Enter Address" />
									<form:errors path="addressLineOne" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<form:input type="text" path="city" class="form-control"
									placeholder="Enter City" />
									<form:errors path="city" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal
								Code</label>
							<div class="col-md-8">
								<form:input type="text" path="postalCode" class="form-control"
									placeholder="Enter Postal Code" />
									<form:errors path="postalCode" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<form:input type="text" path="country" class="form-control"
									placeholder="Enter Country" />
									<form:errors path="country" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">
									<span class="glyphicon glyphicon-chevron-left"></span> Previous
									- Personal
								</button>
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">
									Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span>
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