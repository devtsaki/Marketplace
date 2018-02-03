<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Marketplace - ${title}</title>
<script>
	window.menu = "${title}";
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<!-- Bootstrap Theme CSS -->
<link href="<c:url value="/resources/css/bootstrap-readable-theme.css"/> " rel="stylesheet">

<!-- DataTables Bootstrap CSS -->
<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet">


<!-- Custom CSS -->
<link href="<c:url value="/resources/css/myapp.css"/> " rel="stylesheet">


</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!--  Page Content -->
		<div class="content">

			<!-- Home Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- About Content -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Contact Content -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Products Content -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Single Product Content -->
			<c:if test="${userClickShowProduct== true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Admin Product Content -->
			<c:if test="${userClickManageProducts== true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="<c:url value="/resources/js/jquery.js"/>"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>" ></script>
		
		<!-- DataTbles -->
		<script src="<c:url value="/resources/js/jquery.dataTables.js"/>"></script>
		<script src="<c:url value="/resources/js/dataTables.bootstrap.js"/>"></script>

		<!-- BootBox -->
		<script src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
		
		<!-- My custom script -->
		<script src="<c:url value="/resources/js/myapp.js"/>" ></script>
	</div>
</body>

</html>
