
<%@ page contentType="text/html;charset=utf-8"%>


<!-- id, 기존 content 받아오기 -->
<%
	int id = Integer.parseInt(request.getParameter("id"));
	String content = (String) request.getParameter("content");
	String pass = (String) request.getParameter("pass");
%>
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

<title>NHN Enter first warm-up</title>

</head>

<body>
	<div align="center">
		<div id="fixed-menu">
			<h2>글 수정하기</h2>
		</div>
		<form action="/test/updateContent" method="POST">
			<input type="hidden" name="id" value=<%=id%>><br />
			<!--  
		<input type="hidden" name="pass" value='<%=pass%>'><br />
		-->

			내용: <input type="text" name="content" value='<%=content%>'><br />
			비밀번호: <input type="text" name="update_pass"><br /> <input
				type="submit" value="수정">
		</form>

	</div>
</body>
</html>