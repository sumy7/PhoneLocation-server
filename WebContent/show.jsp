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

<title>显示位置</title>


</head>

<body>
	<div style="width: 400px; height: 300px; border: 1px solid gray"
		id="container"></div>
</body>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>

<script type="text/javascript">
	var point=new BMap.Point(${x},${y});
	var radius=${radius};
	var labeltext="${labeltext}";
	var titletext="${titletext}";
	
	var map = new BMap.Map("container");
	map.centerAndZoom(point, 18);
	map.enableScrollWheelZoom();
	var label = new BMap.Label(labeltext);
	var marker = new BMap.Marker(point);
	marker.setTitle(titletext);
	marker.setLabel(label);
	var circle = new BMap.Circle(point, radius);
	circle.setFillOpacity(0.5);
	circle.setFillColor("#f0ffff");
	circle.setStrokeWeight(2.0);
	map.addOverlay(circle);
	map.addOverlay(marker);

</script>
</html>
