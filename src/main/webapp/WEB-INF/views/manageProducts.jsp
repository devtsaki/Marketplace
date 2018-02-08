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
					<h4>Product Management Panel</h4>
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/admin/products" method="POST"
						enctype="multipart/form-data">
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
							<label class="control-label col-md-4" for="file">Select
								an Image</label>
							<div class="col-md-8">
								<form:input type="file" path="file" id="file"
									class="form-control" />
								<form:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<form:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id == 0}">
									<br />
									<div class="text-right">
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-sm">
											Add Category</button>
									</div>
								</c:if>
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
			<div class="col-md-6">
				 <img src="<c:url value="/resources/images/admin.jpg"/>" class=".img-responsive" alt="Admin"> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div class="container-fluid">
				<div class="table-responsive">
					<table id="adminProductsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
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
								<th>&#160;</th>
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
	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<form:form id="categoryForm" modelAttribute="category"
						action="${contextRoot}/admin/category" method="POST"
						class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category
								Name</label>
							<div class="col-md-8">
								<form:input type="text" path="name" id="category_name"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category
								Description</label>
							<div class="col-md-8">
								<form:textarea cols="" rows="5" path="description"
									id="category_description" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category"
									class="btn btn-primary" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>Buy From Suppliers</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div class="container-fluid">
				<div class="table-responsive">
					<table id="adminStockTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Id</th>
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
								<th>Id</th>
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

