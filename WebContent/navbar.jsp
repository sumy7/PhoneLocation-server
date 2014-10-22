<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">手机定位</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
				<li><a href="list">手机列表</a></li>
				<li><a href="changelog.jsp">更新日志</a></li>
				<li><a href="about.jsp">关于</a></li>
			</ul>
			<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link"><sec:authentication property="name"/></a></p>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>