<%@include file="../../shared/flows-header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-md-4">
			<h4>Select Shipping Address</h4>
			<hr />
			<div class="row">
				<c:forEach items="${addresses}" var="address">
					<div class="cols-xs-12">
						<h3>${address.addressLineOne}</h3>
						<h4>${address.city}- ${address.postalCode}</h4>
						<h4>${address.country}</h4>
						<hr />
						<div class="text-center">
							<a
								href="${flowExecutionUrl}&_eventId_addressSelection&shippingId=${address.id}"
								class="btn btn-primary">Select</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Shipping - Address</h4>
				</div>
				<div class="panel-body">
					<sf:form method="POST" modelAttribute="shipping"
						class="form-horizontal" id="billingForm">
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" class="form-control"
									placeholder="Enter Address" />
								<sf:errors path="addressLineOne" cssClass="help-block"
									element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" class="form-control"
									placeholder="Enter City Name" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal
								Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" class="form-control"
									placeholder="XXXXXX" />
								<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" class="form-control"
									placeholder="Enter Country Name" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_saveAddress"
									class="btn btn-primary">
									<span class="glyphicon glyphicon-plus"></span> Add Address
								</button>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../../shared/flows-footer.jsp"%>