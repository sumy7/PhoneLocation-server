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

<title>错误</title>


</head>

<body>
	<div>错误的设备号</div>
</body>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
</html>
