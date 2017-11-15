<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet" href="${root}/resource/css/payment.css">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${root}/resource/js/jquery-3.2.1.min.js"></script>
<script src="${root}/resource/js/popper.min.js"></script>
<script src="${root}/resource/js/bootstrap.min.js"></script>
<title>Online Shop</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form action="payment" method="post" onsubmit="return validateForm()">
		<input type="hidden" id="idProduct" name="idProduct"
			value="${product.id}">
		<div class="container payment mt-3 mb-3">
			<div class="person-info">
				<div class="payment-content">
					<h5>Họ và Tên:</h5>
					<input type="text" name="txtname" id="txtname">
				</div>
				<div class="payment-content">
					<h5>Số điện thoại:</h5>
					<input type="text" name="txtphone" id="txtphone" placeholder="01689777911">
				</div>
				<div class="payment-content">
					<h5>Số lượng:</h5>
					<input type="number" name="txtamount" id="txtamount" min="0" max="${product.amount}"
						value="1">
				</div>
			</div>
			<div class="payment-method">
				<div class="payment-content">
					<h5>Thanh toán:</h5>
					<select id="method" name="method">
						<option value="0" selected>-- Chọn phương thức thanh toán
							--</option>
						<option value="1">Thanh toán tại cửa hàng</option>
						<option value="2">Thanh toán khi nhận hàng</option>
					</select>
				</div>
			</div>
			<div class="delivery-method">
				<div class="customer-add mb-4">
					<div class="payment-content">
						<h5>Địa chỉ:</h5>
						<input type="text" name="txtaddress" id="txtaddress">
					</div>
				</div>
			</div>
			<div class="pay mb-3">
				<a href="javascript: history.go(-1)">
					<div class="btn btn-danger">Trở Lại</div>
				</a> <input type="submit" class="btn btn-danger ml-3" value="Thanh toán" />
			</div>
		</div>
	</form>
	<script type="text/javascript">
	function validateForm(){
		var fullName = document.getElementById('txtname').value;
		var address = document.getElementById('txtaddress').value;
		var phonenumber = document.getElementById('txtphone').value;
		var amount = document.getElementById('txtamount').value;
		var method = document.getElementById('method').value;
		if(fullName == ''){
			alert("Họ và tên không được bỏ trống!");
			return false;
		}else if(amount == 0){
			alert("Số lượng không được bỏ trống!");
			return false;
		}else if(method == 0){
			alert("Vui lòng chọn phương thức thanh toán!");
			return false;
		}else if(phonenumber == ''){
			alert("Số điện thoại không được bỏ trống!");
			return false;
		}else if(address == ''){
			alert("Địa chỉ không được bỏ trống!");
			return false;
		}else{
			var phoneno1 = /^\(?([0-9]{4})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
			var phoneno2 = /^\(?([0-9]{4})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{3})$/; 
		      if((phonenumber.match(phoneno1)) || (phonenumber.match(phoneno2))){  
		         return true;  
		      }else{  
		         alert("Số điện thoại nhập không đúng định dạng!");  
		         return false;  
		      }  
		}
		return true;
	} 
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>