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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Marketplace - ${title}</title>
<script>
	window.menu = "${title}";
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


<!-- DataTables Bootstrap CSS -->
<link href="<c:url value="/resources/css/dataTables.bootstrap.css"/>" rel="stylesheet">


<!-- Custom CSS -->
<link href="<c:url value="/resources/css/myapp.css"/> " rel="stylesheet">


</head>

<body>
	<div class="wrapper">
<%@include file="flows-navbar.jsp" %>
		<!--  Page Content -->
		<div class="content">