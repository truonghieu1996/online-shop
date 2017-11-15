<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail order</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Chi tiết đơn hàng</h3>
			<table class="data">
				<tr class="data">
					<th class="data" align="center" width="30px">No.</th>
					<th class="data" align="center">Danh mục</th>
					<th class="data" align="center">Sản phẩm</th>
					<th class="data" align="center">Đơn giá</th>
					<th class="data" align="center">Số lượng</th>
					<th class="data" align="center">Thành tiền</th>
				</tr>
				<c:forEach items="${listOrderDetail}" var="OrderDetail">
					<tr class="data">
						<td class="data" width="30px">${OrderDetail.idBillInf}</td>
						<td class="data">${OrderDetail.nameCategory}</td>
						<td class="data">${OrderDetail.nameProduct}</td>
						<td class="data"><fmt:formatNumber type="number"
								pattern="###,###,###" value="${OrderDetail.price}" /> VNĐ</td>
						<td class="data">${OrderDetail.amount}</td>
						<td class="data"><fmt:formatNumber type="number"
								pattern="###,###,###" value="${OrderDetail.totalPrice}" /> VNĐ</td>
					</tr>
				</c:forEach>
				<tr class="data">
					<td colspan="7"><i>Tổng tiền: <fmt:formatNumber
								type="number" pattern="###,###,###" value="${finalPrice}" /> VNĐ
					</i></td>
				</tr>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>