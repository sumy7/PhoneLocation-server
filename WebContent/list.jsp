<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>手机列表</title>

<jsp:include page="head.jsp" />
</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<h1 class="page-header">手机列表</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>手机序列号</th>
					<th>经度坐标</th>
					<th>纬度坐标</th>
					<th>精度半径</th>
					<th>最后更新时间</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${phonelist}" var="phone" varStatus="status">
					<tr>
						<td><c:out value="${status.count}" /></td>
						<td><c:out value="${phone.name}" /></td>
						<td><c:out value="${phone.x}" /></td>
						<td><c:out value="${phone.y}" /></td>
						<td><c:out value="${phone.radius}" /></td>
						<td><c:out value="${phone.date}" /></td>
						<td><button class="btn btn-info" role="button"
								data-toggle="modal" data-target="#mapModal"
								onclick="showMap('${phone.name}')">地图</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- sample modal content -->
		<div id="mapModal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">地图展示</h4>
					</div>
					<div class="modal-body">

						<div id="mapcontainer"
							style="width: 700px; height: 340px; border: 1px solid gray"></div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
</body>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
<script type="text/javascript">
	var map = new BMap.Map("mapcontainer");
	map.enableScrollWheelZoom();

	function showMap(phonename) {
		$
				.ajax({
					type : "get",
					dataType : "json",
					url : "find/" + phonename,
					success : function(msg) {
						var point = new BMap.Point(msg.x, msg.y);
						var radius = msg.radius;
						var labeltext = phonename;
						var titletext = "你的手机位置";
						showBaiduMap(point, msg.x, msg.y, radius, labeltext,
								titletext);
					}
				});
	}

	function showBaiduMap(point, x, y, radius, labeltext, titletext) {

		map.centerAndZoom(new BMap.Point(x - 0.003, y + 0.001), 18);

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
	}
</script>

</html>
