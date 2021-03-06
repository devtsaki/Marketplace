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
		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Supplier Stock Panel</h4>
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" modelAttribute="stock"
						action="${contextRoot}/supplier/stock" method="POST" id="stockForm">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<form:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<form:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<form:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<form:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter a
								description</label>
							<div class="col-md-8">
								<form:textarea path="description" id="description"
									class="form-control"></form:textarea>
								<form:errors path="description" cssClass="help-block"
									element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Unit Price</label>
							<div class="col-md-8">
								<form:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<form:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Available Quantity</label>
							<div class="col-md-8">
								<form:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
								<form:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category</label>
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
								<form:hidden path="userId" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-md-6 text-center">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>BankAccounts Panel</h4>
				</div>
				<div class="panel-body">
				<label>Available Amount</label>
					<h4>${bankAccount.amount} &#8364;</h4>
				</div>
			</div>
		</div>
		<div class="col-md-6">
				 <img src="<c:url value="/resources/images/supplier.svg"/>" class=".img-responsive" alt="Supplier"> 
			</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>All Pending Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div class="container-fluid">
				<div class="table-responsive">
					<table id="sellerProductsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>