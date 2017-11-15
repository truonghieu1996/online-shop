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
<title>Insert category</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>${ noti }</p>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Thêm danh mục</h3>
			<form action="add_category" method="post" onsubmit="return validateForm()">
				<table width="95%">
					<tr>
						<td width="125px"><b>Tên danh mục</b></td>
						<td><input type="text" class="pendek" id="Category_name" name="Category_name"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Thêm">
						</td>
					</tr>
				</table>
				<script type="text/javascript">
					function validateForm(){
						var nameCategory = document.getElementById('Category_name').value;
						if(nameCategory == ''){
							alert("Tên danh mục không được bỏ trống!");
							return false;
						}
						return true;
					}
				</script>
			</form>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>