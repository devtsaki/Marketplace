<!-- DataTable Bootstrap Script -->
<script src="<c:url value="/resources/js/angular.js"/>"></script>

<!-- DataTable Bootstrap Script -->
<script src="<c:url value="/resources/js/productsController.js"/>"></script>
<div class="container" ng-app="ShoppingApp"
	ng-controller="ProductController as pCtrl">

	<div class="row" ng-init="pCtrl.fetchProducts()">



		
			<div id="carousel-example" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-example" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example" data-slide-to="1"></li>
					<li data-target="#carousel-example" data-slide-to="2"></li>
					<li data-target="#carousel-example" data-slide-to="3"></li>
				</ol>

				<div class="carousel-inner">
					<div class="item active">
						<a href="#"><img src="<c:url value="/resources/images/banner1.jpg"/>" /></a>
						<div class="carousel-caption">
							<h3>What is it, Major Lawrence, that attracts you personally to the desert? </h3>
							<p>It's clean.</p>
						</div>
					</div>
					<div class="item">
						<a href="#"><img src="<c:url value="/resources/images/banner2.jpg"/>" /></a>
						<div class="carousel-caption">
							<h3>This is some rescue! You came in here, but didn't you have a plan for getting out?</h3>
							<p>He's the brains, sweetheart!</p>
						</div>
					</div>
					<div class="item">
						<a href="#"><img src="<c:url value="/resources/images/banner3.jpg"/>" /></a>
						<div class="carousel-caption">
							<h3>Hey, Doc, we better back up. We don't have enough road to get up to 88. </h3>
							<p>Roads? Where we're going, we don't need roads.</p>
						</div>
					</div>
					<div class="item">
						<a href="#"><img src="<c:url value="/resources/images/banner4.jpg"/>" /></a>
						<div class="carousel-caption">
							<h3>What are you talking about, HAL?</h3>
							<p>This mission is too important for me to allow you to jeopardize it.</p>
						</div>
					</div>
				</div>

				<a class="left carousel-control" href="#carousel-example"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#carousel-example"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
			<div class="col-md-offset-1 col-md-10">
			<div class="row">
				<div class="col-sm-12">
					<h3>Our Most Viewed Products</h3>
					<hr />
				</div>
			</div>

			<div class="row is-table-row text-center">

				<div class="col-md-3 col-sm-4" ng-repeat="product in pCtrl.mvProducts">
					<div class="thumbnail">
						<img
							ng-src="<c:url value="/resources/images/{{product.code}}.jpg"/>"
							alt="{{product.name}}" class="landingImg">
						<h5>{{product.name}}</h5>
						<hr />
						<div class="caption">
							<h4>{{product.unitPrice}} &#8364;</h4>
							<p>{{product.description}}</p>
							<a ng-href="${contextRoot}/show/{{product.id}}/product"
								class="btn btn-primary btn-block">View</a>
						</div>
					</div>

				</div>

				<div class="col-sm-12">
					<h4>Checkout more products!</h4>
					<hr />
					<a class="btn btn-warning btn-block"
						href="${contextRoot}/show/all/products">More Products</a>
				</div>

			</div>

			<div class="row text-center">
				<div class="col-xs-12">
					<h3>Our Most Purchased Products</h3>
					<hr />
				</div>
			</div>
			<div class="row is-table-row text-center">

				<div class="col-md-3 col-sm-4" ng-repeat="product in pCtrl.mpProducts">
					<div class="thumbnail">
						<img
							ng-src="<c:url value="/resources/images/{{product.code}}.jpg"/>"
							alt="{{product.name}}" class="landingImg">
						<h5>{{product.name}}</h5>
						<hr />
						<div class="caption">
							<h4>{{product.unitPrice}} &#8364;</h4>
							<p>{{product.description}}</p>
							<a ng-href="${contextRoot}/show/{{product.id}}/product"
								class="btn btn-primary btn-block">View</a>
						</div>
					</div>
				</div>

				<div class="col-sm-12 text-center">
					<h4>Checkout more products!</h4>
					<hr />
					<a class="btn btn-warning btn-block"
						href="${contextRoot}/show/all/products">More Products</a>
				</div>

			</div>

		</div>

	</div>

</div>