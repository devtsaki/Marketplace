<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management Panel</h4>
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/admin/products" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<form:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<form:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<form:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<form:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter a
								description</label>
							<div class="col-md-8">
								<form:textarea path="description" id="description"
									class="form-control"></form:textarea>
								<form:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Unit Price</label>
							<div class="col-md-8">
								<form:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<form:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Available Quantity</label>
							<div class="col-md-8">
								<form:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<form:errors path="quantity" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<form:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<form:hidden path="id" />
								<form:hidden path="code" />
								<form:hidden path="supplierId" />
								<form:hidden path="purchases" />
								<form:hidden path="views" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>