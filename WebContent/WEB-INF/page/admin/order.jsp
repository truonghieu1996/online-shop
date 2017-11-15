<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage order</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Quản lí đơn hàng</h3>
			<table class="data">
				<tr class="data">
					<th class="data" align="center" width="30px">No.</th>
					<th class="data" align="center">Họ và tên</th>
					<th class="data" align="center">SĐT</th>
					<th class="data" align="center">Địa chỉ</th>
					<th class="data" align="center">Ngày đặt</th>
					<th class="data" align="center">Ngày duyệt</th>
					<th class="data" align="center">Phương thức thanh toán</th>
					<th class="data" align="center">Trạng thái</th>
					<th class="data" align="center" width="75px">Tùy chọn</th>
				</tr>
				<c:forEach items="${listOrder}" var="order">
					<tr class="data">
						<td class="data" width="30px">${order.idCustomer}</td>
						<td class="data">${order.fullName}</td>
						<td class="data">${order.phonenumber}</td>
						<td class="data">${order.address}</td>
						<td class="data"><fmt:formatDate pattern = "dd/MM/yyyy" value = "${order.checkIn}" /></td>
						<td class="data">${order.checkOut}</td>
						<c:if test="${order.pamentMethod == 1}">
							<td class="data">Tại cửa hàng</td>
						</c:if>
						<c:if test="${order.pamentMethod == 2}">
							<td class="data">Khi nhận hàng</td>
						</c:if>
						<c:if test="${order.status == 1}">
							<td class="data" align="center"><a href="confirm_order?id=${order.idBill}&status=${order.status}"><img
								src="resource/img/active.png"></a></td>
						</c:if>
						<c:if test="${order.status == 0}">
							<td class="data" align="center"><a href="confirm_order?id=${order.idBill}&status=${order.status}"><img
								src="resource/img/ban.png"></a></td>
						</c:if>
						<td class="data" width="75px">
							<center>
								<a href="order_detail?id=${order.idBill}"><img align="middle"
									src="resource/img/detail.png" /> </a>&nbsp;&nbsp;&nbsp; <a
									href="delete_order?id=1"> <img align="middle"
									src="resource/img/delete.png">
								</a>
							</center>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>