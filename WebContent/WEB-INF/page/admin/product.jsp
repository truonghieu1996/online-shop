<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage product</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Quản lí sản phẩm</h3>
			<form action="add_product" method="get">
				<input type="submit" class="button" value="Thêm">
			</form>
			<table class="data">
				<tr class="data">
					<th align="center" class="data" width="5%">No</th>
					<th align="center" class="data" width="10%">Hình ảnh</th>
					<th align="center" class="data" width="20%">Danh mục</th>
					<th align="center" class="data" width="20%">Tên</th>
					<th align="center" class="data" width="20%">Giá</th>
					<th align="center" class="data" width="10%">Số lượng</th>
					<th align="center" class="data" width="15%">Tùy chọn</th>
				</tr>
				<c:if test="${noti == true}">
					<c:forEach items="${listProduct}" var="product">
						<tr class="data">
							<td class="data" width="30px">${product.id}</td>
							<td class="data"><img src="./resource/upload/${product.image}" width="80"/></td>
							<td class="data">${product.nameCategory}</td>
							<td class="data">${product.name}</td>
							<td class="data">
								<fmt:formatNumber type="number" pattern="###,###,###" value="${product.price}" /> VNĐ							
							</td>
							<c:if test="${product.amount == 0}">
								<td class="data">Hết hàng</td>
							</c:if>
							<c:if test="${product.amount > 0}">
								<td class="data">${product.amount}</td>
							</c:if>
							<td class="data" width="75px">
								<center>
									<a href="update_product?id=${product.id}"> Sửa </a>&nbsp;&nbsp;&nbsp;
									<a
										onclick="return confirm('Bạn có muốn xóa sản phẩm ${product.name} ?')"
										href="delete_product?id=${product.id}">Xóa</a>
								</center>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${noti == false}">
					<tr class="data">
					</tr>
				</c:if>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>