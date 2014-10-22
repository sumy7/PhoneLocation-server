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

<title>关于</title>

<jsp:include page="head.jsp" />
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">

		<h1 class="page-header">关于网站</h1>
		<p>这是一个简易的显示您手机位置的网站。</p>
		<h1 class="page-header">关于隐私</h1>
		<p>程序不会在后台未经您同意私自上传位置信息。</p>
		<p>
			网站所保存的
			<mark>手机序列号</mark>
			是通过手机的特征码经过不可逆加密得出的，只用于识别手机，无其它任何意义。
		</p>
		<h1 class="page-header">关于开发</h1>
		<p>程序还在开发之中，请参阅 ChangeLog 。</p>

	</div>
	<!-- /.container -->
</body>

</html>
