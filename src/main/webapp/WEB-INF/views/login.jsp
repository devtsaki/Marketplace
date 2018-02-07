<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Marketplace - ${title}</title>
<script>
	window.menu = "${title}";
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">



<!-- Custom CSS -->
<link href="<c:url value="/resources/css/myapp.css"/> " rel="stylesheet">


</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a href="${contextRoot}/home" class="navbar-brand">Marketplace</a>
				</div>
			</div>
		</nav>

		<div class="content">
			<div class="container">
			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger">
							${message}
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success">
							${logout}
						</div>
					</div>
				</div>
			</c:if>
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Login</h4>
							</div>
							<div class="panel-body">
								<form:form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
									<div class="from-group">
										<label for="username" class="col-md-4 control-label">Email</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username" class="form-control"/>
										</div>
									</div>
									<div class="from-group">
										<label for="password" class="col-md-4 control-label">Password</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password" class="form-control"/>
										</div>
									</div>
									<div class="from-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary"/>
										</div>
									</div>
								</form:form>
							</div>
							<div class="panel-footer">
								<div class="text-right">
									<a href="${contextRoot}/register">Sign Up</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="<c:url value="/resources/js/jquery.js"/>"></script>

		<script src="<c:url value="/resources/js/jquery.validate.js"/>"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

		<!-- My custom script -->
		<script src="<c:url value="/resources/js/myapp.js"/>"></script>
	</div>
</body>

</html>
