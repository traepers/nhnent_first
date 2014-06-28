<%@ page contentType="text/html;charset=utf-8"%>

<script type='text/javascript'>
	window.opener.location.reload();

	setTimeout('self.close()', 2000);

	function resizeWindow(win) {
		var wid = win.document.body.offsetWidth + 30;
		var hei = win.document.body.offsetHeight + 40; //30 과 40은 넉넉하게 하려는 임의의 값임
		win.resizeTo(wid, hei);
		
	}
</script>
<body onload='resizeWindow(this)'>
	<p>${message}</p>
	<p>2초후 자동으로 닫힙니다.</p>

</body>