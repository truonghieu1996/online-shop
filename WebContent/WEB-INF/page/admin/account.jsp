<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Account</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${root}/resource/css/mos-style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Quản lí tài khoản</h3>
			<table class="data">

				<tr class="data">
					<th align="center" class="data">Họ và tên</th>
					<th align="center" class="data">Tên đăng nhâp</th>
					<th align="center" class="data">Quyền hạng</th>
					<th align="center" class="data" width="75px">Tùy chọn</th>
				</tr>
				<c:if test="${noti == true}">
					<c:forEach items="${listaccount}" var="account">
						<tr class="data">
							<td class="data">${account.displayname}</td>
							<td class="data">${account.username}</td>
							<td class="data"><c:if test="${account.role == 1}">Quản trị viên</c:if>
								<c:if test="${account.role != 1}">Quản lí</c:if></td>
							<td class="data" width="75px">
								<center>
									<c:if test="${account.role != 1}">
									<a
											onclick="return confirm('Bạn có muốn xóa tài khoản ${account.displayname} ?')"
											href="delete_account?username=${account.username}">Xóa</a>
									</c:if>
								</center>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${noti == false}">
					<tr class="data"></tr>
				</c:if>
			</table>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>