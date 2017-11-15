<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setStatus(404);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="root" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords"
	content="404 iphone web template, Android web template, Smartphone web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<link href="${root}/resource/css/style_page_not_found.css" rel="stylesheet"
	type="text/css" media="all" />
<title>Page not found</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<h1>
				<a href="#">Ohh Shit !</a>
			</h1>
		</div>
	</div>
	<div class="content">
		<img src="${root}/resource/img/error-img.png" title="error" />
		<p>
			<span> <label>O</label>hh.....
			</span> Có vẻ trang bạn yêu cầu không tìm thấy nhỉ :( 
		</p>
		<a href="javascript: history.go(-1)">Về trang trước</a>
		<div class="copy-right">
			<p>&copy; Trương Hiếu - Phùng Nguyên - Bình Nguyễn | DH15TH - An
				Giang University</p>
		</div>
	</div>
</body>
</html>