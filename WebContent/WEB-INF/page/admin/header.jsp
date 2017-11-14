<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				Xin chào, ${displayname}
				<br>
				<c:if test="${role == 1}">
					<a href="${pageContext.request.contextPath}/registe">Đăng Ký </a>|
				</c:if>
				<a href="${pageContext.request.contextPath}/change_password">Thay đổi mật khẩu </a>|
				<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>