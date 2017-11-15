<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${root}/resource/css/bootstrap.css">
<link rel="stylesheet" href="${root}/resource/css/font-awesome.min.css">
<link rel="stylesheet" href="${root}/resource/css/style.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${root}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resource/js/popper.min.js"></script>
<script src="${root}/resource/js/bootstrap.min.js"></script>
<title>header</title>
</head>
<body>
	<!-- ********header******** -->
	<div class="header">
		<div class="header-top">
			<div class="container py-2">
				<div class="row">
					<a href="home"><img src="${root}/resource/img/Logo.jpg"
						style="width: 180px; height: 60px;" alt="Shop Online"></a>
					<div class="ml-auto">
						<ul class="">
							<li class="header-top-item"><a class="" href="cart.html"
								style="font-size: 1rem;">Giỏ Hàng
									<div class="cart">
										<i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i> <span
											style="color: black;">0</span>
									</div>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="header-bot">
			<nav class="navbar navbar-expand-lg navbar-light"
				style="background-color: #c5c5c5">
			<div class="container">
				<!-- <a type="aria-hidden" class="navbar-brand" href="#">Navbar</a> -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link active" href="home"><i class="fa fa-home" aria-hidden="true"></i> Trang Chủ</a></li>
						<c:forEach items="${listCategory}" var="category">
							<li class="nav-item"><a class="nav-link" href="view_product_idcategory?id=${category.id}">${category.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>
	<!-- *******end header******** -->
</body>
</html>