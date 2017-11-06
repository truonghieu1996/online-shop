<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}" />
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
<title>footer</title>
</head>
<body>
	<!-- **************footer***************** -->
	<div class="footer">
		<div class="footer-top pt-5">
			<div class="container"
				style="display: flex; flex-direction: row; justify-content: center;">
				<div class="footer-content">
					<h4>Về Shop Online</h4>
					<p>
						Hệ thống Shop-Online chuyên phân phối các sản phẩm di động với <strong>chất
							lượng tốt nhất</strong>
					</p>
				</div>
				<div class="footer-content">
					<h4>Liên Hệ</h4>
					<p>
						NHB_TEAM - <strong>DTH15TH2</strong>
					</p>
					<p>
						<i class="fa fa-envelope-o" aria-hidden="true"></i>
						truonghieu682@email.com
					</p>
					<p>
						<i class="fa fa-phone" aria-hidden="true"></i> 01689.777.911
					</p>
				</div>
			</div>
			<div class="container"
				style="display: flex; justify-content: center; flex-direction: row;">
				<h4>Chứng nhận</h4>
				<div class="footer-content certify">
					<img src="${root}/resource/img/logo-dang-ky-voi-bo-cong-thuong.png" alt="">
				</div>
			</div>
		</div>
		<div class="footer-bot bg-dark py-2">
			<div class="container">
				<h5>
					COPY RIGHT &copy BY <strong>NHB_TEAM</strong>.
				</h5>
				<p>ALL RIGHTS RESERVED.</p>
			</div>
		</div>
	</div>
	<!-- **************end footer***************** -->
</body>
</html>