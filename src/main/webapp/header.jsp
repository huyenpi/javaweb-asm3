<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PRJ321x</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/signup.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://kit.fontawesome.com/cfc845dddc.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<div class="prj_container">
		<div class="prj_header">
			<div class="prj_tophead">
				<div class="prj_welcome">
					<a style="text-decoration:none;"href="<c:url value='/home'/>"><h1>PRJ321x</h1></a>
					<p>Welcome to my Website</p>
				</div>
				<div class="prj_searchbox">
					<form action="<c:url value='/search'/>" method="post">
						<input type="text" name="search" class="search"
							placeholder="What are you looking for?">
						<button type="submit" class="search">GO</button>
					</form>
				</div>
			</div>
			<div class="prj_topnav">
				<a href="<c:url value='/prj321x?target=home'/>"
					<c:if test="${param.target=='home'}">style="color:orange;"</c:if>>Home</a>
				<a href="<c:url value='/prj321x?target=products'/>"
					<c:if test="${param.target=='products'}">style="color:orange;"</c:if>>Products</a>
				<a href="<c:url value='/prj321x?target=aboutus'/>"
					<c:if test="${param.target=='aboutus'}">style="color:orange;"</c:if>>About
					us</a> <span style="float: right;"> <c:if
						test="${check==1}">
						<a style="color:#00ccff;" href="<c:url value='/prj321x?target=home'/>">Welcome ${fn:toUpperCase(username)}</a>
						<a href="<c:url value='/prj321x?target=cart' />" <c:if test="${param.target=='cart'}">style="color:orange;"</c:if> >Cart</a>
						<a href="<c:url value='/prj321x?target=ordered'/>" <c:if test="${param.target=='ordered'}">style="color:orange;"</c:if>>Ordered</a>
						<a href="<c:url value='/prj321x?target=logout'/>">Log out</a>
					</c:if> <c:if test="${check != 1}">
						<a href="<c:url value='/prj321x?target=dologin'/>" <c:if test="${param.target=='dologin'}">style="color:orange;"</c:if>>Login</a>
						<a href="<c:url value='/prj321x?target=register'/>" <c:if test="${param.target=='register'}">style="color:orange;"</c:if>>Register</a></span>
				</c:if>
			</div>
		</div>