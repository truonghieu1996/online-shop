<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
<%-- <script src="${root}/resource/js/ckeditor/ckeditor.js"></script> --%>
<title>Update product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Cập nhật sản phẩm</h3>
			<form action="update_product" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
				<table width="95%">
					<tr>
						<td><b>Danh mục</b></td>
						<td><select id="idCategory" name="idCategory">
								<option value="0" selected>-- Chọn danh mục --</option>
								<c:forEach items="${listCategory}" var="category">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td width="125px"><b>Tên sản phẩm</b></td>
						<td><input type="text" class="sedang" id="nameProduct"
							name="nameProduct" value="${product.name}"></td>
						<td><input type="hidden" class="pendek" id="idProduct"
							name="idProduct" value="${product.id}"></td>
					</tr>
					<tr>
						<td><b>Giá</b></td>
						<td><input type="number" min="0" class="sedang"
							id="priceProduct" name="priceProduct" value="${product.price}"></td>
					</tr>
					<tr>
						<td><b>Số lượng</b></td>
						<td><input type="number" min="0" class="sedang"
							id="amountProduct" name="amountProduct" value="${product.amount}"></td>
					</tr>
					<tr>
							<td><b>Hình ảnh</b></td>
							<td>
								<input type="file" accept="image/*" id="imageProduct" name="imageProduct"/>
							</td> 
					</tr>
					
					<tr>
						<td><b>Chi tiết</b></td>
						<td><textarea id="descriptionProduct" name="descriptionProduct">${product.description}</textarea></td>
						<!-- class="form-control ckeditor" -->
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Cập nhật">
						</td>
					</tr>
				</table>
				<script type="text/javascript">
					function validateForm(){
						var idCategory = document.getElementById('idCategory').value;
						var nameProduct = document.getElementById('nameProduct').value;
						var priceProduct = document.getElementById('priceProduct').value;
						var description = document.getElementById('descriptionProduct').value;
						var imageProduct = document.getElementById('imageProduct').value;
						if(idCategory == 0){
							alert("Vui lòng chọn danh mục sản phẩm!");
							return false;
						}else if(nameProduct == ''){
							alert("Tên sản phẩm không được bỏ trống!");
							return false;
						}else if(priceProduct == 0){
							alert("Giá sản phẩm không được bỏ trống!");
							return false;
						}else if(description == ""){
							alert("Mô tả sản phẩm không được bỏ trống!");
							return false;
						}
						return true;
					}
					document.getElementById('idCategory').value = '${product.idCategory}';
				</script>
			</form>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>