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
			<form method="POST" action="">
				<label>Tên người dùng</label> <br> <input type="text" class="login">
				<br> <label>Mật khẩu</label> <br> <input type="password"
					class="login"> <br> <input type="submit"
					class="button" value="Đăng nhập">
			</form>
		</div>
	</div>
</body>
</html>