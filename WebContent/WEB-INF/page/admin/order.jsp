<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage order</title>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/resource/css/mos-style.css">
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
					<th class="data" align="center">Ngày xác nhận</th>
					<th class="data" align="center">Trạng thái</th>
					<th class="data" align="center" width="75px">Tùy chọn</th>
				</tr>
				<tr class="data">
					<td class="data" width="30px">1</td>
					<td class="data">Nguyen Van An</td>
					<td class="data">016897779122</td>
					<td class="data">An Giang</td>
					<td class="data">1/1/2017</td>
					<td class="data">1/1/2017</td>
					<td class="data" align="center"><a href="confirm_order?id=1"><img src="resource/img/active.png"></a></td>
					<td class="data" width="75px">
						<center>
							<a href="detail_order?id=1"><img align="middle" src="resource/img/detail.png" />
							</a>&nbsp;&nbsp;&nbsp; <a href="delete_order?id=1"> <img align="middle"
								src="resource/img/delete.png">
							</a>
						</center>
					</td>
				</tr>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>