<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<jsp:include page="head.jsp" />
<style type="text/css">
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin {
	margin-bottom: 10px;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: -1px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<form class="form-signin" role="form" action="register.do"
			method="post">
			<h2 class="form-signin-heading">注册</h2>
			<input type="text" class="form-control" name="j_username"
				placeholder="用户名" vlaue="${j_username}" required autofocus>
			<input type="password" class="form-control" name="j_password"
				placeholder="密码" vlaue="${j_password}" required> <input
				type="password" class="form-control" name="j_password_rep"
				vlaue="${j_password_rep}" placeholder="重复密码" required>
			<div class="input-group">
				<img src="captcha-image" id="kaptchaImage"
					style="margin-bottom: -3px" />
				<button type="button" class="btn btn-default" onclick="changeCode()">看不清?换一张</button>
			</div>
			<input type="text" class="form-control" name="j_code" maxlength="4"
				placeholder="验证码" required> <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
		</form>
	</div>
	<!-- /container -->

</body>

<script type="text/javascript">
	$(function() { //生成验证码         
		$('#kaptchaImage').click(
				function() {
					$(this).hide().attr('src',
							'captcha-image?' + Math.floor(Math.random() * 100))
							.fadeIn();
				});
	});

	window.onbeforeunload = function() {
		//关闭窗口时自动退出  
		if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
			alert(parent.document.location);
		}
	};

	function changeCode() { //刷新
		$('#kaptchaImage').hide().attr('src',
				'captcha-image?' + Math.floor(Math.random() * 100)).fadeIn();
		event.cancelBubble = true;
	}
</script>
</html>