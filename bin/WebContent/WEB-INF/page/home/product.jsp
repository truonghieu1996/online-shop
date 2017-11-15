<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<c:forEach items="${listProduct}" var="product">
			<a href="detail_product?id=${product.id}">
				<div class="card fill-card">
					<img width="388" height="180" class="card-img-top"
						src="./resource/upload/${product.image}" alt="${product.name}">
					<div class="card-body">
						<h3 class="card-text">${product.name}</h3>
						<p class="card-text price">
							<fmt:formatNumber type="number" pattern="###,###,###"
								value="${product.price}" />
							VNĐ
						</p>
					</div>
					<div class="info">
						<span class="name-info"><h5>${product.name}</h5></span> <span
							class="price-info"> <strong>Giá: <fmt:formatNumber
									type="number" pattern="###,###,###" value="${product.price}" />
								VNĐ
						</strong>
						</span> <span>${product.description}</span>
					</div>
				</div>
			</a>
		</c:forEach>
		<c:if test="${message != ''}">
			<p>${message}</p>
		</c:if>
	</div>
	<!-- *************end product homepage**************** -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>