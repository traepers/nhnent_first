<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app>
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
<script src="<c:url value="/resources/js/angular.min.js" />"></script>
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
<div align="center">
	<div id="fixed-menu">
		
			<h2>새로운 글 게시</h2>
		
	</div>



	<form id="myform" action="/test/writeBoard" method="GET" onsubmit="return validateForm();">
		이메일 : <input id="email" type="text" name="email" ng-model="email"><br> <!-- javascript 폼 체크 -->
		
		
		내용: <input type="text" name="content"><br> 
		비밀번호: <input type="password" name="pass"><br> 
		<input type="submit" value="제출">
	</form>
<h1>Hello, {{email}}</h1>
	</div>

</body>
</html>
