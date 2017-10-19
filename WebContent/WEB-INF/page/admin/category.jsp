<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Category</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Quản lí danh mục</h3>
			<form action="add_category" method="get">
				<input type="submit" class="button" value="Thêm">
			</form>
			<table class="data">

				<tr class="data">
					<th align="center" class="data" width="30px">ID</th>
					<th align="center" class="data">Tên danh mục</th>
					<th align="center" class="data" width="75px">#</th>
				</tr>
				<c:forEach items="${listCategory}" var="category">
					<tr class="data">
						<td class="data" width="30px">${category.id}</td>
						<td class="data">${category.name}</td>
						<td class="data" width="75px">
							<center>
								<a href="update_category?id=${category.id}"> Sửa </a>&nbsp;&nbsp;&nbsp;
								<a
									onclick="return confirm('Bạn có muốn xóa danh mục ${category.name} ?')"
									href="delete_category?id=${category.id}">Xóa</a>
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