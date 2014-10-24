<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>主页</title>

<jsp:include page="head.jsp" />
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="jumbotron">
			<div class="row featurette">
				<div class="col-md-7">
					<h1 class="featurette-heading">开始吧！</h1>
					<p class="lead">扫描二维码，或点击按钮下载客户端。快来享受服务吧！</p>
					<p>
						<a class="btn btn-primary btn-lg" role="button"
							href="phonelocation.apk">下载客户端到电脑</a>
					</p>
				</div>
				<div class="col-md-5">
					<img class="featurette-image img-responsive" src="img/qrcode.png"
						alt="Generic placeholder image">
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
</body>

</html>
