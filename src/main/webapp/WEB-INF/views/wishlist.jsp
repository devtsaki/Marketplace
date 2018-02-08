<div class="container">
	<c:if test="${not empty message}">
		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>
	</c:if>
	<c:choose>
		<c:when test="${not empty wishlistLines}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 70%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 10%">Quantity</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${wishlistLines}" var="wishlistLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img
											src="<c:url value="/resources/images/${wishlistLine.product.code}.jpg"/>"
											alt="${wishlistLine.product.name}" class="img-responsive cartImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${wishlistLine.product.name}
											<c:if test="${wishlistLine.available == false}">
												<strong class="unavailable">(Not Available)</strong>
											</c:if>
										</h4>
										<p>Brand - ${wishlistLine.product.brand}</p>
										<p>Description - ${wishlistLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${wishlistLine.buyingPrice} &#8364;</td>
							<td data-th="Quantity"><input type="number"
								id="count_${wishlistLine.id}" min="1" max="4S"
								class="form-control text-center"
								value="${wishlistLine.productCount}"></td>
							<td class="actions" data-th="">
								<a href="${contextRoot}/wishlist/${wishlistLine.id}/remove" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your wishlist is empty!</h1>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</div>