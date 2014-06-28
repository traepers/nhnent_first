<%@ page contentType="text/html;charset=utf-8"%>

<script type='text/javascript'>
	self.moveTo(50, 50);
	self.resizeTo(1000, 100);

	window.opener.location.reload();

	setTimeout('self.close()', 2000);

	function resizeWindow() {
		var width = 300;
		var height = 200;
		resizeTo(width, height);
		moveTo(((screen.width - width) / 2), ((screen.height - height) / 2));
	}
</script>

<html>
<body>
	<p>${message}</p>
	<p>2초후 자동으로 닫힙니다.</p>

</body>
</html>