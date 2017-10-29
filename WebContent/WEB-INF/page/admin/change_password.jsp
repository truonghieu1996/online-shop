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
<title>Change password</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Thay đổi mật khẩu</h3>
			<form action="change_password" method="post" onsubmit="return validateForm()">
				<table width="95%">
					<tr>
						<td width="125px"><b>Mật khẩu cũ</b></td>
						<td><input type="password" class="pendek" id="passwordOld"
							name="passwordOld" value=""><span style="color:red">${message}</span></td>
					</tr>
					<tr>
						<td width="125px"><b>Mật khẩu mới</b></td>
						<td><input type="password" class="pendek" id="passwordNew"
							name="passwordNew" value=""></td>
					</tr>
					<tr>
						<td width="125px"><b>Xác nhận mật khẩu mới</b></td>
						<td><input type="password" class="pendek" id="passwordConfirm"
							name="passwordConfirm" value=""></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Cập nhật">
						</td>
					</tr>
				</table>
				<script type="text/javascript">
					function validateForm(){
						var passwordOld = document.getElementById('passwordOld').value;
						var passwordNew = document.getElementById('passwordNew').value;
						var passwordConfirm = document.getElementById('passwordConfirm').value;
						if(passwordOld == ''){
							alert("Bạn chưa nhập mật khẩu cũ!");
							return false;
						}else if(passwordNew == ''){
							alert("Bạn chưa nhập mật khẩu mới!");
							return false;
						}else if(passwordConfirm != passwordNew){
							alert("Xác nhận mật khẩu không khớp!");
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