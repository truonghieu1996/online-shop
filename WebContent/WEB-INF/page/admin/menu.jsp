<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
</head>
<body>
	<div id="leftBar">
		<ul>
			<li><a href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
			<li><a href="${pageContext.request.contextPath}/mn_category">Danh mục</a></li>
			<li><a href="${pageContext.request.contextPath}/mn_product">Sản phẩm</a></li>
			<li><a href="${pageContext.request.contextPath}/view_bill">Hóa đơn</a></li>
			<c:if test="${role == 1}">
				<li><a href="${pageContext.request.contextPath}/view_statistical">Thống kê</a></li>
				<li><a href="${pageContext.request.contextPath}/mn_account">Tài khoản</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>