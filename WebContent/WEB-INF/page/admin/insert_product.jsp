<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/resource/css/mos-style.css">
<title>Insert category</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
		<h3>Thêm sản phẩm</h3>
		<table width="95%">
			<tr>
				<td width="125px"><b>Input text pendek</b></td>
				<td><input type="text" class="pendek"></td>
			</tr>
			<tr>
				<td><b>Input text sedang</b></td>
				<td><input type="text" class="sedang"></td>
			</tr>
			<tr>
				<td><b>Input text panjang</b></td>
				<td><input type="text" class="panjang"></td>
			</tr>
			<tr>
				<td><b>Radio</b></td>
				<td><input type="radio" name="radio" id="radio" value="radio 1">Radio
					1 <input type="radio" name="radio" id="radio" value="radio 2">Radio
					2</td>
			</tr>
			<tr>
				<td><b>Checkbox</b></td>
				<td><input type="checkbox" name="checkbox" id="checkbox"
					value="checkbox 1">Checkbox 1<br> <input
					type="checkbox" name="checkbox" id="checkbox" value="checkbox 2">Checkbox
					2<br> <input type="checkbox" name="checkbox" id="checkbox"
					value="checkbox 3">Checkbox 3<br> <input
					type="checkbox" name="checkbox" id="checkbox" value="checkbox 4">Checkbox
					4<br></td>
			</tr>
			<tr>
				<td><b>Pilihan</b></td>
				<td><select>
						<option selected>-- pilihan --</option>
						<option value="">Pilihan</option>
				</select></td>
			</tr>
			<tr>
				<td><b>Textarea</b></td>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" class="button" value="Thêm"> 
					<input type="reset" class="button" value="Nhập lại">
				</td>
			</tr>
		</table>
	</div>
	<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>