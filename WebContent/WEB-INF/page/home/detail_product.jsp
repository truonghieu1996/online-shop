<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${root}/resource/css/bootstrap.css">
<link rel="stylesheet" href="${root}/resource/css/font-awesome.min.css">
<link rel="stylesheet" href="${root}/resource/css/style.css">
<link rel="stylesheet" href="${root}/resource/css/product-detail.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${root}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resource/js/popper.min.js"></script>
<script src="${root}/resource/js/bootstrap.min.js"></script>
<title>Detail product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--************** Left content ***************-->
	<div class="container mt-3 mb-3" style="display: inline-block;">
		<div class="left-content col-md-4">
			<div class="product-image">
				<img src="./resource/upload/${product.image}" alt="${product.name}"
					alt="${product.name}">
			</div>
			<div class="add-product">
				<h4>
					<fmt:formatNumber type="number" pattern="###,###,###"
						value="${product.price}" />
					VNĐ
				</h4>
				<c:if test="${product.amount != 0}">
					<div class="btn btn-danger btn-cart">
						<a href="payment?id=${product.id}" style="color: white;">Mua
							Ngay</a>
					</div>
					<div class="btn btn-danger btn-cart">
						<a href="#" style="color: white;">Thêm Vào Giỏ Hàng</a>
					</div>
				</c:if>
			</div>
		</div>
		<!--**************** Product detail ******************-->
		<div class="right-content col-md-8">
			<nav id="navbar-example2" class="navbar navbar-light menu-product">
			<a class="navbar-brand" href="#"> ${product.name} <c:if
					test="${product.amount == 0}">
					<span style="color: red">(Tạm hết hàng)</span>
				</c:if> <c:if test="${product.amount != 0}">
					<span style="color: blue">(Còn hàng)</span>
				</c:if>
			</a> </nav>

			<div class="product-detail" data-spy="scroll"
				data-target="#navbar-example2" data-offset="0">
				<h4 id="short-info">Thông tin chi tiết sản phẩm</h4>
				<p>${product.description}</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>