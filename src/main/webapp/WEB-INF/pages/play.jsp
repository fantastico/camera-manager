<%@ include file="/common/taglibs.jsp"%>
<head>
<title><fmt:message key="cameraList.title" /></title>
<meta name="menu" content="cameraMenu" />

<script src="../scripts/socket.io-1.2.1.js"></script>
<script>
	var socket = io.connect("<%=com.cameramanager.Constants.CAMERA_SERVER_IP%>");
	socket.on('connection', function(data) {
		socket.emit('connect', {
			cameraeId : '${camera.apkId}',
			userKey : '${camera.userKey}'
		});
	});
</script>

</head>
<div class="col-sm-10">
	<h2>
		<fmt:message key='cameraList.heading' />
	</h2>

	<div id="actions" class="btn-group">
		<a class="btn btn-default" href="<c:url value='/camera/showCamera'/>">
			<i class="icon-ok"></i> <fmt:message key="button.return" />
		</a>
	</div>


	<div align="center">
		<object CLASSID="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B"
			width="500" height="300"
			CODEBASE="http://www.apple.com/qtactivex/qtplugin.cab">
			<!-- <param name="src" value="sample.mov"> -->
			<param name="qtsrc" value="rtsp://127.0.0.1:8554/xxx">
			<param name="autoplay" value="true">
			<param name="loop" value="false">
			<param name="controller" value="true">
			<embed src="sample.mov" qtsrc="rtsp://127.0.0.1:8554/xxx" width="700"
				height="500" autoplay="true" loop="false" controller="true"
				pluginspage="http://www.apple.com/quicktime/"></embed>
		</object>
	</div>

</div>