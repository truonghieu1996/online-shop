<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${root}/resource/css/bootstrap.css">
<link rel="stylesheet" href="${root}/resource/css/font-awesome.min.css">
<link rel="stylesheet" href="${root}/resource/css/style.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${root}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resource/js/popper.min.js"></script>
<script src="${root}/resource/js/bootstrap.min.js"></script>
<title>Message</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${checker == true}">
		<p style="color:blue">${message}</p>
		<a href="home">Tiếp tục mua hàng</a>
	</c:if>
	<c:if test="${checker == false}">
		<p style="color:red">${message}</p>
		<a href="home">Vui lòng kiểm tra lại thông tin đơn đặt hàng!</a>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>