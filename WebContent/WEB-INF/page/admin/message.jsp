<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
</head>
<body>
	<h1 style="color:blue" align="center">Thông báo từ hệ thống</h1>
	<h2 align="center" style="color:red">${message}</h2>
	<h3 align="center"><a href="${pageContext.request.contextPath}/admin">Về trang chủ</a></h3>
</body>
</html>