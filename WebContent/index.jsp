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

		<div class="starter-template">
			<h1>Hello World</h1>
			<p class="lead">这里还没想好写什么，到时候再添加吧。</p>
		</div>

	</div>
	<!-- /.container -->
</body>

</html>
