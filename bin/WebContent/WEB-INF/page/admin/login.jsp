<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/resource/css/mos-style.css">
</head>
<body>
	<div id="header">
		<div class="inHeaderLogin"></div>
	</div>

	<div id="loginForm">
		<div class="headLoginForm">Đăng nhập quản trị</div>
		<div class="fieldLogin">
			<form method="POST" action="login" onsubmit="return validateForm()">
				<label style="color:red">${message}</label> <br>
				<label>Tên người dùng</label> <br> <input type="text" id="username" name="username" class="login">
				<br> <label>Mật khẩu</label> <br> <input type="password" id="password" name="password"
					class="login"> <br> <input type="submit"
					class="button" value="Đăng nhập">
			</form>
			<script type="text/javascript">
				function validateForm(){
					var username = document.getElementById('username').value;
					var password = document.getElementById('password').value;
					if(username == ''){
						alert("Tên đăng nhập không được bỏ trống!");
						return false;
					}else if(password == ''){
						alert("Mật khẩu không được bỏ trống!");
						return false;
					}
					return true;
				}
			</script>
		</div>
	</div>
</body>
</html>