<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
<style>
fixed-menu {
	width: 100%;
	height: 80px;
	background-color: black;
	position: fixed;
	top: 0px;
	left: 0px;
}

</style>

<script>
	$(document).ready(function() {
		alert("테스트");
	});
	
	function validateForm() {
	    var x = document.forms["myform"]["email"].value;
	    var atpos = x.indexOf("@");
	    var dotpos = x.lastIndexOf(".");
	    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert("Not a valid e-mail address");
	        return false;
	    }
	    return true;
	}
	
</script>

<title>NHN Enter first warm-up</title>

</head>
<body>
	<div id="fixed-menu">
		<div align="center">
			<h2>새로운 글 게시</h2>
		</div>
	</div>

	<form id="myform" action="/test/writeBoard" method="GET" onsubmit="return validateForm();">
		이메일 : <input id="email" type="text" name="email"><br> <!-- javascript 폼 체크 -->
		내용: <input type="text" name="content"><br> 
		비밀번호: <input type="password" name="pass"><br> 
		<input type="submit" value="제출">
	</form>

	

</body>
</html>
