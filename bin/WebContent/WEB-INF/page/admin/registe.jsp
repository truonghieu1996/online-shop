<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${root}/resource/css/mos-style.css">
<script src="${root}/resource/js/jquery.min.js" type="text/javascript"></script>
<title>Registe</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Đăng ký</h3>
			<form action="signin" method="post" onsubmit="return validateForm()">
				<table width="95%">
					<tr><td><b style="color:red;">${message}</b></td></tr>
					<tr>
						<td width="125px"><b>Họ và tên</b></td>
						<td><input type="text" class="sedang" id="fullname"
							name="fullname" value=""></td>
					</tr>
					<tr>
						<td width="125px"><b>Tên đăng nhập</b></td>
						<td><input type="text" class="sedang" id="username"
							name="username" value="" maxlength="50"><span id="user-result"></span></td>
					</tr>
					<tr>
						<td width="125px"><b>Mật khẩu</b></td>
						<td><input type="password" class="sedang" id="password"
							name="password" value=""></td>
					</tr>
					<tr>
						<td width="125px"><b>Xác nhận mật khẩu</b></td>
						<td><input type="password" class="sedang" id="confirmpassword"
							name="confirmpassword" value=""></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Đăng ký">
						</td>
					</tr>
				</table>
				<script type="text/javascript">
					function validateForm(){
						var fullname = document.getElementById('fullname').value;
						var username = document.getElementById('username').value;
						var password = document.getElementById('password').value;
						var check = document.getElementById('check').value;
						var confirmpassword = document.getElementById('confirmpassword').value;
						if(fullname == ''){
							alert("Họ và tên không được bỏ trống");
							return false;
						}else if(username == ''){
							alert("Tên đăng nhập không được bỏ trống");
							return false;
						}else if(password == ''){
							alert("Mật khẩu không được bỏ trống!");
							return false;
						}else if(password != confirmpassword){
							alert("Xác nhận mật khẩu không khớp!");
							return false;
						}else if(check == "Yes"){
				    		  alert("Tên đăng nhập đã tồn tại!");
				    		  return false;
				    	  }
						return true;
					}
				</script>

				<script type="text/javascript">
				      $(document).ready(function () {
				           var x_timer;
				           $("#username").keyup(function (e) {
				                clearTimeout(x_timer);
				                var user_name = $(this).val();
				                x_timer = setTimeout(function () {
				                    check_username_ajax(user_name);
				                }, 1000);
				                });
				 
				           function check_username_ajax(username) {
				                $("#user-result").html('<img src="resource/img/ajax-loader.gif" />');
				                $.post('check_username', {'username': username}, function (data) {
				                    $("#user-result").html(data);
				                 });
				           }
				       });
				      function chekHasUsername(){
				    	  
				    	  
				    	  return true;
				      }
				</script>
			</form>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>