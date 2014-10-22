<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<jsp:include page="head.jsp" />
<style type="text/css">

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
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
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
<jsp:include page="navbar.jsp" />
	${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
	<div class="container">
		<form class="form-signin" role="form" action="j_spring_security_check"
			method="post">
			<h2 class="form-signin-heading">请登录</h2>
			<input type="text" class="form-control" name="j_username"
				placeholder="用户名" required autofocus> <input type="password"
				class="form-control" name="j_password" placeholder="密码" required>
			<br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>